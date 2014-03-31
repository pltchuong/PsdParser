package com.psdparser.parser.common;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.ChannelImage;

public class ChannelImageParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_26431
	 * **/
	
	public static List<ChannelImage> parseInfo(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		List<ChannelImage> channelImages = new ArrayList<ChannelImage>();
		int channelCount = dis.readShort();
		while(channelCount > 0) {
			ChannelImage channelImage = new ChannelImage();
			channelImage.setId(Integer.valueOf(dis.readShort()));
			channelImage.setLength(dis.readInt());
			
			channelImages.add(channelImage);
			
			channelCount--;
		}
		
		return channelImages;
	}
	
	public static void parseData(DataInputStream dis, CountingInputStream cis, List<ChannelImage> channelImages) throws Exception {
		
		for (ChannelImage channelImage : channelImages) {
			channelImage.setData(KernelParser.parseBytes(dis, cis, channelImage.getLength()));
		}
		
	}
	
}
