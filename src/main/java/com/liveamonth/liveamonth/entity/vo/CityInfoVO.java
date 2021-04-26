package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
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
}