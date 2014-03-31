package com.psdparser.parser.layer;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.AdditionalLayer;
import com.psdparser.parser.common.KernelParser;
import com.psdparser.parser.layer.additional.AnimationEffectsParser;
import com.psdparser.parser.layer.additional.BlackWhiteParser;
import com.psdparser.parser.layer.additional.BlendClippingElementsParser;
import com.psdparser.parser.layer.additional.BlendInteriorElementsParser;
import com.psdparser.parser.layer.additional.ContentGeneratorExtraDataParser;
import com.psdparser.parser.layer.additional.EffectsLayerParser;
import com.psdparser.parser.layer.additional.ExposureParser;
import com.psdparser.parser.layer.additional.FilterMaskParser;
import com.psdparser.parser.layer.additional.ForeignEffectIdParser;
import com.psdparser.parser.layer.additional.GradientFillSettingParser;
import com.psdparser.parser.layer.additional.KnockoutSettingParser;
import com.psdparser.parser.layer.additional.LayerIdParser;
import com.psdparser.parser.layer.additional.LayerNameSourceSettingParser;
import com.psdparser.parser.layer.additional.LayerOpacityParser;
import com.psdparser.parser.layer.additional.LayerVersionParser;
import com.psdparser.parser.layer.additional.MetadataSettingParser;
import com.psdparser.parser.layer.additional.ObjectBasedEffectsLayerInfoParser;
import com.psdparser.parser.layer.additional.PatternFillSettingParser;
import com.psdparser.parser.layer.additional.PlacedLayerDataParser;
import com.psdparser.parser.layer.additional.PlacedLayerParser;
import com.psdparser.parser.layer.additional.ProtectedSettingParser;
import com.psdparser.parser.layer.additional.ReferencePointParser;
import com.psdparser.parser.layer.additional.SavingMergedTransparencyParser;
import com.psdparser.parser.layer.additional.SectionDividerSettingParser;
import com.psdparser.parser.layer.additional.SheetColorSettingParser;
import com.psdparser.parser.layer.additional.SolidColorSheetSettingParser;
import com.psdparser.parser.layer.additional.TextEngineDataParser;
import com.psdparser.parser.layer.additional.TypeToolObjectSettingParser;
import com.psdparser.parser.layer.additional.UnicodeLayerNameParser;
import com.psdparser.parser.layer.additional.UnicodePathNameParser;
import com.psdparser.parser.layer.additional.UserMaskParser;
import com.psdparser.parser.layer.additional.UsingAlignedRenderingParser;
import com.psdparser.parser.layer.additional.VectorMaskSettingParser;
import com.psdparser.parser.layer.additional.VectorOriginationDataParser;
import com.psdparser.parser.layer.additional.VectorStrokeContentDataParser;
import com.psdparser.parser.layer.additional.VectorStrokeDataParser;
import com.psdparser.parser.layer.additional.VibranceParser;

