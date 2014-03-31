package com.psdparser.model;

import java.util.List;

import com.psdparser.model.common.ChannelImage;


public class ImageData {

	private CompressionMethod compressionMethod;
	private List<ChannelImage> channelImages;
	
	public CompressionMethod getCompressionMethod() {
		return compressionMethod;
	}
	public void setCompressionMethod(CompressionMethod compressionMethod) {
		this.compressionMethod = compressionMethod;
	}
	public List<ChannelImage> getChannelImages() {
		return channelImages;
	}
	public void setChannelImages(List<ChannelImage> channelImages) {
		this.channelImages = channelImages;
	}
	
	public enum CompressionMethod {
		
		RAW(0, "Raw image data"),
		RLE(1, "RLE compression"),
		ZIP(2, "ZIP without prediction"),
		ZIP_PREDICTION(3, "ZIP with prediction"),
		;
		
		private Integer id;
		private String description;
		
		private CompressionMethod(Integer id, String description) {
			this.id = id;
			this.description = description;
		}

		public static CompressionMethod findById(Integer id) {
			for (CompressionMethod compressionMethod : values()) {
				if(id == compressionMethod.id) {
					return compressionMethod;
				}
			}
			return null;
		}
		
		@Override
		public String toString() {
			return this.id + "@" + this.description;
		}
	}
	
}
