package com.psdparser.generator.html;

public class ImgTag extends Tag {

	private String src;
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	@Override
	public String getHtml() {
		return "<img " + getAttributes() + " src=\"" + src + "\" />";
	}
}
