package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.FilterMask;
import com.psdparser.parser.common.KernelParser;

public class FilterMaskParser {

	/**
	 * Filter Mask (Photoshop CS3)
	 * **/
	
	public static FilterMask parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		FilterMask filterMask = new FilterMask();
		// TODO: what is the format of color space?
		filterMask.setColorSpace(KernelParser.parseString(dis, cis, 10));
		filterMask.setOpacity(Integer.valueOf(dis.readShort()));
		
		return filterMask;
		
	}
		
}
