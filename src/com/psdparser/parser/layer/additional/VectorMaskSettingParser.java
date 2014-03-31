package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.VectorMaskSetting;
import com.psdparser.parser.common.PathParser;

public class VectorMaskSettingParser {

	/**
	 * Vector mask setting (Photoshop 6.0)
	 * **/
	
	public static VectorMaskSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		VectorMaskSetting vectorMaskSetting = new VectorMaskSetting();
		vectorMaskSetting.setVersion(dis.readInt());
		vectorMaskSetting.setFlags(dis.readInt());
		vectorMaskSetting.setPaths(PathParser.parse(dis, cis, additionalLayerLength));
		
		return vectorMaskSetting;
		
	}
	
}
