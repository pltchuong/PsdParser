package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.TypeToolObjectSetting;
import com.psdparser.parser.common.DescriptorParser;

public class TypeToolObjectSettingParser {

	/**
	 *  Type tool object setting (Photoshop 6.0)
	 * **/
	
	public static TypeToolObjectSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		TypeToolObjectSetting typeToolObjectSetting = new TypeToolObjectSetting();
		typeToolObjectSetting.setVersion(Integer.valueOf(dis.readShort()));
		typeToolObjectSetting.setTransformXX(dis.readDouble());
		typeToolObjectSetting.setTransformXY(dis.readDouble());
		typeToolObjectSetting.setTransformYX(dis.readDouble());
		typeToolObjectSetting.setTransformYY(dis.readDouble());
		typeToolObjectSetting.setTransformTX(dis.readDouble());
		typeToolObjectSetting.setTransformTY(dis.readDouble());
		typeToolObjectSetting.setTextVersion(Integer.valueOf(dis.readShort()));
		typeToolObjectSetting.setTextDescriptorVersion(dis.readInt());
		typeToolObjectSetting.setTextData(DescriptorParser.parse(dis, cis));
		typeToolObjectSetting.setWrapVersion(Integer.valueOf(dis.readShort()));
		typeToolObjectSetting.setWrapDescriptorVersion(dis.readInt());
		typeToolObjectSetting.setWrapData(DescriptorParser.parse(dis, cis));
		
		return typeToolObjectSetting;
		
	}
	
}
