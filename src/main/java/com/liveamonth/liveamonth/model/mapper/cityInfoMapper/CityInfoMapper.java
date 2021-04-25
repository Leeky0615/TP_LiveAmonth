package com.liveamonth.liveamonth.model.mapper.cityInfoMapper;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityInfoMapper {
    @Select("SELECT * FROM cityInfo")
    List<CityInfoVO> getAllCityInfoList();

    @Select("SELECT * FROM cityInfo WHERE cityInfoName=#{cityInfoName}")
    List<CityInfoVO> getCityTotalInfoList(String cityName);

    @Select("SELECT * FROM cityInfo WHERE cityInfoName=#{cityInfoName} AND cityInfoCategory=#{cityInfoCategory}")
    List<CityInfoVO> getCityInfoList(String cityInfoName, String cityInfoCategory);

    @Select("SELECT * FROM cityInfo WHERE cityInfoCategory=#{cityInfoCategory}")
    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory);

    @Select("SELECT cityInfoName FROM cityInfo WHERE cityInfoCategory='INTRO'")
    List<String> getCityInfoNameList();
}
