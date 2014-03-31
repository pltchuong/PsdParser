package com.psdparser.parser;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.FileHeader;
import com.psdparser.model.FileHeader.ColorMode;
import com.psdparser.model.Psd;
import com.psdparser.parser.common.KernelParser;

public class FileHeaderParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_19840
	 * **/
	
	public static FileHeader parse(Psd psd, DataInputStream dis, CountingInputStream cis) throws Exception {

		FileHeader fileHeader = new FileHeader();
		fileHeader.setSignature(KernelParser.parseString(dis, cis, 4));
		fileHeader.setVersion(Integer.valueOf(dis.readShort()));
		fileHeader.setReserved(KernelParser.parseString(dis, cis, 6));
		fileHeader.setChannels(Integer.valueOf(dis.readShort()));
		fileHeader.setHeight(dis.readInt());
		fileHeader.setWidth(dis.readInt());
		fileHeader.setDepth(Integer.valueOf(dis.readShort()));
		fileHeader.setColorMode(ColorMode.findById(Integer.valueOf(dis.readShort())));
		
		return fileHeader;
		
	}

}
