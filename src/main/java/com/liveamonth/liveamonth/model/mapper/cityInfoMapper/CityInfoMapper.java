package com.liveamonth.liveamonth.model.mapper.cityInfoMapper;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface CityInfoMapper {
    List<CityInfoVO> getCityInfoList(String cityName, String cityInfoCategory) throws Exception;

    List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception;

    List<String> getCityInfoNameList() throws Exception;
}
