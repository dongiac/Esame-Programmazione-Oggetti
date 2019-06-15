package com.example.demo1;

public class RadioStation {
	protected String operator;
	protected String ID;
	protected String type;
	protected String address;
	protected String lat;
	protected String lon;
	protected String alt;
	protected double channel;
	protected String bouquet;
	protected double erpMaxH;
	protected double erpMaxV;
	protected double freq;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RadioStation [operator=" + operator + ", ID=" + ID + ", type=" + type + ", address=" + address
				+ ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", channel=" + channel + ", bouquet=" + bouquet
				+ ", erpMaxH=" + erpMaxH + ", erpMaxV=" + erpMaxV + ", freq=" + freq + "]";
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
			String channel, String bouquet, String erpMaxH, String erpMaxV, String freq) {
		this.operator = operator;
		ID = iD;
		this.type = type;
		this.address = address;
		this.lat = lat;
		this.alt = alt;
		this.lon = lon;	
		this.bouquet = bouquet;
		try {
		this.channel = Double.parseDouble(channel);
		}catch(Exception e){
			this.channel = 0;
		}
		try {
		this.erpMaxH = Double.parseDouble(erpMaxH);
		}catch(Exception e){
			this.erpMaxH = 0;
		}try {
		this.erpMaxV = Double.parseDouble(erpMaxV);
		}catch(Exception e){
			this.erpMaxV = 0;
		}
		try {
		this.freq = Double.parseDouble(freq);
		}catch(Exception e){
			this.freq = 0;
		}
	}

	/**
	 * 
	 */
	public RadioStation() {
	}

}
