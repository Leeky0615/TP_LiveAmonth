package com.liveamonth.liveamonth.model.service.noticeService;

import com.liveamonth.liveamonth.entity.vo.NoticeVO;

import java.util.ArrayList;

public interface NoticeService {

    public ArrayList<NoticeVO> getAllNotice(int UserNO) throws Exception;

    public int getNoticeCount(int userNO) throws Exception;

    public void updateReadStatus(int userNO) throws Exception;

    public int addNotice(int userNO, int senderNO) throws Exception;

    void addRRNotice(int noticeNO, int reviewReplyNO) throws Exception;

    void addRLNotice(int noticeNO, int reviewNO) throws Exception;

    void addSRNotice(int noticeNO, int scheduleReplyNO) throws Exception;

    void addSLNotice(int noticeNO, int scheduleNO) throws Exception;
}
