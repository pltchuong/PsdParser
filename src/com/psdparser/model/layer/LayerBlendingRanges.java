package com.psdparser.model.layer;

public class LayerBlendingRanges {

	private Integer grayBlackSource;
	private Integer grayWhiteSource;
	private Integer grayBlackDestination;
	private Integer grayWhiteDestination;
	private Integer numberOfBlendingChannels;
	private Integer[] channelBlackSource;
	private Integer[] channelWhiteSource;
	private Integer[] channelBlackDestination;
	private Integer[] channelWhiteDestination;
	
	public Integer getGrayBlackSource() {
		return grayBlackSource;
	}
	public void setGrayBlackSource(Integer grayBlackSource) {
		this.grayBlackSource = grayBlackSource;
	}
	public Integer getGrayWhiteSource() {
		return grayWhiteSource;
	}
	public void setGrayWhiteSource(Integer grayWhiteSource) {
		this.grayWhiteSource = grayWhiteSource;
	}
	public Integer getGrayBlackDestination() {
		return grayBlackDestination;
	}
	public void setGrayBlackDestination(Integer grayBlackDestination) {
		this.grayBlackDestination = grayBlackDestination;
	}
	public Integer getGrayWhiteDestination() {
		return grayWhiteDestination;
	}
	public void setGrayWhiteDestination(Integer grayWhiteDestination) {
		this.grayWhiteDestination = grayWhiteDestination;
	}
	public Integer getNumberOfBlendingChannels() {
		return numberOfBlendingChannels;
	}
	public void setNumberOfBlendingChannels(Integer numberOfBlendingChannels) {
		this.numberOfBlendingChannels = numberOfBlendingChannels;
	}
	public Integer[] getChannelBlackSource() {
		return channelBlackSource;
	}
	public void setChannelBlackSource(Integer[] channelBlackSource) {
		this.channelBlackSource = channelBlackSource;
	}
	public Integer[] getChannelWhiteSource() {
		return channelWhiteSource;
	}
	public void setChannelWhiteSource(Integer[] channelWhiteSource) {
		this.channelWhiteSource = channelWhiteSource;
	}
	public Integer[] getChannelBlackDestination() {
		return channelBlackDestination;
	}
	public void setChannelBlackDestination(Integer[] channelBlackDestination) {
		this.channelBlackDestination = channelBlackDestination;
	}
	public Integer[] getChannelWhiteDestination() {
		return channelWhiteDestination;
	}
	public void setChannelWhiteDestination(Integer[] channelWhiteDestination) {
		this.channelWhiteDestination = channelWhiteDestination;
	}
	
}
