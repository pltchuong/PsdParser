package com.psdparser.generator.html;

import java.nio.charset.Charset;
import java.util.List;

public abstract class Tag {

	private Integer top;
	private Integer left;
	
	private String value;
	private String content;
	private List<Double> backgroundColor;
	
	private List<Double> color;
	private Double fontSize;
	private String fontFamily;
	
	private String title;
	private Integer width;
	private Integer height;
	private Integer opacity;
	
	public abstract String getHtml() throws Exception;
	
	protected String getAttributes() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("style=\"");
		
		stringBuilder.append("position: absolute;");
		stringBuilder.append(top == null ? "" : "top: " + top + "px; ");
		stringBuilder.append(left == null ? "" : "left: " + left + "px; ");
		
		stringBuilder.append(value == null ? "" : "value: " + value + "; ");
		stringBuilder.append(backgroundColor == null ? "" : "background-color: rgb(" + Math.round(backgroundColor.get(0)) + ", " + Math.round(backgroundColor.get(1)) + ", " + Math.round(backgroundColor.get(2)) + "); ");
		
		stringBuilder.append(color == null ? "" : "color: rgb(" + Math.round(color.get(0)) + ", " + Math.round(color.get(1)) + ", " + Math.round(color.get(2)) + "); ");
		stringBuilder.append(fontSize == null ? "" : "font-size: " + Math.round(fontSize) + "px;");
		stringBuilder.append(fontFamily == null ? "" : "font-family: " + (fontFamily.endsWith("MT") ? fontFamily.substring(0, fontFamily.length() - 2) : fontFamily) + "; ");
		
		stringBuilder.append(width == null ? "" : "width: " + width + "px; ");
		stringBuilder.append(height == null ? "" : "height: " + height + "px; ");
		stringBuilder.append(opacity == null ? "" : "opacity: " + ((double) opacity / 255) + "; ");
		
		stringBuilder.append("\" ");
		
		stringBuilder.append("title=\"" + new String(title.getBytes(Charset.defaultCharset())) + "\" ");
		
		return stringBuilder.toString();
	}
	
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Double> getColor() {
		return color;
	}
	public void setColor(List<Double> color) {
		this.color = color;
	}
	public List<Double> getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(List<Double> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getContent() throws Exception {
		return content == null ? "" : new String(content.getBytes("ISO-8859-1"));
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Double getFontSize() {
		return fontSize;
	}
	public void setFontSize(Double fontSize) {
		this.fontSize = fontSize;
	}
	public String getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
	}
	
}
