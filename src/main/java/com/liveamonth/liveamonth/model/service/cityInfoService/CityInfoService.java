package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;

import java.util.List;

public interface CityInfoService {

    List<CityInfoVO> getAllCityInfoList();
    List<CityInfoVO> getCityTotalInfoList(String cityInfoName);
    List<CityInfoVO> getCityInfoList(String cityInfoName,String cityInfoCategory);
    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory);
    List<String> getCityInfoNameList();
}
