package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.mapper.cityInfoMapper.CityInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityInfoMapper cityInfoMapper;

    @Override
    public List<CityInfoVO> getCityInfoList(String cityName, String cityInfoCategory) throws Exception{
        return cityInfoMapper.getCityInfoList(cityName,cityInfoCategory);
    }

    @Override
    public List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception {
        return cityInfoMapper.getCityInfoListByCategory(cityInfoCategory);
    }

    @Override
    public List<String> getCityNameList() throws Exception{
        return cityInfoMapper.getCityInfoNameList();
    }

}
