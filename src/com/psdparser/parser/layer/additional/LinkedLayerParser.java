package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.LinkedLayer;

public class LinkedLayerParser {

	/**
	 * Linked Layer
	 * **/
	
//	TODO
	public static LinkedLayer parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		LinkedLayer linkedLayer = new LinkedLayer();
		
		return linkedLayer;
		
	}
		
}
