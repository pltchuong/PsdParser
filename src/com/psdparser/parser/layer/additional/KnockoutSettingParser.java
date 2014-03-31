package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.KnockoutSetting;

public class KnockoutSettingParser {

	/**
	 * Knockout setting (Photoshop 6.0)
	 * **/
	
	public static KnockoutSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		KnockoutSetting knockoutSetting = new KnockoutSetting();
		knockoutSetting.setValue(dis.readBoolean());
		
		return knockoutSetting;
		
	}
	
}
