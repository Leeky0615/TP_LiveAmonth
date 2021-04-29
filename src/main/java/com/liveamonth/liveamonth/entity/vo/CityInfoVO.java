package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.*;

@Data
public class CityInfoVO {
    // Attributes
    private int cityInfoNO;
    private String cityInfoCategory;
    private String cityInfoName;
    private String cityInfoImage;
    private String cityInfoDesc;

    private int cityNo; // Reference

    // Constructor
    public CityInfoVO() {
        this.cityInfoNO = 0;
        this.cityInfoCategory = null;
        this.cityInfoName = null;
        this.cityInfoImage = null;
        this.cityInfoDesc = null;

        this.cityNo = 0;
    }

    // Getter & Setter
    public int getCityInfoNO() {return cityInfoNO;}
    public void setCityInfoNO(int cityInfoNO) {this.cityInfoNO = cityInfoNO;}

    public String getCityInfoCategory() {return cityInfoCategory;}
    public void setCityInfoCategory(String cityInfoCategory) {this.cityInfoCategory = cityInfoCategory;}

    public String getCityInfoName() {return cityInfoName;}
    public void setCityInfoName(String cityInfoName) {this.cityInfoName = cityInfoName;}

    public String getCityInfoImage() {return cityInfoImage;}
    public void setCityInfoImage(String cityInfoImage) {this.cityInfoImage = cityInfoImage;}

    public String getCityInfoDesc() {return cityInfoDesc;}
    public void setCityInfoDesc(String cityInfoDesc) {this.cityInfoDesc = cityInfoDesc;}

    public int getCityNo() {return cityNo;}
    public void setCityNo(int cityNo) {this.cityNo = cityNo;}

    // Get URL
    public String getCityInfoImageURL(){
        String imageURL = "";
        for(CityInfoCategory category : CityInfoCategory.values()){
            if (category.equals(this.cityInfoCategory)){
                imageURL = ImageURL+category.getPath()+this.getCityInfoImage();
            }
        }
        return imageURL;
    }
}