package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.UserMask;
import com.psdparser.parser.common.KernelParser;

public class UserMaskParser {

	/**
	 * User Mask
	 * **/
	
	public static UserMask parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		UserMask userMask = new UserMask();
		// TODO: what is the format of color space?
		userMask.setColorSpace(KernelParser.parseString(dis, cis, 10));
		userMask.setOpacity(Integer.valueOf(dis.readShort()));
		userMask.setFlag(dis.readByte());
		
		return userMask;
		
	}
		
}
