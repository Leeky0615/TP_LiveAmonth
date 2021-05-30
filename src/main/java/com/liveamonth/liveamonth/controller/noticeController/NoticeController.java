package com.liveamonth.liveamonth.controller.noticeController;

import com.liveamonth.liveamonth.model.service.noticeService.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.EntityConstants.ImageURL;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @RequestMapping(value = "/getAllNotice", method = RequestMethod.GET)
    public HashMap<String, Object> getAllNotice(int userNO){
        HashMap<String, Object> noticeMap = new HashMap<String, Object>();
        try {
            noticeMap.put("noticeList", this.noticeService.getAllNotice(userNO));
            noticeMap.put("noticeCount", this.noticeService.getNoticeCount(userNO));
            noticeMap.put("imgURL", ImageURL+"user/");
        } catch (Exception e) {
            System.err.println("noticeList불러오기 실패 : " + e);
        }
        return noticeMap;
    }

    @ResponseBody
    @RequestMapping(value = "/updateReadStatus", method = RequestMethod.POST)
    public void updateReadStatus(int userNO){
        try {
            this.noticeService.updateReadStatus(userNO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
