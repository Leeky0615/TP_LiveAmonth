package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class CityInfoVO {
    private int cityNO;
    private String cityCategory;
    private String cityName;
    private String cityImageURL;
    private String cityDesc;

    public CityInfoVO() {
        this.cityNO = 0;
        this.cityCategory = null;
        this.cityName = null;
        this.cityImageURL = null;
        this.cityDesc = null;
    }

	public int getCityNO() {
		return cityNO;
	}

	public void setCityNO(int cityNO) {
		this.cityNO = cityNO;
	}

	public String getCityCategory() {
		return cityCategory;
	}

	public void setCityCategory(String cityCategory) {
		this.cityCategory = cityCategory;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityImageURL() {
		return cityImageURL;
	}

	public void setCityImageURL(String cityImageURL) {
		this.cityImageURL = cityImageURL;
	}

	public String getCityDesc() {
		return cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}
}