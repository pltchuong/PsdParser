package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.layer.AdditionalLayer;

public class MetadataSetting extends AdditionalLayer {

	private String metadataSignature;
	private String metadataKey;
	private Boolean copyOnSheetDuplication;
	private List<MetadataSetting> metadataSettings;
	
	public String getMetadataSignature() {
		return metadataSignature;
	}
	public void setMetadataSignature(String metadataSignature) {
		this.metadataSignature = metadataSignature;
	}
	public String getMetadataKey() {
		return metadataKey;
	}
	public void setMetadataKey(String metadataKey) {
		this.metadataKey = metadataKey;
	}
	public Boolean isCopyOnSheetDuplication() {
		return copyOnSheetDuplication;
	}
	public void setCopyOnSheetDuplication(Boolean copyOnSheetDuplication) {
		this.copyOnSheetDuplication = copyOnSheetDuplication;
	}
	public List<MetadataSetting> getMetadataSettings() {
		return metadataSettings;
	}
	public void setMetadataSettings(List<MetadataSetting> metadataSettings) {
		this.metadataSettings = metadataSettings;
	}

}
