package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityInfoVO {
    private int cityInfoNO;
    private String cityInfoCategory;
    private String cityInfoName;
    private String cityInfoImageURL;
    private String cityInfoDesc;

    public CityInfoVO() {
        this.cityInfoNO = 0;
        this.cityInfoCategory = null;
        this.cityInfoName = null;
        this.cityInfoImageURL = null;
        this.cityInfoDesc = null;
    }
}