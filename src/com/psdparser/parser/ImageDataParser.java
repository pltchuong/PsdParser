package com.psdparser.parser;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.FileHeader;
import com.psdparser.model.ImageData;
import com.psdparser.model.Psd;
import com.psdparser.model.ImageData.CompressionMethod;
import com.psdparser.model.common.ChannelImage;
import com.psdparser.parser.common.KernelParser;
import com.psdparser.utils.ImageUtils;

public class ImageDataParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_89817
	 * **/
	
	public static ImageData parse(Psd psd, DataInputStream dis, CountingInputStream cis, FileHeader fileHeader) throws Exception {

		ImageData imageData = new ImageData();
		imageData.setCompressionMethod(CompressionMethod.findById(Integer.valueOf(dis.readShort())));
		
		short[] lineLengths = null;
		int width = fileHeader.getWidth();
		int height = fileHeader.getHeight();
		if(imageData.getCompressionMethod() == CompressionMethod.RLE) {
            int nLines = height * fileHeader.getChannels();
            lineLengths = new short[nLines];
            for (int i = 0; i < nLines; i++) {
                lineLengths[i] = dis.readShort();
            }
        }
		
		List<ChannelImage> channelImages = new ArrayList<ChannelImage>();
		for (int i = 0; i < fileHeader.getChannels(); i++) {
			ChannelImage channelImage = new ChannelImage();
			channelImage.setId(i == 3 ? -1 : i);
			
			if(imageData.getCompressionMethod() == CompressionMethod.RLE) {
				byte[] data = new byte[width * height];
				byte[] s = new byte[width * 2];
                int pos = 0;
                int lineIndex = i * height;
                for (int j = 0; j < height; j++) {
                	int len = lineLengths[lineIndex++];
                	dis.read(s, 0, len);
                    ImageUtils.decodeRLELine(s, 0, len, data, pos);
                    pos += width;
                }
                channelImage.setData(data);
			} else {
				channelImage.setData(KernelParser.parseBytes(dis, cis, width * height));
			}
			
			channelImages.add(channelImage);
		}
		imageData.setChannelImages(channelImages);
		
		return imageData;
		
	}

}
