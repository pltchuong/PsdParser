package com.psdparser.parser.layer;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.LayerBlendingRanges;

public class BlendingRangesParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_21332
	 * **/
	
	public static LayerBlendingRanges parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		int length = dis.readInt();
		
		LayerBlendingRanges layerBlendingRanges = new LayerBlendingRanges();
		layerBlendingRanges.setGrayBlackSource(Integer.valueOf(dis.readShort()));
		layerBlendingRanges.setGrayWhiteSource(Integer.valueOf(dis.readShort()));
		layerBlendingRanges.setGrayBlackDestination(Integer.valueOf(dis.readShort()));
		layerBlendingRanges.setGrayWhiteDestination(Integer.valueOf(dis.readShort()));
		layerBlendingRanges.setNumberOfBlendingChannels((length - 8) / 8);
		layerBlendingRanges.setChannelBlackSource(new Integer[layerBlendingRanges.getNumberOfBlendingChannels()]);
		layerBlendingRanges.setChannelWhiteSource(new Integer[layerBlendingRanges.getNumberOfBlendingChannels()]);
		layerBlendingRanges.setChannelBlackDestination(new Integer[layerBlendingRanges.getNumberOfBlendingChannels()]);
		layerBlendingRanges.setChannelWhiteDestination(new Integer[layerBlendingRanges.getNumberOfBlendingChannels()]);
		
		for (int i = 0; i < layerBlendingRanges.getNumberOfBlendingChannels(); i++) {
			layerBlendingRanges.getChannelBlackSource()[i] = Integer.valueOf(dis.readShort());
			layerBlendingRanges.getChannelWhiteSource()[i] = Integer.valueOf(dis.readShort());
			layerBlendingRanges.getChannelBlackDestination()[i] = Integer.valueOf(dis.readShort());
			layerBlendingRanges.getChannelWhiteDestination()[i] = Integer.valueOf(dis.readShort());
		}
		
		return layerBlendingRanges;
		
	}
	
}
