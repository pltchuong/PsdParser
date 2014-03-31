package com.psdparser.model;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.resources.Url;

public class ImageResource {

	private String signature;
	private Integer id;
	private String name;
	private String hex;
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String value) {
		this.hex = value;
	}
	
	
	
	
	private String xmpData;
	private byte[] captionDigest;
	private String macintoshNSPrintInfo;
	private Integer globalAltitude;
	private List<Descriptor> sheetDisclosure;
	private List<Descriptor> onionSkins;
	private List<Descriptor> printInformation;
	private List<Descriptor> countInformation;
	private List<Descriptor> printStyle;
	private List<Descriptor> timelineInformation;
	private Integer version;
	private Boolean hasRealMergedData;
	private String writerName;
	private String readerName;
	private Integer fileVersion;
	private Integer globalAngle;
	private Integer layerStateInformation;
	private List<Integer> layerSelectionIds;
	private Integer printScaleStyle;
	private Float printScaleX;
	private Float printScaleY;
	private Float printScale;
	private List<Url> urls;
	private Boolean printLabels;
	private Boolean printCropMarks;
	private Boolean printColorBars;
	private Boolean printRegistrationMarks;
	private Boolean printNegative;
	private Boolean printFlip;
	private Boolean printInterpolate;
	private Boolean printCaption;
	private Boolean printFlags;
	
	
	public String getXmpData() {
		return xmpData;
	}
	public void setXmpData(String xmpData) {
		this.xmpData = xmpData;
	}
	public byte[] getCaptionDigest() {
		return captionDigest;
	}
	public void setCaptionDigest(byte[] xmpMetadata) {
		this.captionDigest = xmpMetadata;
	}
	public String getMacintoshNSPrintInfo() {
		return macintoshNSPrintInfo;
	}
	public void setMacintoshNSPrintInfo(String macintoshNSPrintInfo) {
		this.macintoshNSPrintInfo = macintoshNSPrintInfo;
	}
	public Integer getGlobalAltitude() {
		return globalAltitude;
	}
	public void setGlobalAltitude(Integer globalAltitude) {
		this.globalAltitude = globalAltitude;
	}
	public List<Descriptor> getSheetDisclosure() {
		return sheetDisclosure;
	}
	public void setSheetDisclosure(List<Descriptor> sheetDisclosure) {
		this.sheetDisclosure = sheetDisclosure;
	}
	public List<Descriptor> getOnionSkins() {
		return onionSkins;
	}
	public void setOnionSkins(List<Descriptor> onionSkins) {
		this.onionSkins = onionSkins;
	}
	public List<Descriptor> getPrintInformation() {
		return printInformation;
	}
	public void setPrintInformation(List<Descriptor> printInformation) {
		this.printInformation = printInformation;
	}
	public List<Descriptor> getCountInformation() {
		return countInformation;
	}
	public void setCountInformation(List<Descriptor> countInformation) {
		this.countInformation = countInformation;
	}
	public List<Descriptor> getPrintStyle() {
		return printStyle;
	}
	public void setPrintStyle(List<Descriptor> printStyle) {
		this.printStyle = printStyle;
	}
	public List<Descriptor> getTimelineInformation() {
		return timelineInformation;
	}
	public void setTimelineInformation(List<Descriptor> timelineInformation) {
		this.timelineInformation = timelineInformation;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Boolean getHasRealMergedData() {
		return hasRealMergedData;
	}
	public void setHasRealMergedData(Boolean hasRealMergedData) {
		this.hasRealMergedData = hasRealMergedData;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public Integer getFileVersion() {
		return fileVersion;
	}
	public void setFileVersion(Integer fileVersion) {
		this.fileVersion = fileVersion;
	}
	public Integer getGlobalAngle() {
		return globalAngle;
	}
	public void setGlobalAngle(Integer globalAngle) {
		this.globalAngle = globalAngle;
	}
	public Integer getLayerStateInformation() {
		return layerStateInformation;
	}
	public void setLayerStateInformation(Integer layerStateInformation) {
		this.layerStateInformation = layerStateInformation;
	}
	public List<Integer> getLayerSelectionIds() {
		return layerSelectionIds;
	}
	public void setLayerSelectionIds(List<Integer> layerSelectionIds) {
		this.layerSelectionIds = layerSelectionIds;
	}
	public Integer getPrintScaleStyle() {
		return printScaleStyle;
	}
	public void setPrintScaleStyle(Integer printScaleStyle) {
		this.printScaleStyle = printScaleStyle;
	}
	public Float getPrintScaleX() {
		return printScaleX;
	}
	public void setPrintScaleX(Float printScaleX) {
		this.printScaleX = printScaleX;
	}
	public Float getPrintScaleY() {
		return printScaleY;
	}
	public void setPrintScaleY(Float printScaleY) {
		this.printScaleY = printScaleY;
	}
	public Float getPrintScale() {
		return printScale;
	}
	public void setPrintScale(Float printScale) {
		this.printScale = printScale;
	}
	public List<Url> getUrls() {
		return urls;
	}
	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}
	public Boolean getPrintLabels() {
		return printLabels;
	}
	public void setPrintLabels(Boolean printLabels) {
		this.printLabels = printLabels;
	}
	public Boolean getPrintCropMarks() {
		return printCropMarks;
	}
	public void setPrintCropMarks(Boolean printCropMarks) {
		this.printCropMarks = printCropMarks;
	}
	public Boolean getPrintColorBars() {
		return printColorBars;
	}
	public void setPrintColorBars(Boolean printColorBars) {
		this.printColorBars = printColorBars;
	}
	public Boolean getPrintRegistrationMarks() {
		return printRegistrationMarks;
	}
	public void setPrintRegistrationMarks(Boolean printRegistrationMarks) {
		this.printRegistrationMarks = printRegistrationMarks;
	}
	public Boolean getPrintNegative() {
		return printNegative;
	}
	public void setPrintNegative(Boolean printNegative) {
		this.printNegative = printNegative;
	}
	public Boolean getPrintFlip() {
		return printFlip;
	}
	public void setPrintFlip(Boolean printFlip) {
		this.printFlip = printFlip;
	}
	public Boolean getPrintInterpolate() {
		return printInterpolate;
	}
	public void setPrintInterpolate(Boolean printInterpolate) {
		this.printInterpolate = printInterpolate;
	}
	public Boolean getPrintCaption() {
		return printCaption;
	}
	public void setPrintCaption(Boolean printCaption) {
		this.printCaption = printCaption;
	}
	public Boolean getPrintFlags() {
		return printFlags;
	}
	public void setPrintFlags(Boolean printFlags) {
		this.printFlags = printFlags;
	}
	
}
