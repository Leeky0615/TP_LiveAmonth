package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

import static com.liveamonth.liveamonth.constants.EntityConstants.*;

@Data
public class CityInfoVO {
    // Attributes
    private int cityInfoNO;
    private String cityInfoCategory;
    private String cityInfoImage;
    private String cityInfoDesc;

    private CityVO cityVO; // Reference

    // Constructor
    public CityInfoVO() {
        this.cityInfoNO = 0;
        this.cityInfoCategory = null;
        this.cityInfoImage = null;
        this.cityInfoDesc = null;

        this.cityVO = null;
    }

    // Getter & Setter
    public int getCityInfoNO() {return cityInfoNO;}
    public void setCityInfoNO(int cityInfoNO) {this.cityInfoNO = cityInfoNO;}

    public String getCityInfoCategory() {return cityInfoCategory;}
    public void setCityInfoCategory(String cityInfoCategory) {this.cityInfoCategory = cityInfoCategory;}

    public String getCityInfoImage() {return cityInfoImage;}
    public void setCityInfoImage(String cityInfoImage) {this.cityInfoImage = cityInfoImage;}

    public String getCityInfoDesc() {return cityInfoDesc;}
    public void setCityInfoDesc(String cityInfoDesc) {this.cityInfoDesc = cityInfoDesc;}

    public CityVO getCityVO() {return cityVO;}
    public void setCityVO(CityVO cityVO) {this.cityVO = cityVO;}

    // Get URL
    public String getCityInfoImageURL(){
        String imageURL = "";
        for(CityInfoCategory category : CityInfoCategory.values()){
            if (category.name().equals(this.getCityInfoCategory())){
                imageURL = IMAGE_URL +category.getPath()+this.getCityInfoImage();
            }
        }
        return imageURL;
    }
}