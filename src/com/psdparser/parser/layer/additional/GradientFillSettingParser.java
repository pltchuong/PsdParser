package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.PatternFillSetting;
import com.psdparser.parser.common.DescriptorParser;

public class GradientFillSettingParser {

	/**
	 * Pattern fill setting (Photoshop 6.0)
	 * **/
	
	public static PatternFillSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		PatternFillSetting patternFillSetting = new PatternFillSetting();
		patternFillSetting.setVersion(dis.readInt());
		patternFillSetting.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return patternFillSetting;
	}
	
}
