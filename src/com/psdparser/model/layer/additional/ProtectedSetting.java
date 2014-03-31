package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class ProtectedSetting extends AdditionalLayer {

	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
}
