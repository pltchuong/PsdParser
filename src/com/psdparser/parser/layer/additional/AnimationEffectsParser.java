package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.AnimationEffects;
import com.psdparser.parser.common.DescriptorParser;

public class AnimationEffectsParser {

	/**
	 * Animation Effects (Photoshop CS6)
	 * **/
	
	public static AnimationEffects parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		AnimationEffects animationEffects = new AnimationEffects();
		animationEffects.setDescriptorVersion(dis.readInt());
		animationEffects.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return animationEffects;
		
	}
		
}
