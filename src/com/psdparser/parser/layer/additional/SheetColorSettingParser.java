package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.SheetColorSetting;

public class SheetColorSettingParser {

	/**
	 * Sheet color setting (Photoshop 6.0)
	 * **/
	
	public static SheetColorSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		SheetColorSetting sheetColorSetting = new SheetColorSetting();
		sheetColorSetting.setColor(dis.readInt());
		sheetColorSetting.setColor2(dis.readInt());
		
		return sheetColorSetting;
		
	}
	
}
