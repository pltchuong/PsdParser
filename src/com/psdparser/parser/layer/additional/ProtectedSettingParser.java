package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ProtectedSetting;

public class ProtectedSettingParser {

	/**
	 * Protected setting (Photoshop 6.0)
	 * **/
	
	public static ProtectedSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ProtectedSetting protectedSetting = new ProtectedSetting();
		protectedSetting.setId(dis.readInt());
		
		return protectedSetting;
		
	}
	
}
