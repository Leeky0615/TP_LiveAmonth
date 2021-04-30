package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;

import java.util.HashMap;
import java.util.List;

public interface CityService {
    List<CityInfoVO> getCityInfoList(String cityName,String cityInfoCategory) throws Exception;
    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception;
    List<String> getCityNameList() throws Exception;
}
