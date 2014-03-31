package com.psdparser.generator.html;

public class DivTag extends Tag {

	@Override
	public String getHtml() throws Exception {
		return "<div " + getAttributes() + ">" + getContent() + "</div>";
	}
	
}
