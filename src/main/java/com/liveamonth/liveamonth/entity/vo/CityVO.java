package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class CityVO {
    // Attributes
    private int cityNO;
    private String cityName;

    // Constructor
    public CityVO() {
        this.cityNO = 0;
        this.cityName = null;
    }

    // Getter & Setter
    public int getCityNO() {return cityNO;}
    public void setCityNO(int cityNO) {this.cityNO = cityNO;}

    public String getCityName() {return cityName;}
    public void setCityName(String cityName) {this.cityName = cityName;}
}
