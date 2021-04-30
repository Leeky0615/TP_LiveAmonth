package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityTransportVO {
	// Attributes
	private int cityTransportNO;
	private String cityTransportCategory;
	private int cityStationCount;

	private CityVO cityVO; // Reference

	// Constructor
	public CityTransportVO() {
		this.cityTransportNO = 0;
		this.cityTransportCategory = null;
		this.cityStationCount = 0;

		this.cityVO = null;
	}

	// Getter & Setter
	public int getCityTransportNO() {return cityTransportNO;}
	public void setCityTransportNO(int cityTransportNO) {this.cityTransportNO = cityTransportNO;}

	public String getCityTransportCategory() {return cityTransportCategory;}
	public void setCityTransportCategory(String cityTransportCategory) {this.cityTransportCategory = cityTransportCategory;}

	public int getCityStationCount() {return cityStationCount;}
	public void setCityStationCount(int cityStationCount) {this.cityStationCount = cityStationCount;}

	public CityVO getCityVO() {return cityVO;}
	public void setCityVO(CityVO cityVO) {this.cityVO = cityVO;}
}
