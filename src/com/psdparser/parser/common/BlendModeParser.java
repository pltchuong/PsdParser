package com.psdparser.parser.common;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.BlendMode;

public class BlendModeParser {

	/**
	 * Blend mode
	 * **/
	
	public static BlendMode parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		BlendMode blendMode = new BlendMode();
		blendMode.setSignature(KernelParser.parseString(dis, cis, 4));
		blendMode.setKey(KernelParser.parseString(dis, cis, 4));
		
		return blendMode;
		
	}
	
}
