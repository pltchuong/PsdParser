package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.MetadataSetting;
import com.psdparser.parser.common.KernelParser;

public class MetadataSettingParser {

	/**
	 * Metadata setting (Photoshop 6.0)
	 * **/
	
	public static MetadataSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		MetadataSetting metadataSetting = new MetadataSetting();
		
		List<MetadataSetting> metadataSettings = new ArrayList<MetadataSetting>();
		int metadataCount = dis.readInt();
		for (int i = 0; i < metadataCount; i++) {
			MetadataSetting subMetadataSetting = new MetadataSetting();
			subMetadataSetting.setMetadataSignature(KernelParser.parseString(dis, cis, 4));
			subMetadataSetting.setMetadataKey(KernelParser.parseString(dis, cis, 4));
			subMetadataSetting.setCopyOnSheetDuplication(dis.readBoolean());
			
			metadataSettings.add(subMetadataSetting);
		}
		metadataSetting.setMetadataSettings(metadataSettings);
		
		return metadataSetting;
		
	}
	
}
