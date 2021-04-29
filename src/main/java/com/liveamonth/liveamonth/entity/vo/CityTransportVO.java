package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityTransportVO {
	// Attributes
	private int cityNO;
	private String cityTransportCategory;
	private int cityStationCount;

	private int cityNo; // Reference

	// Constructor
	public CityTransportVO() {
		this.cityNO = 0;
		this.cityTransportCategory = null;
		this.cityStationCount = 0;

		this.cityNo = 0;
	}

	// Getter & Setter
	public int getCityNO() {return cityNO;}
	public void setCityNO(int cityNO) {this.cityNO = cityNO;}

	public String getCityTransportCategory() {return cityTransportCategory;}
	public void setCityTransportCategory(String cityTransportCategory) {this.cityTransportCategory = cityTransportCategory;}

	public int getCityStationCount() {return cityStationCount;}
	public void setCityStationCount(int cityStationCount) {this.cityStationCount = cityStationCount;}

	public int getCityNo() {return cityNo;}
	public void setCityNo(int cityNo) {this.cityNo = cityNo;}
}
