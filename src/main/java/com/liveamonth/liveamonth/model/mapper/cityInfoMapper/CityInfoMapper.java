package com.liveamonth.liveamonth.model.mapper.cityInfoMapper;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityInfoMapper {
//    @Select("SELECT * FROM cityInfo")
//    List<CityInfoVO> getAllCityInfoList() throws Exception;;
//
//    @Select("SELECT * FROM cityInfo WHERE cityInfoName=#{cityInfoName}")
//    List<CityInfoVO> getCityTotalInfoList(String cityName) throws Exception;;
//
//    @Select("SELECT * FROM cityInfo WHERE cityInfoName=#{cityInfoName} AND cityInfoCategory=#{cityInfoCategory}")
//    List<CityInfoVO> getCityInfoList(String cityInfoName, String cityInfoCategory) throws Exception;;
//
//    @Select("SELECT * FROM cityInfo WHERE cityInfoCategory=#{cityInfoCategory}")
//    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception;;
//
//    @Select("SELECT cityInfoName FROM cityInfo WHERE cityInfoCategory='INTRO'")
//    List<String> getCityInfoNameList() throws Exception;;
}
