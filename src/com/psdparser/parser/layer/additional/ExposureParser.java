package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.Exposure;

public class ExposureParser {

	/**
	 * Exposure
	 * **/
	
	public static Exposure parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		Exposure exposure = new Exposure();
		exposure.setVersion(Integer.valueOf(dis.readShort()));
		exposure.setExposure(dis.readInt());
		exposure.setOffset(dis.readInt());
		exposure.setGamma(dis.readInt());
		
		return exposure;
		
	}
		
}
