package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.EffectLayer;
import com.psdparser.model.layer.additional.EffectsLayer;
import com.psdparser.parser.common.KernelParser;
import com.psdparser.parser.layer.additional.effect.BevelInfoParser;
import com.psdparser.parser.layer.additional.effect.CommonStateInfoParser;
import com.psdparser.parser.layer.additional.effect.DropShadowInfoParser;
import com.psdparser.parser.layer.additional.effect.InnerGlowInfoParser;
import com.psdparser.parser.layer.additional.effect.InnerShadowInfoParser;
import com.psdparser.parser.layer.additional.effect.OuterGlowInfoParser;
import com.psdparser.parser.layer.additional.effect.SolidFillParser;

public class EffectsLayerParser {

	/**
	 * Effects Layer (Photoshop 5.0)
	 * **/
	
	private static final String COMMON_STATE_INFO 	= "cmnS";
	private static final String DROP_SHADOW_INFO 	= "dsdw";
	private static final String INNER_SHADOW_INFO 	= "isdw";
	private static final String OUTER_GLOW_INFO 	= "oglw";
	private static final String INNER_GLOW_INFO 	= "iglw";
	private static final String BEVEL_INFO 			= "bevl";
	private static final String SOLID_FILL 			= "sofi";
	
	public static EffectsLayer parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		int version = dis.readShort();
		int effectCount = dis.readShort();
		
		EffectsLayer effectsLayer = new EffectsLayer();
		
		List<EffectLayer> effectLayers = new ArrayList<EffectLayer>();
		for (int i = 0; i < effectCount; i++) {
			String effectSignature = KernelParser.parseString(dis, cis, 4);
			String type = KernelParser.parseString(dis, cis, 4);
			
			EffectLayer effectLayer = null;
			
			if(COMMON_STATE_INFO.equals(type)) {
				effectLayer = CommonStateInfoParser.parse(dis, cis);
			} else if(DROP_SHADOW_INFO.equals(type)) {
				effectLayer = DropShadowInfoParser.parse(dis, cis);
			} else if(INNER_SHADOW_INFO.equals(type)) {
				effectLayer = InnerShadowInfoParser.parse(dis, cis);
			} else if(OUTER_GLOW_INFO.equals(type)) {
				effectLayer = OuterGlowInfoParser.parse(dis, cis);
			} else if(INNER_GLOW_INFO.equals(type)) {
				effectLayer = InnerGlowInfoParser.parse(dis, cis);
			} else if(BEVEL_INFO.equals(type)) {
				effectLayer = BevelInfoParser.parse(dis, cis);
			} else if(SOLID_FILL.equals(type)) {
				effectLayer = SolidFillParser.parse(dis, cis);
			} else {
				effectLayer = new EffectLayer();
			}
			
			effectLayer.setVersion(version);
			effectLayer.setEffectSignature(effectSignature);
			effectLayer.setType(type);
			
			effectLayers.add(effectLayer);
		}
		effectsLayer.setEffectLayers(effectLayers);
		
		return effectsLayer;
	}
	
}
