package com.liveamonth.liveamonth.controller.notUserController;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.model.service.notUserService.NotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMyPagePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EOneToOneAsk.ONE_TO_ONE_ASK_VO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EOneToOneAsk.ONE_TO_ONE_ASK_VO_LIST;

@Controller
public class NotUserController {
	
	@Autowired
	private NotUserService notUserService;
	
	
	 @GetMapping("/oneToOneAskReply")
	    public String oneToOneAskReply(Model model) throws Exception {
		 ArrayList<OneToOneAskVO> oneToOneAskReplyVOList = notUserService.getOneToOneAskReplyVOList();
	    	model.addAttribute(ONE_TO_ONE_ASK_VO_LIST.getText(),oneToOneAskReplyVOList);
	        return ONE_TO_ONE_ASK_REPLY.getPath();
	    }
	 
	 @GetMapping("/writeOneToOneAskReply")
	 public String oneToOneAskReplyWrite(Model model, HttpServletRequest request) throws Exception {
		 OneToOneAskVO oneToOneAskVO = notUserService.findOneToOneAskVO(Integer.parseInt(request.getParameter("oneToOneAskNO")));
		 model.addAttribute(ONE_TO_ONE_ASK_VO.getText(),oneToOneAskVO);
		 return WRITE_ONE_TO_ONE_ASK_REPLY.getPath();
	 }

	 @GetMapping("/resultMentOneToOneAskReply")
	 public String resultMentOneToOneAskReply(OneToOneAskVO oneToOneAskVO) throws Exception {
		 notUserService.addOneToOneAskReply(oneToOneAskVO);
		 notUserService.postOneToOneAskReplyFromEmail(oneToOneAskVO);
		 return RESULT_MENT_ONE_TO_ONE_ASK_REPLY.getPath();
	 }
	
	 

}
