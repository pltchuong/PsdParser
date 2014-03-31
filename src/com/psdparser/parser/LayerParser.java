package com.psdparser.parser;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.Layer;
import com.psdparser.model.Psd;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.ChannelImageParser;
import com.psdparser.parser.common.KernelParser;
import com.psdparser.parser.layer.AdditionalLayerParser;
import com.psdparser.parser.layer.BlendingRangesParser;
import com.psdparser.parser.layer.LayerMaskParser;

public class LayerParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_75067
	 * **/
	
	public static List<Layer> parse(Psd psd, DataInputStream dis, CountingInputStream cis) throws Exception {
		
		List<Layer> layers = new ArrayList<Layer>();
		
		int layerLength = dis.readInt();
		int layerStart = cis.getCount();
		
		@SuppressWarnings("unused")
		int layerInfoLength = dis.readInt();
		
		int layerCount = Math.abs(dis.readShort());
		for (int i = 0; i < layerCount; i++) {
			Layer layer = new Layer();
			layer.setPsd(psd);
			layer.setTop(dis.readInt());
			layer.setLeft(dis.readInt());
			layer.setBottom(dis.readInt());
			layer.setRight(dis.readInt());
			layer.setChannelImages(ChannelImageParser.parseInfo(dis, cis));
			layer.setBlendMode(BlendModeParser.parse(dis, cis));
			layer.setOpacity(dis.read());
			layer.setClipping(dis.readBoolean());
			layer.setFlags(dis.readByte());
			layer.setFiller(Integer.valueOf(dis.read()));
			
			int extraDataLength = dis.readInt();
			int extraDataStart = cis.getCount();
			
			layer.setLayerMask(LayerMaskParser.parse(dis, cis));
			layer.setLayerBlendingRanges(BlendingRangesParser.parse(dis, cis));
			layer.setName(KernelParser.parsePascalString(dis, cis, true));

			layer.setAdditionalLayers(AdditionalLayerParser.parse(dis, cis, extraDataLength - (cis.getCount() - extraDataStart)));
			
			layers.add(layer);
		}
		
		for (Layer layer : layers) {
			ChannelImageParser.parseData(dis, cis, layer.getChannelImages());
		}
		
		dis.skipBytes(layerLength - (cis.getCount() - layerStart));
		
		return layers;
		
	}

}
