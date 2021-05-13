package com.liveamonth.liveamonth.model.service.cityInfoService;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.CityTransportVO;
import com.liveamonth.liveamonth.entity.vo.CityWeatherVO;
import com.liveamonth.liveamonth.model.mapper.cityInfoMapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<CityInfoVO> getCityInfoList(String cityName, String cityInfoCategory) throws Exception {
        return cityMapper.getCityInfoList(cityName, cityInfoCategory);
    }

    @Override
    public HashMap<String, Object> getSelectedCityList(String cityName) throws Exception {
        HashMap<String, Object> selectedCityInfos = new HashMap<>();
        selectedCityInfos.put(CITY_INTRO.getText(), this.getCityInfoList(cityName, INTRO.name()));
        selectedCityInfos.put(CITY_FOOD_LIST.getText(), this.getCityInfoList(cityName, FOOD.name()));
        selectedCityInfos.put(CITY_VIEW_LIST.getText(), this.getCityInfoList(cityName, VIEW.name()));
        selectedCityInfos.put(CITY_WEATHER_LIST.getText(), this.getCityWeatherList(cityName));
        selectedCityInfos.put(CITY_TRANSPORT_LIST.getText(), this.getCityTransportList(cityName));
        return selectedCityInfos;
    }

    @Override
    public List<CityInfoVO> getCityInfoListByCategory(String cityInfoCategory) throws Exception {
        return cityMapper.getCityInfoListByCategory(cityInfoCategory);
    }

    @Override
    public List<CityInfoVO> getRandomCityInfoListByCategory(String cityInfoCategory) throws Exception {
        List<CityInfoVO> temp = cityMapper.getCityInfoListByCategory(cityInfoCategory);
        List<CityInfoVO> cityIntroList = new ArrayList<>();
        // 0~list크기까지 랜덤으로 번호 3개 추첨 : 중복X
        HashSet<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {randomNumbers.add((int) (Math.random() * temp.size()));}
        // 추첨된 번호 추가
        for (int ranNum:randomNumbers){cityIntroList.add(temp.get(ranNum));   }
        return cityIntroList;
    }

    @Override
    public List<CityWeatherVO> getCityWeatherList(String cityName) throws Exception {
        return cityMapper.getCityWeatherList(cityName);
    }
    @Override
    public List<CityTransportVO> getCityTransportList(String cityName) throws Exception {
        return cityMapper.getCityTransportList(cityName);
    }

    @Override
    public List<String> getCityNameList() throws Exception {
        return cityMapper.getCityInfoNameList();
    }

}
