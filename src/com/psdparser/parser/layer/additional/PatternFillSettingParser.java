package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.GradientFillSetting;
import com.psdparser.parser.common.DescriptorParser;

public class PatternFillSettingParser {

	/**
	 * Gradient fill setting (Photoshop 6.0)
	 * **/
	
	public static GradientFillSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		GradientFillSetting gradientFillSetting = new GradientFillSetting();
		gradientFillSetting.setVersion(dis.readInt());
		gradientFillSetting.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return gradientFillSetting;
	}
	
}