public class AdditionalLayerParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_71546
	 * **/
	
	// TODO
	private static final String EFFECTS_LAYER 							= "lrFX";
	private static final String TYPE_TOOL_INFO 							= "tySh";
	private static final String UNICODE_LAYER_NAME 						= "luni";
	private static final String LAYER_ID 								= "lyid";
	private static final String OBJECT_BASED_EFFECTS_LAYER_INFO 		= "lfx2";
	private static final String PATTERN 								= "Patt";
	private static final String PATTERN_2 								= "Pat2";
	private static final String PATTERN_3 								= "Pat3";
	private static final String ANNOTATIONS 							= "Anno";
	private static final String BLEND_CLIPPING_ELEMENTS 				= "clbl";
	private static final String BLEND_INTERIOR_ELEMENTS 				= "infx";
	private static final String KNOCKOUT_SETTING 						= "knko";
	private static final String PROTECTED_SETTING 						= "lspf";
	private static final String SHEET_COLOR_SETTING 					= "lclr";
	private static final String REFERENCE_POINT 						= "fxrp";
	private static final String GRADIENT_SETTINGS 						= "grdm";
	private static final String SECTION_DIVIDER_SETTING 				= "lsct";
	private static final String CHANNEL_BLENDING_RESTRICTIONS_SETTING 	= "brst";
	private static final String SOLID_COLOR_SHEET_SETTING 				= "SoCo";
	private static final String PATTERN_FILL_SETTING 					= "PtFl";
	private static final String GRADIENT_FILL_SETTING 					= "GdFl";
	private static final String VECTOR_MASK_SETTING 					= "vmsk";
	private static final String VECTOR_MASK_SETTING_CS6 				= "vsms";
	private static final String TYPE_TOOL_OBJECT_SETTING 				= "TySh";
	private static final String FOREIGN_EFFECT_ID 						= "ffxi";
	private static final String LAYER_NAME_SOURCE_SETTING 				= "lnsr";
	private static final String PATTERN_DATA 							= "shpa";
	private static final String METADATA_SETTING 						= "shmd";
	private static final String LAYER_VERSION 							= "lyvr";
	private static final String TRANSPARENCY_SHAPES_LAYER 				= "tsly";
	private static final String LAYER_MASK_AS_GLOBAL_MASK 				= "lmgm";
	private static final String VECTOR_MASK_AS_GLOBAL_MASK 				= "vmgm";
	private static final String BRIGHTNESS_AND_CONTRAST 				= "brit";
	private static final String CHANNEL_MIXER 							= "mixr";
	private static final String COLOR_LOOKUP 							= "clrL";
	private static final String PLACED_LAYER 							= "PlLd";
	private static final String LINKED_LAYER 							= "lnkD";
	private static final String LINKED_LAYER_2 							= "lnk2";
	private static final String LINKED_LAYER_3 							= "lnk3";
	private static final String PHOTO_FILTER 							= "phfl";
	private static final String BLACK_WHITE 							= "blwh";
	private static final String CONTENT_GENERATOR_EXTRA_DATA 			= "CgEd";
	private static final String TEXT_ENGINE_DATA						= "Txt2";
	private static final String VIBRANCE								= "vibA";
	private static final String UNICODE_PATH_NAME						= "pths";
	private static final String ANIMATION_EFFECTS						= "anFX";
	private static final String FILTER_MASK								= "FMsk";
	private static final String PLACED_LAYER_DATA 						= "SoLd";
	private static final String VECTOR_STROKE_DATA 						= "vstk";
	private static final String VECTOR_STROKE_CONTENT_DATA  			= "vscg";
	private static final String USING_ALIGNED_RENDERING 				= "sn2P";
	private static final String VECTOR_ORIGINATION_DATA 				= "vogk";
	private static final String SAVING_MERGED_TRANSPARENCY 				= "Mtrn";
	private static final String SAVING_MERGED_TRANSPARENCY_16 			= "Mt16";
	private static final String SAVING_MERGED_TRANSPARENCY_32 			= "Mt32";
	private static final String USER_MASK 								= "LMsk";
	private static final String EXPOSURE 								= "expA";
	private static final String FILTER_EFFECTS 							= "FXid";
	private static final String FILTER_EFFECTS_2 						= "FEid";
	
	private static final String LEVELS 									= "levl";
	private static final String CURVES 									= "curv";
	private static final String HUE 									= "hue ";
	private static final String HUE_2 									= "hue2";
	private static final String COLOR_BALANCE 							= "blnc";
	private static final String INVERT 									= "nvrt";
	private static final String POSTERIZE 								= "post";
	private static final String THRESHOLD 								= "thrs";
	private static final String SELECTIVE_COLOR 						= "selc";
	private static final String LAYER_OPACITY 							= "iOpa";
	
	public static List<AdditionalLayer> parse(DataInputStream dis, CountingInputStream cis, int length) throws Exception {
		
		List<AdditionalLayer> additionalLayers = new ArrayList<AdditionalLayer>();
		
		while(length > 0) {
			String signature = KernelParser.parseString(dis, cis, 4);
			String key = KernelParser.parseString(dis, cis, 4);
			
			int additionalLayerLength = dis.readInt();
			int additionalLayerStart = cis.getCount();
			
			AdditionalLayer additionalLayer = null;
			
			if(EFFECTS_LAYER.equals(key)) {
				additionalLayer = EffectsLayerParser.parse(dis, cis, additionalLayerLength);
			} else if(UNICODE_LAYER_NAME.equals(key)) {
				additionalLayer = UnicodeLayerNameParser.parse(dis, cis, additionalLayerLength);
			} else if(LAYER_ID.equals(key)) {
				additionalLayer = LayerIdParser.parse(dis, cis, additionalLayerLength);
			} else if(OBJECT_BASED_EFFECTS_LAYER_INFO.equals(key)) {
				additionalLayer = ObjectBasedEffectsLayerInfoParser.parse(dis, cis, additionalLayerLength);
			} else if(BLEND_CLIPPING_ELEMENTS.equals(key)) {
				additionalLayer = BlendClippingElementsParser.parse(dis, cis, additionalLayerLength);
			} else if(BLEND_INTERIOR_ELEMENTS.equals(key)) {
				additionalLayer = BlendInteriorElementsParser.parse(dis, cis, additionalLayerLength);
			} else if(KNOCKOUT_SETTING.equals(key)) {
				additionalLayer = KnockoutSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(PROTECTED_SETTING.equals(key)) {
				additionalLayer = ProtectedSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(SHEET_COLOR_SETTING.equals(key)) {
				additionalLayer = SheetColorSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(REFERENCE_POINT.equals(key)) {
				additionalLayer = ReferencePointParser.parse(dis, cis, additionalLayerLength);
			} else if(SECTION_DIVIDER_SETTING.equals(key)) {
				additionalLayer = SectionDividerSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(SOLID_COLOR_SHEET_SETTING.equals(key)) {
				additionalLayer = SolidColorSheetSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(PATTERN_FILL_SETTING.equals(key)) {
				additionalLayer = PatternFillSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(GRADIENT_FILL_SETTING.equals(key)) {
				additionalLayer = GradientFillSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(VECTOR_MASK_SETTING.equals(key) || VECTOR_MASK_SETTING_CS6.equals(key)) {
				additionalLayer = VectorMaskSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(TYPE_TOOL_OBJECT_SETTING.equals(key)) {
				additionalLayer = TypeToolObjectSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(FOREIGN_EFFECT_ID.equals(key)) {
				additionalLayer = ForeignEffectIdParser.parse(dis, cis, additionalLayerLength);
			} else if(LAYER_NAME_SOURCE_SETTING.equals(key)) {
				additionalLayer = LayerNameSourceSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(METADATA_SETTING.equals(key)) {
				additionalLayer = MetadataSettingParser.parse(dis, cis, additionalLayerLength);
			} else if(LAYER_VERSION.equals(key)) {
				additionalLayer = LayerVersionParser.parse(dis, cis, additionalLayerLength);
			} else if(PLACED_LAYER.equals(key)) {
				additionalLayer = PlacedLayerParser.parse(dis, cis, additionalLayerLength);
			} else if(BLACK_WHITE.equals(key)) {
				additionalLayer = BlackWhiteParser.parse(dis, cis, additionalLayerLength);
			} else if(CONTENT_GENERATOR_EXTRA_DATA.equals(key)) {
				additionalLayer = ContentGeneratorExtraDataParser.parse(dis, cis, additionalLayerLength);
			} else if(TEXT_ENGINE_DATA.equals(key)) {
				additionalLayer = TextEngineDataParser.parse(dis, cis, additionalLayerLength);
			} else if(VIBRANCE.equals(key)) {
				additionalLayer = VibranceParser.parse(dis, cis, additionalLayerLength);
			} else if(UNICODE_PATH_NAME.equals(key)) {
				additionalLayer = UnicodePathNameParser.parse(dis, cis, additionalLayerLength);
			} else if(ANIMATION_EFFECTS.equals(key)) {
				additionalLayer = AnimationEffectsParser.parse(dis, cis, additionalLayerLength);
			} else if(FILTER_MASK.equals(key)) {
				additionalLayer = FilterMaskParser.parse(dis, cis, additionalLayerLength);
			} else if(PLACED_LAYER_DATA.equals(key)) {
				additionalLayer = PlacedLayerDataParser.parse(dis, cis, additionalLayerLength);
			} else if(VECTOR_STROKE_DATA.equals(key)) {
				additionalLayer = VectorStrokeDataParser.parse(dis, cis, additionalLayerLength);
			} else if(VECTOR_STROKE_CONTENT_DATA.equals(key)) {
				additionalLayer = VectorStrokeContentDataParser.parse(dis, cis, additionalLayerLength);
			} else if(USING_ALIGNED_RENDERING.equals(key)) {
				additionalLayer = UsingAlignedRenderingParser.parse(dis, cis, additionalLayerLength);
			} else if(VECTOR_ORIGINATION_DATA.equals(key)) {
				additionalLayer = VectorOriginationDataParser.parse(dis, cis, additionalLayerLength);
			} else if(SAVING_MERGED_TRANSPARENCY.equals(key) || SAVING_MERGED_TRANSPARENCY_16.equals(key) || SAVING_MERGED_TRANSPARENCY_32.equals(key)) {
				additionalLayer = SavingMergedTransparencyParser.parse(dis, cis, additionalLayerLength);
			} else if(USER_MASK.equals(key)) {
				additionalLayer = UserMaskParser.parse(dis, cis, additionalLayerLength);
			} else if(EXPOSURE.equals(key)) {
				additionalLayer = ExposureParser.parse(dis, cis, additionalLayerLength);
			} else if(LAYER_OPACITY.equals(key)) {
				additionalLayer = LayerOpacityParser.parse(dis, cis, additionalLayerLength);
			} else {
				additionalLayer = new AdditionalLayer();
				additionalLayer.setHex(KernelParser.parseHex(dis, cis, additionalLayerLength));
				
				System.err.println("AdditionalLayerParser: " + key + " is undocumented or not implemented");
			}
			
			additionalLayer.setSignature(signature);
			additionalLayer.setKey(key);
			
			additionalLayers.add(additionalLayer);
			
			dis.skipBytes(additionalLayerLength - (cis.getCount() - additionalLayerStart));
			
			length = length - 4 - 4 - 4 - additionalLayerLength;
		}
		
		return additionalLayers;
		
	}
	
}
