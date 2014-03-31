package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.PlacedLayerData;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class PlacedLayerDataParser {

	/**
	 * Placed Layer Data
	 * **/
	
	public static PlacedLayerData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		PlacedLayerData placedLayerData = new PlacedLayerData();
		placedLayerData.setType(KernelParser.parseString(dis, cis, 4));
		placedLayerData.setPlVersion(dis.readInt());
		placedLayerData.setDescriptorVersion(dis.readInt());
		placedLayerData.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return placedLayerData;
		
	}
		
}
