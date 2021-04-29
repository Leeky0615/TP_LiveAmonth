package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class CityInfoVO {
    private int cityNO;
    private String cityInfoCategory;
    private String cityInfoDesc;
    private String cityInfoImage;
    

    public CityInfoVO() {
        this.cityNO = 0;
        this.cityInfoCategory = null;
        this.cityInfoImage = null;
        this.cityInfoDesc = null;
    }

	
    
    
}