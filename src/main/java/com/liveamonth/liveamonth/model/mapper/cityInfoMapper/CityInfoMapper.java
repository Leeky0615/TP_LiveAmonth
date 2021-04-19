package com.liveamonth.liveamonth.model.mapper.cityInfoMapper;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityInfoMapper {
    List<CityInfoVO> getCityInfoList();
}
