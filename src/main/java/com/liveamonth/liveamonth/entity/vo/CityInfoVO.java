package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityInfoVO {
    private int cityInfoNO;
    private String cityInfoCategory;
    private String cityInfoName;
    private String cityInfoImageURL;
    private String cityInfoDesc;

    public int getCityInfoNO() {
        return cityInfoNO;
    }

    public void setCityInfoNO(int cityInfoNO) {
        this.cityInfoNO = cityInfoNO;
    }

    public String getCityInfoCategory() {
        return cityInfoCategory;
    }

    public void setCityInfoCategory(String cityInfoCategory) {
        this.cityInfoCategory = cityInfoCategory;
    }

    public String getCityInfoName() {
        return cityInfoName;
    }

    public void setCityInfoName(String cityInfoName) {
        this.cityInfoName = cityInfoName;
    }

    public String getCityInfoImageURL() {
        return cityInfoImageURL;
    }

    public void setCityInfoImageURL(String cityInfoImageURL) {
        this.cityInfoImageURL = cityInfoImageURL;
    }

    public String getCityInfoDesc() {
        return cityInfoDesc;
    }

    public void setCityInfoDesc(String cityInfoDesc) {
        this.cityInfoDesc = cityInfoDesc;
    }

    public CityInfoVO() {
        this.cityInfoNO = 0;
        this.cityInfoCategory = null;
        this.cityInfoName = null;
        this.cityInfoImageURL = null;
        this.cityInfoDesc = null;
    }

}