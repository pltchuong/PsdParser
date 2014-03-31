package com.psdparser.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.SectionDividerSetting;
import com.psdparser.parser.ColorModeDataParser;
import com.psdparser.parser.FileHeaderParser;
import com.psdparser.parser.ImageDataParser;
import com.psdparser.parser.ImageResourcesParser;
import com.psdparser.parser.LayerParser;
import com.psdparser.utils.LayerUtils;

public class Psd {

	private File file;
	private FileHeader fileHeader;
	private ColorModeData colorModeData;
	private List<ImageResource> imageResources;
	private List<Layer> layers;
	private ImageData imageData;
	
	public Psd(String psdFile) throws Exception {
		file = new File(psdFile);
		
		CountingInputStream cis = new CountingInputStream(new BufferedInputStream(new FileInputStream(file)));
		DataInputStream dis = new DataInputStream(cis);
		
		fileHeader = FileHeaderParser.parse(this, dis, cis);
		colorModeData = ColorModeDataParser.parse(this, dis, cis);
		imageResources = ImageResourcesParser.parse(this, dis, cis);
		layers = LayerParser.parse(this, dis, cis);
		imageData = ImageDataParser.parse(this, dis, cis, getFileHeader());
		
		layers = makeLayersHierarchy(layers);
		layers = updateGroupsPosition(layers);
		layers = updateLayersIndex(layers, "");
        
		dis.close();
	}
	
	private List<Layer> makeLayersHierarchy(List<Layer> layers) {
		LinkedList<LinkedList<Layer>> tmpStack = new LinkedList<LinkedList<Layer>>();
        List<Layer> hierarchicalLayers = new ArrayList<Layer>();
        for (Layer layer : layers) {
        	SectionDividerSetting sectionDividerSetting = LayerUtils.getAdditionalLayerInformation(layer, SectionDividerSetting.class);
			if(sectionDividerSetting == null) {
				if (tmpStack.isEmpty()) {
                    hierarchicalLayers.add(layer);
                } else {
                    tmpStack.getFirst().add(layer);
                }
			} else {
				switch (sectionDividerSetting.getType()) {
		            case BOUNDING:
		                tmpStack.addFirst(new LinkedList<Layer>());
		                break;
		            case FOLDER:
		                layer.setLayers(new ArrayList<>(tmpStack.removeFirst()));
		                
		                if (tmpStack.isEmpty()) {
		                    hierarchicalLayers.add(layer);
		                } else {
		                    tmpStack.getFirst().add(layer);
		                }
		                break;
		            case OTHER:
		            	break;
	            }
			}
        }
        return hierarchicalLayers;
	}
	
	private List<Layer> updateLayersIndex(List<Layer> layers, String index) {
		int childIndex = 0;
		for (int i = layers.size() - 1; i >= 0; i--) {
			Layer layer = layers.get(i);
			
			if(layer.isClipping()) continue;
			
			layer.setIndex(index + childIndex);
			
			if(layer.isGroup() && !layer.isMergeable()) {
				updateLayersIndex(layer.getLayers(), index + childIndex);
			}
			
			childIndex++;
		}
		return layers;
	}
	
	private List<Layer> updateGroupsPosition(List<Layer> layers) {
		for (Layer layer : layers) {
			if(layer.isGroup()) {
				updateGroupsPosition(layer.getLayers());
				
				Integer top = null;
				Integer right = null;
				Integer bottom = null;
				Integer left = null;
				for (Layer child : layer.getLayers()) {
					if(top == null || top > child.getTop()) {
						top = child.getTop();
					}
					if(left == null || left > child.getLeft()) {
						left = child.getLeft();
					}
					if(bottom == null || bottom < child.getBottom()) {
						bottom = child.getLeft();
					}
					if(right == null || right < child.getRight()) {
						right = child.getRight();
					}
				}
				
				layer.setTop(top);
				layer.setRight(right);
				layer.setBottom(bottom);
				layer.setLeft(left);
			}
		}
		
		return layers;
	}
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public FileHeader getFileHeader() {
		return fileHeader;
	}
	public void setFileHeader(FileHeader fileHeader) {
		this.fileHeader = fileHeader;
	}
	public ColorModeData getColorModeData() {
		return colorModeData;
	}
	public void setColorModeData(ColorModeData colorModeData) {
		this.colorModeData = colorModeData;
	}
	public List<ImageResource> getImageResources() {
		return imageResources;
	}
	public void setImageResources(List<ImageResource> imageResources) {
		this.imageResources = imageResources;
	}
	public List<Layer> getLayers() {
		return layers;
	}
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	public ImageData getImageData() {
		return imageData;
	}
	public void setImageData(ImageData imageData) {
		this.imageData = imageData;
	}
	
}
