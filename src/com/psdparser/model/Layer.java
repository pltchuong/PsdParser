package com.psdparser.model;

import java.util.ArrayList;
import java.util.List;

import com.psdparser.model.common.BlendMode;
import com.psdparser.model.common.ChannelImage;
import com.psdparser.model.layer.AdditionalLayer;
import com.psdparser.model.layer.LayerBlendingRanges;
import com.psdparser.model.layer.LayerMask;

public class Layer {
	
	private String name;
	private Integer top;
	private Integer left;
	private Integer bottom;
	private Integer right;
	private BlendMode blendMode;
	private Integer opacity;
	private byte flags;
	private Boolean isClipping;
	private Boolean transparencyProtected;
	private Boolean visible;
	private Boolean obsolete;
	private Boolean pixelDataIrrelevantValueUseful;
	private Boolean pixelDataIrrelevant;
	private Integer filler;
	private LayerMask layerMask;
	private LayerBlendingRanges layerBlendingRanges;
	private List<AdditionalLayer> additionalLayers;
	private List<ChannelImage> channelImages;
	
	private Psd psd;
	private List<Layer> layers = new ArrayList<Layer>();
	private String index;
	
	
	
	public boolean isGroup() {
		return !layers.isEmpty();
	}
	
	public boolean isMergeable() {
		return name.indexOf("*") >= 0;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getBottom() {
		return bottom;
	}
	public void setBottom(Integer bottom) {
		this.bottom = bottom;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
	public BlendMode getBlendMode() {
		return blendMode;
	}
	public void setBlendMode(BlendMode blendMode) {
		this.blendMode = blendMode;
	}
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
	}
	public byte getFlags() {
		return flags;
	}
	public void setFlags(byte flags) {
		this.flags = flags;
		
		transparencyProtected = (flags & 0x01) != 0;
		visible = ((flags >> 1) & 0x01) == 0;
		obsolete = ((flags >> 2) & 0x01) != 0;
		pixelDataIrrelevantValueUseful = ((flags >> 3) & 0x01) != 0;
		pixelDataIrrelevant = ((flags >> 4) & 0x01) != 0;
	}
	public Boolean isClipping() {
		return isClipping;
	}
	public void setClipping(Boolean isClipping) {
		this.isClipping = isClipping;
	}
	public Boolean isTransparencyProtected() {
		return transparencyProtected;
	}
	public void setTransparencyProtected(Boolean transparencyProtected) {
		this.transparencyProtected = transparencyProtected;
	}
	public Boolean isVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Boolean isObsolete() {
		return obsolete;
	}
	public void setObsolete(Boolean obsolete) {
		this.obsolete = obsolete;
	}
	public Boolean isPixelDataIrrelevantValueUseful() {
		return pixelDataIrrelevantValueUseful;
	}
	public void setPixelDataIrrelevantValueUseful(
			Boolean pixelDataIrrelevantValueUseful) {
		this.pixelDataIrrelevantValueUseful = pixelDataIrrelevantValueUseful;
	}
	public Boolean isPixelDataIrrelevant() {
		return pixelDataIrrelevant;
	}
	public void setPixelDataIrrelevant(Boolean pixelDataIrrelevant) {
		this.pixelDataIrrelevant = pixelDataIrrelevant;
	}
	public Integer getFiller() {
		return filler;
	}
	public void setFiller(Integer filler) {
		this.filler = filler;
	}
	public LayerMask getLayerMask() {
		return layerMask;
	}
	public void setLayerMask(LayerMask layerMask) {
		this.layerMask = layerMask;
	}
	public LayerBlendingRanges getLayerBlendingRanges() {
		return layerBlendingRanges;
	}
	public void setLayerBlendingRanges(LayerBlendingRanges blendingRanges) {
		this.layerBlendingRanges = blendingRanges;
	}
	public List<AdditionalLayer> getAdditionalLayers() {
		return additionalLayers;
	}
	public void setAdditionalLayers(List<AdditionalLayer> additionalLayers) {
		this.additionalLayers = additionalLayers;
	}
	public Integer getWidth() {
		return this.right - this.left;
	}
	public Integer getHeight() {
		return this.bottom - this.top;
	}
	public List<ChannelImage> getChannelImages() {
		return channelImages;
	}
	public void setChannelImages(List<ChannelImage> channelImages) {
		this.channelImages = channelImages;
	}
	public Psd getPsd() {
		return psd;
	}
	public void setPsd(Psd psd) {
		this.psd = psd;
	}
	public List<Layer> getLayers() {
		return layers;
	}
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}

}
