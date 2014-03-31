package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.layer.AdditionalLayer;

public class TypeToolObjectSetting extends AdditionalLayer {

	private Integer version;
	private Double transformXX;
	private Double transformXY;
	private Double transformYX;
	private Double transformYY;
	private Double transformTX;
	private Double transformTY;
	private Integer textVersion;
	private Integer textDescriptorVersion;
	private List<Descriptor> textData;
	private Integer wrapVersion;
	private Integer wrapDescriptorVersion;
	private List<Descriptor> wrapData;

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Double getTransformXX() {
		return transformXX;
	}
	public void setTransformXX(Double transformXX) {
		this.transformXX = transformXX;
	}
	public Double getTransformXY() {
		return transformXY;
	}
	public void setTransformXY(Double transformXY) {
		this.transformXY = transformXY;
	}
	public Double getTransformYX() {
		return transformYX;
	}
	public void setTransformYX(Double transformYX) {
		this.transformYX = transformYX;
	}
	public Double getTransformYY() {
		return transformYY;
	}
	public void setTransformYY(Double transformYY) {
		this.transformYY = transformYY;
	}
	public Double getTransformTX() {
		return transformTX;
	}
	public void setTransformTX(Double transformTX) {
		this.transformTX = transformTX;
	}
	public Double getTransformTY() {
		return transformTY;
	}
	public void setTransformTY(Double transformTY) {
		this.transformTY = transformTY;
	}
	public Integer getTextVersion() {
		return textVersion;
	}
	public void setTextVersion(Integer textVersion) {
		this.textVersion = textVersion;
	}
	public Integer getTextDescriptorVersion() {
		return textDescriptorVersion;
	}
	public void setTextDescriptorVersion(Integer textDescriptorVersion) {
		this.textDescriptorVersion = textDescriptorVersion;
	}
	public List<Descriptor> getTextData() {
		return textData;
	}
	public void setTextData(List<Descriptor> textData) {
		this.textData = textData;
	}
	public Integer getWrapVersion() {
		return wrapVersion;
	}
	public void setWrapVersion(Integer wrapVersion) {
		this.wrapVersion = wrapVersion;
	}
	public Integer getWrapDescriptorVersion() {
		return wrapDescriptorVersion;
	}
	public void setWrapDescriptorVersion(Integer wrapDescriptorVersion) {
		this.wrapDescriptorVersion = wrapDescriptorVersion;
	}
	public List<Descriptor> getWrapData() {
		return wrapData;
	}
	public void setWrapData(List<Descriptor> wrapData) {
		this.wrapData = wrapData;
	}
	
}
