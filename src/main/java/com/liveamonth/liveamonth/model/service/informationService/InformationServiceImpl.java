package com.liveamonth.liveamonth.model.service.informationService;

import com.liveamonth.liveamonth.model.mapper.informationMapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    private InformationMapper informationMapper;
}
