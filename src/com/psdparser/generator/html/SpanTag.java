package com.psdparser.generator.html;

public class SpanTag extends Tag {

	@Override
	public String getHtml() throws Exception {
		return "<span " + getAttributes() + ">" + getContent() + "</span>";
	}
	
}
