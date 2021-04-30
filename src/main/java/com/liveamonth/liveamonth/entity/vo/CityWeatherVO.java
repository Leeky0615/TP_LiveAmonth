package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityWeatherVO {
	// Attributes
	private int cityWeatherNO;
	private int cityWeatherMonth;
	private float cityWeatherMaxTemp;
	private float cityWeatherMinTemp;
	private float cityWeatherAVGTemp;

	private CityVO cityVO; // Reference

	// Constructor
	public CityWeatherVO() {
		this.cityWeatherNO = 0;
		this.cityWeatherMonth = 0;
		this.cityWeatherMaxTemp = 0;
		this.cityWeatherMinTemp = 0;
		this.cityWeatherAVGTemp = 0;

		this.cityVO = null;
	}

	// Getter & Setter
	public int getCityWeatherNO() {return cityWeatherNO;}
	public void setCityWeatherNO(int cityWeatherNO) {this.cityWeatherNO = cityWeatherNO;}

	public int getCityWeatherMonth() {return cityWeatherMonth;}
	public void setCityWeatherMonth(int cityWeatherMonth) {this.cityWeatherMonth = cityWeatherMonth;}

	public float getCityWeatherMaxTemp() {return cityWeatherMaxTemp;}
	public void setCityWeatherMaxTemp(float cityWeatherMaxTemp) {this.cityWeatherMaxTemp = cityWeatherMaxTemp;}

	public float getCityWeatherMinTemp() {return cityWeatherMinTemp;}
	public void setCityWeatherMinTemp(float cityWeatherMinTemp) {this.cityWeatherMinTemp = cityWeatherMinTemp;}

	public float getCityWeatherAVGTemp() {return cityWeatherAVGTemp;}
	public void setCityWeatherAVGTemp(float cityWeatherAVGTemp) {this.cityWeatherAVGTemp = cityWeatherAVGTemp;}

	public CityVO getCityVO() {return cityVO;}
	public void setCityVO(CityVO cityVO) {this.cityVO = cityVO;}
}