package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.PlacedLayer;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class PlacedLayerParser {

	/**
	 * Placed Layer
	 * **/
	
	public static PlacedLayer parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		PlacedLayer placedLayer = new PlacedLayer();
		placedLayer.setType(KernelParser.parseString(dis, cis, 4));
		placedLayer.setPlVersion(dis.readInt());
		placedLayer.setId(KernelParser.parsePascalString(dis, cis, false));
		placedLayer.setPage(dis.readInt());
		placedLayer.setTotalPages(dis.readInt());
		placedLayer.setAnitAliasPolicy(dis.readInt());
		placedLayer.setPlacedLayerType(dis.readInt());
		placedLayer.setTransformX1(dis.readDouble());
		placedLayer.setTransformY1(dis.readDouble());
		placedLayer.setTransformX2(dis.readDouble());
		placedLayer.setTransformY2(dis.readDouble());
		placedLayer.setTransformX3(dis.readDouble());
		placedLayer.setTransformY3(dis.readDouble());
		placedLayer.setTransformX4(dis.readDouble());
		placedLayer.setTransformY4(dis.readDouble());
		placedLayer.setWarpVersion(dis.readInt());
		placedLayer.setWarpDescriptorVersion(dis.readInt());
		placedLayer.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return placedLayer;
		
	}
		
}
