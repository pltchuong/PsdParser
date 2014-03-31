package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.SectionDividerSetting;
import com.psdparser.parser.common.BlendModeParser;

public class SectionDividerSettingParser {

	/**
	 * Section divider setting
	 * **/
	
	public static SectionDividerSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		SectionDividerSetting sectionDividerSetting = new SectionDividerSetting();
		sectionDividerSetting.setType(dis.readInt());
		sectionDividerSetting.setBlendMode(additionalLayerLength >= 12 ? BlendModeParser.parse(dis, cis) : null);
		sectionDividerSetting.setSubType(additionalLayerLength >= 16 ? dis.readInt() : null);
		
		return sectionDividerSetting;
		
	}
	
}
