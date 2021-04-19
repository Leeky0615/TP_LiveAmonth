package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.mapper.cityInfoMapper.CityInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityInfoServiceImpl implements CityInfoService {

    @Autowired
    private CityInfoMapper cityInfoMapper;

    @Override
    public List<CityInfoVO> getCityInfoList() {
        return cityInfoMapper.getCityInfoList();
    }
}
