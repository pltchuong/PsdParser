package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.SolidColorSheetSetting;
import com.psdparser.parser.common.DescriptorParser;

public class SolidColorSheetSettingParser {

	/**
	 * Solid color sheet setting (Photoshop 6.0)
	 * **/
	
	public static SolidColorSheetSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		SolidColorSheetSetting solidColorSheetSetting = new SolidColorSheetSetting();
		solidColorSheetSetting.setVersion(dis.readInt());
		solidColorSheetSetting.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return solidColorSheetSetting;
	}
	
}
