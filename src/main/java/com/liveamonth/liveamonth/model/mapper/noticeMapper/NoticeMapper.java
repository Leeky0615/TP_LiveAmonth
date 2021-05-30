package com.liveamonth.liveamonth.model.mapper.noticeMapper;

import com.liveamonth.liveamonth.entity.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface NoticeMapper {

    public ArrayList<NoticeVO> getAllNotice(int UserNO) throws Exception;

    public int getNoticeCount(int userNO) throws Exception;

    public void updateReadStatus(int userNO) throws Exception;

    public int addNotice(NoticeVO notice) throws Exception;

    public void addRRNotice(HashMap<String, Integer> map) throws Exception;

    public void addRLNotice(HashMap<String, Integer> map) throws Exception;

    public void addSRNotice(HashMap<String, Integer> map) throws Exception;

    public void addSLNotice(HashMap<String, Integer> map) throws Exception;
}
