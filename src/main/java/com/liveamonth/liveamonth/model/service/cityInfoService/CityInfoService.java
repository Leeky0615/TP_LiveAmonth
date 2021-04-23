package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;

import java.util.List;

public interface CityInfoService {

    List<CityInfoVO> getAllCityInfoList();
    List<CityInfoVO> getCityInfoList(String cityName);
}
