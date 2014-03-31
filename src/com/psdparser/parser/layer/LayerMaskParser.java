package com.psdparser.parser.layer;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.LayerMask;

public class LayerMaskParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_22582
	 * **/
	
	public static LayerMask parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		int layerMaskLength = dis.readInt();
		if (layerMaskLength == 0) 
			return null;
		
		LayerMask layerMask = new LayerMask();
		layerMask.setTop(dis.readInt());
		layerMask.setLeft(dis.readInt());
		layerMask.setBottom(dis.readInt());
		layerMask.setRight(dis.readInt());
		layerMask.setColor(Integer.valueOf(dis.read()));
		layerMask.setFlags(Integer.valueOf(dis.readByte()));
		
		if(layerMaskLength == 20) {
			dis.skipBytes(2);
		} else {
			layerMask.setFlags(Integer.valueOf(dis.readByte()));
			layerMask.setColor(Integer.valueOf(dis.read()));
			layerMask.setTop(dis.readInt());
			layerMask.setLeft(dis.readInt());
			layerMask.setBottom(dis.readInt());
			layerMask.setRight(dis.readInt());
		}
		
		return layerMask;
		
	}
	
}
