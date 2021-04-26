package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;

import java.util.List;

public interface CityInfoService {

    List<CityInfoVO> getAllCityInfoList() throws Exception;
    List<CityInfoVO> getCityTotalInfoList(String cityInfoName) throws Exception;
    List<CityInfoVO> getCityInfoList(String cityInfoName,String cityInfoCategory) throws Exception;
    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception;
    List<String> getCityInfoNameList() throws Exception;
}
