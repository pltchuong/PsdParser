package com.psdparser.utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.List;

import com.psdparser.model.Layer;
import com.psdparser.model.Psd;
import com.psdparser.model.common.ChannelImage;

public class ImageUtils {

	public static BufferedImage toImage(Psd psd) {
		return toImage(psd.getImageData().getChannelImages(), psd.getFileHeader().getWidth(), psd.getFileHeader().getHeight(), false);
	}
	
	public static BufferedImage toImage(Layer layer) {
		return toImage(layer.getChannelImages(), layer.getWidth(), layer.getHeight(), true);
    }
	
	private static BufferedImage toImage(List<ChannelImage> channelImages, int width, int height, boolean isCompressed) {
		int opacity = -1;
		
        if (width == 0 || height == 0) {
            return null;
        }

        byte[] rChannel = getChannelData(ChannelImage.RED, channelImages, width, height, isCompressed);
        byte[] gChannel = getChannelData(ChannelImage.GREEN, channelImages, width, height, isCompressed);
        byte[] bChannel = getChannelData(ChannelImage.BLUE, channelImages, width, height, isCompressed);
        byte[] aChannel = getChannelData(ChannelImage.ALPHA, channelImages, width, height, isCompressed);
        
        applyOpacity(aChannel, opacity);

        BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int[] data = ((DataBufferInt) im.getRaster().getDataBuffer()).getData();
        int n = width * height - 1;
        while (n >= 0) {
        	int a = aChannel[n] & 0xff;
        	int r = rChannel[n] & 0xff;
        	int g = gChannel[n] & 0xff;
        	int b = bChannel[n] & 0xff;
            data[n] = a << 24 | r << 16 | g << 8 | b;
            n--;
        }
        
        return im;
	}
	
	private static byte[] getChannelData(int channelId, List<ChannelImage> channelImages, int width, int height, boolean isCompressed) {
		for (ChannelImage channelImage : channelImages) {
			if (channelId == channelImage.getId() && channelImage.getData() != null) {
				if(isCompressed) {
					byte[] uncompressedChannel = uncompress(channelImage.getData(), width, height);
					if (uncompressedChannel != null) {
						return uncompressedChannel;
					}
				} else {
					return channelImage.getData();
				}
			}
		}
		
        return fillBytes(width * height, (byte) (channelId == ChannelImage.ALPHA ? 255 : 0));
    }
	
	private static void applyOpacity(byte[] a, int opacity) {
        if (opacity != -1) {
            Double o = (opacity & 0xff) / 256.0;
            for (int i = 0; i < a.length; i++) {
                a[i] = (byte) ((a[i] & 0xff) * o);
            }
        }
    }
	
	private static byte[] fillBytes(int size, byte value) {
        byte[] result = new byte[size];
        if (value != 0) {
            for (int i = 0; i < size; i++) {
                result[i] = value;
            }
        }
        return result;
    }
	
	private static byte[] uncompress(byte[] srcData, int width, int height) {
        int compression = ((srcData[0] & 0xff) << 8) | (srcData[1] & 0xff);
        switch (compression) {
        case 0:	// Uncompressed
            return decodeUncompressedData(srcData, 0, width, height);
        case 1: // RLE
            return decodeRLEData(srcData, 2, width, height);
        default:
            throw new RuntimeException("Unsupported channel compression: " + compression);
        }
    }
	
	 private static byte[] decodeUncompressedData(byte[] data, int offset, int width, int height) {
         int size = width * height;
         byte[] b = new byte[size];
         System.arraycopy(data, offset, b, 0, size);
         return b;
     }

     private static byte[] decodeRLEData(byte[] data, int offset, int width, int height) {
         short[] lineLengths = new short[height];
         int srcPos = offset;
         for (int i = 0; i < height; i++) {
             lineLengths[i] = (short) (((data[srcPos] & 0xff) << 8) | (data[srcPos + 1] & 0xff));
             srcPos += 2;
         }

         byte[] b = new byte[width * height];
         int dstPos = 0;
         for (int i = 0; i < height; i++) {
             int len = lineLengths[i];
             decodeRLELine(data, srcPos, len, b, dstPos);
             srcPos += len;
             dstPos += width;
         }
         return b;
     }
     
     public static void decodeRLELine(byte[] src, int srcIndex, int slen, byte[] dst, int dstIndex) {
         int sIndex = srcIndex;
         int dIndex = dstIndex;
         int max = sIndex + slen;
         while (sIndex < max) {
             byte b = src[sIndex++];
             int n = b;
             if (n < 0) {
                 n = 1 - n;
                 b = src[sIndex++];
                 for (int i = 0; i < n; i++) {
                     dst[dIndex++] = b;
                 }
             } else {
                 n = n + 1;
                 System.arraycopy(src, sIndex, dst, dIndex, n);
                 dIndex += n;
                 sIndex += n;
             }
         }
     }
	
}
