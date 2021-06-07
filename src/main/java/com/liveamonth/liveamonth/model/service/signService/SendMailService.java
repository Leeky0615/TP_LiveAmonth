package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;

public interface SendMailService {
    void sendMail(UserVO userVO);
}
