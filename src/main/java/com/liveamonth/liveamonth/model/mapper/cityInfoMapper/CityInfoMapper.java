package com.liveamonth.liveamonth.model.mapper.cityInfoMapper;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityInfoMapper {
    @Select("SELECT * FROM city")
    List<CityInfoVO> getAllCityInfoList();

    @Select("SELECT * FROM city WHERE cityName=#{cityName}")
    List<CityInfoVO> getCityInfoList(String cityName);

}
