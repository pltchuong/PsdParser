package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.layer.AdditionalLayer;

public class PlacedLayer extends AdditionalLayer {

	private String type;
	private Integer plVersion;
	private String id;
	private Integer page;
	private Integer totalPages;
	private Integer anitAliasPolicy;
	private Integer placedLayerType;
	private Double transformX1;
	private Double transformY1;
	private Double transformX2;
	private Double transformY2;
	private Double transformX3;
	private Double transformY3;
	private Double transformX4;
	private Double transformY4;
	private Integer warpVersion;
	private Integer warpDescriptorVersion;
	private List<Descriptor> descriptors;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPlVersion() {
		return plVersion;
	}
	public void setPlVersion(Integer plVersion) {
		this.plVersion = plVersion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getAnitAliasPolicy() {
		return anitAliasPolicy;
	}
	public void setAnitAliasPolicy(Integer anitAliasPolicy) {
		this.anitAliasPolicy = anitAliasPolicy;
	}
	public Integer getPlacedLayerType() {
		return placedLayerType;
	}
	public void setPlacedLayerType(Integer placedLayerType) {
		this.placedLayerType = placedLayerType;
	}
	public Double getTransformX1() {
		return transformX1;
	}
	public void setTransformX1(Double transformX1) {
		this.transformX1 = transformX1;
	}
	public Double getTransformY1() {
		return transformY1;
	}
	public void setTransformY1(Double transformY1) {
		this.transformY1 = transformY1;
	}
	public Double getTransformX2() {
		return transformX2;
	}
	public void setTransformX2(Double transformX2) {
		this.transformX2 = transformX2;
	}
	public Double getTransformY2() {
		return transformY2;
	}
	public void setTransformY2(Double transformY2) {
		this.transformY2 = transformY2;
	}
	public Double getTransformX3() {
		return transformX3;
	}
	public void setTransformX3(Double transformX3) {
		this.transformX3 = transformX3;
	}
	public Double getTransformY3() {
		return transformY3;
	}
	public void setTransformY3(Double transformY3) {
		this.transformY3 = transformY3;
	}
	public Double getTransformX4() {
		return transformX4;
	}
	public void setTransformX4(Double transformX4) {
		this.transformX4 = transformX4;
	}
	public Double getTransformY4() {
		return transformY4;
	}
	public void setTransformY4(Double transformY4) {
		this.transformY4 = transformY4;
	}
	public Integer getWarpVersion() {
		return warpVersion;
	}
	public void setWarpVersion(Integer warpVersion) {
		this.warpVersion = warpVersion;
	}
	public Integer getWarpDescriptorVersion() {
		return warpDescriptorVersion;
	}
	public void setWarpDescriptorVersion(Integer warpDescriptorVersion) {
		this.warpDescriptorVersion = warpDescriptorVersion;
	}
	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
}
