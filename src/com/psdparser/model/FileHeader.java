package com.psdparser.model;

public class FileHeader {
	
	private String signature;
	private Integer version;
	private String reserved;
	private Integer channels;
	private Integer width;
	private Integer height;
	private Integer depth;
	private ColorMode colorMode;
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public Integer getChannels() {
		return channels;
	}
	public void setChannels(Integer channels) {
		this.channels = channels;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public ColorMode getColorMode() {
		return colorMode;
	}
	public void setColorMode(ColorMode colorMode) {
		this.colorMode = colorMode;
	}
	
	public enum ColorMode {
		
		BITMAP(0, "Bitmap"),
		GRAYSCALE(1, "Grayscale"),
		INDEXED(2, "Indexed"),
		RGB(3, "RGB"),
		CMYK(4, "CMYK"),
		MULTICHANNEL(7, "Multichannel"),
		DUOTONE(8, "Duotone"),
		LAB(9, "Lab"),
		;
		
		private Integer id;
		private String description;
		
		private ColorMode(Integer id, String description) {
			this.id = id;
			this.description = description;
		}

		public static ColorMode findById(Integer id) {
			for (ColorMode colorMode : values()) {
				if(id == colorMode.id) {
					return colorMode;
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
