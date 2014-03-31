package com.psdparser.model.common;

public class ChannelImage {

	public static final Integer MASK = -2;
    public static final Integer ALPHA = -1;
    public static final Integer RED = 0;
    public static final Integer GREEN = 1;
    public static final Integer BLUE = 2;
	
    private Integer id;
	private Integer length;
	private byte[] data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
