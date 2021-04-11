package com.liveamonth.liveamonth.model.service.boardService;

import com.liveamonth.liveamonth.model.mapper.boardMapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

}
