package com.psdparser.parser;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.ColorModeData;
import com.psdparser.model.Psd;
import com.psdparser.parser.common.KernelParser;

public class ColorModeDataParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_71638
	 * **/
	
	public static ColorModeData parse(Psd psd, DataInputStream dis, CountingInputStream cis) throws Exception {
		
		ColorModeData colorModeData = new ColorModeData();
		colorModeData.setLength(dis.readInt());
		colorModeData.setValue(KernelParser.parseHex(dis, cis, colorModeData.getLength()));
		
		return colorModeData;
	}
	
}
