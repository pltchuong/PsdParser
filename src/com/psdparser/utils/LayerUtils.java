package com.psdparser.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.psdparser.generator.html.ImgTag;
import com.psdparser.generator.html.SpanTag;
import com.psdparser.generator.html.Tag;
import com.psdparser.model.Layer;
import com.psdparser.model.Psd;
import com.psdparser.model.common.Descriptor;
import com.psdparser.model.common.descriptor.RawDataDescriptor;
import com.psdparser.model.common.descriptor.StringDescriptor;
import com.psdparser.model.layer.AdditionalLayer;
import com.psdparser.model.layer.additional.SectionDividerSetting;
import com.psdparser.model.layer.additional.TypeToolObjectSetting;

public class LayerUtils {

	public static Tag getTagFromLayer(Layer layer) throws Exception {
		
		Tag tag = null;
		
		// Check if this is text layer
//		TypeToolObjectSetting typeToolObjectSetting = getAdditionalLayerInformation(layer, TypeToolObjectSetting.class);
//		if (typeToolObjectSetting != null) {
//			tag = new SpanTag();
//			SpanTag spanTag = (SpanTag) tag;
//			
//			List<Descriptor> descriptors = typeToolObjectSetting.getTextData();
//			for (Descriptor descriptor : descriptors) {
//				if(descriptor instanceof RawDataDescriptor) {
//					RawDataDescriptor rawDataDescriptor = (RawDataDescriptor) descriptor;
//					Map<String, Object> properties = rawDataDescriptor.getProperties();
//					
//					spanTag.setContent((String)getValueFromMeta(properties, "EngineDict.Editor.Text"));
//					spanTag.setFontSize((Double)getValueFromMeta(properties, "EngineDict.StyleRun.RunArray.StyleSheet.StyleSheetData.FontSize"));
//					spanTag.setFontFamily((String)getValueFromMeta(properties, "DocumentResources.FontSet.Name"));
					
//					List<Double> colors = new ArrayList<Double>();
//					List<Double> rawColors = getValueFromMeta(properties, "EngineDict.StyleRun.RunArray.StyleSheet.StyleSheetData.FillColor.Values");
//					rawColors = rawColors.subList(1, rawColors.size());
//					for (Double rawColor : rawColors) {
//						colors.add(255 * rawColor);
//					}
//					spanTag.setColor(colors);
//				}
//			}
//		}
		
//		// Everything else should be image
//		else {
			tag = new ImgTag();
			ImgTag imgTag = (ImgTag) tag;
			imgTag.setSrc("images/" + layer.getIndex() + ".png");
//		}
		
		
		
		
//		SolidColorSheetSetting solidColorSheetSetting = getAdditionalLayerInformation(layer, SolidColorSheetSetting.class);
//		if(solidColorSheetSetting != null) {
//			List<Descriptor> descriptors = solidColorSheetSetting.getDescriptors();
//			for (Descriptor descriptor : descriptors) {
//				if(descriptor instanceof ExtendedDescriptor) {
//					ExtendedDescriptor extendedDescriptor = (ExtendedDescriptor) descriptor;
//					List<Descriptor> colorDescriptors = extendedDescriptor.getDescriptors();
//					List<Double> colors = new ArrayList<Double>();
//					for (Descriptor colorDescriptor : colorDescriptors) {
//						colors.add(((DoubleDescriptor)colorDescriptor).getValue());
//					}
//					
//					tag.setBackgroundColor(colors);
//				}
//			}
//		}

		tag.setTitle(layer.getName());
		tag.setTop(layer.getTop());
		tag.setLeft(layer.getLeft());
//		tag.setWidth(layer.getWidth());
//		tag.setHeight(layer.getHeight());
		
		tag.setOpacity(layer.getOpacity());
		
		return tag;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getValueFromMeta(Map<String, Object> properties, String key) {
		String[] keys = key.split("\\.");
		String subKeys = StringUtils.join(ArrayUtils.remove(keys, 0), ".");
		if(StringUtils.isBlank(subKeys)) {
			return (T) properties.get(keys[0]);
		} else {
			Object value = properties.get(keys[0]);
			if (value instanceof ArrayList) {
				ArrayList<Object> objects = (ArrayList<Object>)properties.get(keys[0]);
				for (Object object : objects) {
					if(object instanceof Map) {
						return getValueFromMeta((Map<String, Object>) object, subKeys);
					} else {
						break;
					}
				}
				return (T) objects;
			} else {
				if(keys.length == 1) {
					return (T) properties.get(keys[0]);
				} else {
					return getValueFromMeta((Map<String, Object>)properties.get(keys[0]), subKeys);
				}
			}
		}
		
//		Object value = properties.get(key);
//		if(value instanceof Map) {
//			getValueFromMeta((Map<String, Object>)value, key);
//		} else {
//			return value.toString();
//		}
		
//		String[] keys = key.split("\\.");
//		for (int i = 0; i < keys.length; i++) {
//			return getValueFromMeta((Map<String, Object>)properties.get(keys[i]), keys[i + 1]);
//		}
	}
	
	public static String getStringFromTypeToolObjectSetting(TypeToolObjectSetting typeToolObjectSetting) {
		List<Descriptor> descriptors = typeToolObjectSetting.getTextData();
		for (Descriptor descriptor : descriptors) {
			if(descriptor instanceof StringDescriptor) {
				return ((StringDescriptor)descriptor).getText();
			}
		}
		return null;
	}
	
	public static String getText(Layer layer) {
//		TypeToolObjectSetting typeToolObjectSetting = getAdditionalLayerInformation(layer, TypeToolObjectSetting.class);
//		if(typeToolObjectSetting != null) {
//			List<Descriptor> descriptors = typeToolObjectSetting.getTextData();
//			for (Descriptor descriptor : descriptors) {
//				if(descriptor instanceof RawDataDescriptor) {
//					RawDataDescriptor rawDataDescriptor = (RawDataDescriptor) descriptor;
//					Map<String, Object> properties = rawDataDescriptor.getProperties();
//					
//					tag.setContent((String)getValueFromMeta(properties, "EngineDict.Editor.Text"));
//					tag.setColor((List<Double>)getValueFromMeta(properties, "EngineDict.StyleRun.RunArray.StyleSheet.StyleSheetData.FillColor.Values"));
//					tag.setFontSize((Double)getValueFromMeta(properties, "EngineDict.StyleRun.RunArray.StyleSheet.StyleSheetData.FontSize"));
//					tag.setFontFamily((String)getValueFromMeta(properties, "DocumentResources.FontSet.Name"));
//				}
//			}
//		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getAdditionalLayerInformation(Layer layer, Class<T> clazz) {
		List<AdditionalLayer> additionalLayers = layer.getAdditionalLayers();
		for (AdditionalLayer additionalLayer : additionalLayers) {
			if(additionalLayer.getClass().equals(clazz)) {
				return (T) additionalLayer;
			}
		}
		return null;
	}
	
}
