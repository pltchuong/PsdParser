package com.psdparser.parser;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.ImageResource;
import com.psdparser.model.Psd;
import com.psdparser.model.resources.Url;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class ImageResourcesParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_69883
	 * **/
	
	private static final int XMP_METADATA 			= 0x0424;
	private static final int CAPTION_DISGEST 		= 0x0425;
	private static final int MACINTOSH_NSPRINTINFO 	= 0x043C;
	private static final int GLOBAL_ALTITUDE 		= 0x0419;
	private static final int SHEET_DISCLOSURE 		= 0x0434;
	private static final int ONION_SKINS 			= 0x0436;
	private static final int COUNT_INFORMATION 		= 0x0438;
	private static final int PRINT_INFORMATION 		= 0x043A;
	private static final int PRINT_STYLE 			= 0x043B;
	private static final int TIMELINE_INFORMATION 	= 0x0433;
	private static final int VERSION_INFO 			= 0x0421;
	private static final int GLOBAL_ANGLE 			= 0x040D;
	private static final int LAYER_STATE_INFORMATION 		= 0x0400;
	private static final int LAYER_GROUP_INFORMATION 		= 0x0402;
	private static final int LAYER_SELECTION_ID  	= 0x042D;
	private static final int PRINT_SCALE  			= 0x0426;
	private static final int URL_LIST  				= 0x041E;
	private static final int PRINT_FLAGS  			= 0x03F3;
	private static final int GRID_AND_GUIDES_INFORMATION  	= 0x0408;
	
	
	private static final int EXIF_DATA_1 			= 0x0422;
	private static final int EXIF_DATA_3 			= 0x0423;
	private static final int ICC_PROFILE  			= 0x040F;
	private static final int COLOR_HALFTONING_INFORMATION 	= 0x03F5;
	private static final int COLOR_TRANSFER_FUNCTIONS 		= 0x03F8;
	
	
	public static List<ImageResource> parse(Psd psd, DataInputStream dis, CountingInputStream cis) throws Exception {
		
		List<ImageResource> imageResources = new ArrayList<ImageResource>();
		
		int imageResourcesLength = dis.readInt();
		while(imageResourcesLength > 0) {
			ImageResource imageResource = new ImageResource();
			imageResource.setSignature(KernelParser.parseString(dis, cis, 4));
			imageResource.setId(Integer.valueOf(dis.readShort()));
			imageResource.setName(KernelParser.parsePascalString(dis, cis, false));
			
			int imageResourceLength = dis.readInt();

			switch (imageResource.getId()) {
			case XMP_METADATA:
				imageResource.setXmpData(KernelParser.parseString(dis, cis, imageResourceLength));
				break;
			case CAPTION_DISGEST:
				imageResource.setCaptionDigest(KernelParser.parseBytes(dis, cis, 16));
				break;
			case MACINTOSH_NSPRINTINFO:
				imageResource.setMacintoshNSPrintInfo(KernelParser.parseString(dis, cis, imageResourceLength));
				break;
			case GLOBAL_ALTITUDE:
				imageResource.setGlobalAltitude(dis.readInt());
				break;
			case SHEET_DISCLOSURE:
				dis.readInt();
				imageResource.setSheetDisclosure(DescriptorParser.parse(dis, cis));
				break;
			case ONION_SKINS:
				dis.readInt();
				imageResource.setOnionSkins(DescriptorParser.parse(dis, cis));
				break;
			case PRINT_INFORMATION:
				dis.readInt();
				imageResource.setPrintInformation(DescriptorParser.parse(dis, cis));
				break;
			case COUNT_INFORMATION:
				dis.readInt();
				imageResource.setCountInformation(DescriptorParser.parse(dis, cis));
				break;
			case PRINT_STYLE:
				dis.readInt();
				imageResource.setPrintStyle(DescriptorParser.parse(dis, cis));
				break;
			case TIMELINE_INFORMATION:
				dis.readInt();
				imageResource.setTimelineInformation(DescriptorParser.parse(dis, cis));
				break;
			case VERSION_INFO:
				imageResource.setVersion(dis.readInt());
				imageResource.setHasRealMergedData(dis.readBoolean());
				imageResource.setWriterName(KernelParser.parseUnicodeString(dis, cis));
				imageResource.setReaderName(KernelParser.parseUnicodeString(dis, cis));
				imageResource.setFileVersion(dis.readInt());
				break;
			case GLOBAL_ANGLE:
				imageResource.setGlobalAngle(dis.readInt());
				break;
			case LAYER_STATE_INFORMATION:
				imageResource.setLayerStateInformation(Integer.valueOf(dis.readShort()));
				break;
			case LAYER_SELECTION_ID:
				int layerCount = dis.readShort();
				List<Integer> layerSelectionIds = new ArrayList<Integer>();
				for (int i = 0; i < layerCount; i++) {
					layerSelectionIds.add(dis.readInt());
				}
				imageResource.setLayerSelectionIds(layerSelectionIds);
				break;
			case PRINT_SCALE:
				imageResource.setPrintScaleStyle(Integer.valueOf(dis.readShort()));
				imageResource.setPrintScaleX(Float.intBitsToFloat(dis.readInt()));
				imageResource.setPrintScaleY(Float.intBitsToFloat(dis.readInt()));
				imageResource.setPrintScale(Float.intBitsToFloat(dis.readInt()));
				break;
			case URL_LIST:
				int urlCount = dis.readInt();
				List<Url> urls = new ArrayList<Url>();
				for (int i = 0; i < urlCount; i++) {
					int urlLength = dis.readInt();
					Url url = new Url();
					url.setId(KernelParser.parseString(dis, cis, 4));
					url.setValue(KernelParser.parseString(dis, cis, urlLength - 4));
					
					urls.add(url);
				}
				imageResource.setUrls(urls);
				break;
			case PRINT_FLAGS:
				imageResource.setPrintLabels(dis.readBoolean());
				imageResource.setPrintCropMarks(dis.readBoolean());
				imageResource.setPrintColorBars(dis.readBoolean());
				imageResource.setPrintRegistrationMarks(dis.readBoolean());
				imageResource.setPrintNegative(dis.readBoolean());
				imageResource.setPrintFlip(dis.readBoolean());
				imageResource.setPrintInterpolate(dis.readBoolean());
				imageResource.setPrintCaption(dis.readBoolean());
				imageResource.setPrintFlags(dis.readBoolean());
				break;
			case GRID_AND_GUIDES_INFORMATION:
				dis.readInt(); // version
				dis.readInt(); // horizontal
				dis.readInt(); // vertical
				
				System.out.println();
				break;
			
			case EXIF_DATA_1:
			case EXIF_DATA_3:
			case ICC_PROFILE:
			case COLOR_HALFTONING_INFORMATION:
			case COLOR_TRANSFER_FUNCTIONS:
			case LAYER_GROUP_INFORMATION:
				imageResource.setHex(KernelParser.parseHex(dis, cis, imageResourceLength));
				break;
				
				
			default:
				imageResource.setHex(KernelParser.parseHex(dis, cis, imageResourceLength));
				
				System.err.println("ImageResourcesParser: " + imageResource.getId() + " is undocumented or not implemented");
				
				break;
			}
			
			imageResources.add(imageResource);
			
			boolean isPadded = imageResourceLength % 2 == 0 ? false : true;
			dis.skipBytes(isPadded ? 1 : 0);
			imageResourcesLength = imageResourcesLength - 4 - 2 - 2 - 4 - imageResourceLength - (isPadded ? 1 : 0);
		}

		return imageResources;
		
	}

}
