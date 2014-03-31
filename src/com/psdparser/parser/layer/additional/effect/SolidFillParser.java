package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.SolidFill;
import com.psdparser.parser.common.KernelParser;


public class SolidFillParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_70055
	 * **/
	
	public static SolidFill parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		SolidFill solidFill = new SolidFill();
		solidFill.setSize(dis.readInt());
		solidFill.setVersion(dis.readInt());
		solidFill.setKey(KernelParser.parseString(dis, cis, 4));
		solidFill.setColor(KernelParser.parseString(dis, cis, 10));
		solidFill.setOpacity(Integer.valueOf(dis.read()));
		solidFill.setNativeColor(KernelParser.parseString(dis, cis, 10));
		
		return solidFill;
		
	}
}
