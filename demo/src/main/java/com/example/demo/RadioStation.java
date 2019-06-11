package com.example.demo;

public class RadioStation {
	String operator;
	String ID;
	String type;
	String address;
	String lat;
	String lon;
	String alt;
	double channel;
	String bouquet;
	double erpMaxH;
	double erpMaxV;
	double freq;
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}
	/**
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}
	/**
	 * @return the channel
	 */
	public double getChannel() {
		return channel;
	}
	/**
	 * @return the bouquet
	 */
	public String getBouquet() {
		return bouquet;
	}
	/**
	 * @return the erpMaxH
	 */
	public double getErpMaxH() {
		return erpMaxH;
	}
	/**
	 * @return the erpMaxV
	 */
	public double getErpMaxV() {
		return erpMaxV;
	}
	/**
	 * @return the freq
	 */
	public double getFreq() {
		return freq;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}
	/**
	 * @param alt the alt to set
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(double channel) {
		this.channel = channel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RadioStation [operator=" + operator + ", ID=" + ID + ", type=" + type + ", address=" + address
				+ ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", channel=" + channel + ", bouquet=" + bouquet
				+ ", erpMaxH=" + erpMaxH + ", erpMaxV=" + erpMaxV + ", freq=" + freq + "]";
	}
	/**
	 * @param bouquet the bouquet to set
	 */
	public void setBouquet(String bouquet) {
		this.bouquet = bouquet;
	}
	/**
	 * @param erpMaxH the erpMaxH to set
	 */
	public void setErpMaxH(double erpMaxH) {
		this.erpMaxH = erpMaxH;
	}
	/**
	 * @param erpMaxV the erpMaxV to set
	 */
	public void setErpMaxV(double erpMaxV) {
		this.erpMaxV = erpMaxV;
	}
	/**
	 * @param freq the freq to set
	 */
	public void setFreq(double freq) {
		this.freq = freq;
	}
	/**
	 * @param operator
	 * @param iD
	 * @param type
	 * @param address
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param channel
	 * @param bouquet
	 * @param erpMaxH
	 * @param erpMaxV
	 * @param freq
	 */
	public RadioStation(String operator, String iD, String type, String address, String lat, String lon, String alt,
			double channel, String bouquet, double erpMaxH, double erpMaxV, double freq) {
		this.operator = operator;
		ID = iD;
		this.type = type;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.channel = channel;
		this.bouquet = bouquet;
		this.erpMaxH = erpMaxH;
		this.erpMaxV = erpMaxV;
		this.freq = freq;
	}
	/**
	 * 
	 */
	public RadioStation() {
	}
	
	
}
