package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.LayerId;

public class LayerIdParser {

	/**
	 * Layer ID (Photoshop 5.0)
	 * **/
	
	public static LayerId parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		LayerId layerId = new LayerId();
		layerId.setId(dis.readInt());
		
		return layerId;
		
	}
	
}
