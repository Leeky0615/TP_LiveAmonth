package com.liveamonth.liveamonth.controller.notUserController;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.model.service.notUserService.NotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class NotUserController {
	
	@Autowired
	private NotUserService notUserService;
	
	
	 @GetMapping("/oneToOneAskReply")
	    public String oneToOneAskReply(Model model) throws Exception {
		 ArrayList<OneToOneAskVO> oneToOneAskReplyVOList = notUserService.getOneToOneAskReplyVOList();
	    	model.addAttribute("oneToOneAskReplyVOList",oneToOneAskReplyVOList);
	        return "myPageView/OneToOneAskReply";
	    }
	 
	 @GetMapping("/writeOneToOneAskReply")
	 public String oneToOneAskReplyWrite(Model model, HttpServletRequest request) throws Exception {
		 OneToOneAskVO oneToOneAskVO = notUserService.findOneToOneAskVO(Integer.parseInt(request.getParameter("oneToOneAskNO")));
		 model.addAttribute("oneToOneAskVO",oneToOneAskVO);
		 return "myPageView/WriteOneToOneAskReply";
	 }

	 @GetMapping("/resultMentOneToOneAskReply")
	 public String resultMentOneToOneAskReply(OneToOneAskVO oneToOneAskVO) throws Exception {
		 notUserService.addOneToOneAskReply(oneToOneAskVO);
		 notUserService.postOneToOneAskReplyFromEmail(oneToOneAskVO);
		 return "myPageView/ResultMentOneToOneAskReply";
	 }
	
	 

}
