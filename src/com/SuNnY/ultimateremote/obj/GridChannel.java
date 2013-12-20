package com.SuNnY.ultimateremote.obj;

public class GridChannel {
	GridAiring[] Airings;
	String CallLetters;
	String Channel;
	ImageGrid[] ChannelImages;
	ChannelSchedule[] ChannelSchedules;
	String DisplayName;
	Boolean IconAvailable;
	Boolean IsChannelOverride;
	int Order;
	int ParentNetworkId;
	int ServiceId;
	int SourceAttributes;
	int SourceId;
	String SourceLongName;
	public GridAiring[] getAirings() {
		return Airings;
	}
	public void setAirings(GridAiring[] airings) {
		Airings = airings;
	}
	public String getCallLetters() {
		return CallLetters;
	}
	public void setCallLetters(String callLetters) {
		CallLetters = callLetters;
	}
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public ImageGrid[] getChannelImages() {
		return ChannelImages;
	}
	public void setChannelImages(ImageGrid[] channelImages) {
		ChannelImages = channelImages;
	}
	public ChannelSchedule[] getChannelSchedules() {
		return ChannelSchedules;
	}
	public void setChannelSchedules(ChannelSchedule[] channelSchedules) {
		ChannelSchedules = channelSchedules;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public Boolean getIconAvailable() {
		return IconAvailable;
	}
	public void setIconAvailable(Boolean iconAvailable) {
		IconAvailable = iconAvailable;
	}
	public Boolean getIsChannelOverride() {
		return IsChannelOverride;
	}
	public void setIsChannelOverride(Boolean isChannelOverride) {
		IsChannelOverride = isChannelOverride;
	}
	public int getOrder() {
		return Order;
	}
	public void setOrder(int order) {
		Order = order;
	}
	public int getParentNetworkId() {
		return ParentNetworkId;
	}
	public void setParentNetworkId(int parentNetworkId) {
		ParentNetworkId = parentNetworkId;
	}
	public int getServiceId() {
		return ServiceId;
	}
	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}
	public int getSourceAttributes() {
		return SourceAttributes;
	}
	public void setSourceAttributes(int sourceAttributes) {
		SourceAttributes = sourceAttributes;
	}
	public int getSourceId() {
		return SourceId;
	}
	public void setSourceId(int sourceId) {
		SourceId = sourceId;
	}
	public String getSourceLongName() {
		return SourceLongName;
	}
	public void setSourceLongName(String sourceLongName) {
		SourceLongName = sourceLongName;
	}
}
