package com.liveamonth.liveamonth.controller.notUserController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.model.service.notUserService.NotUserService;

@Controller
public class NotUserController {
	
	@Autowired
	private NotUserService notUserService;
	
	
	 @GetMapping("/oneToOneAskReply")
	    public String oneToOneAskReply(Model model, HttpServletRequest request) throws Exception {
		 ArrayList<OneToOneAskVO> oneToOneAskReplyVOList = notUserService.getOneToOneAskReplyVOList();
	    	model.addAttribute("oneToOneAskReplyVOList",oneToOneAskReplyVOList);
	        return "notUserView/OneToOneAskReply";
	    }
	 
	 @GetMapping("/oneToOneAskReplyWrite")
	    public String oneToOneAskReplyWrite(Model model, HttpServletRequest request) throws Exception {
	    	OneToOneAskVO oneToOneAskVO = notUserService.findOneToOneAskVO(Integer.parseInt(request.getParameter("oneToOneAskNO")));
		 model.addAttribute("oneToOneAskVO",oneToOneAskVO);
	        return "notUserView/OneToOneAskReplyWrite";
	    }

	 @GetMapping("/resultMentOneToOneAskReply")
	 public String resultMentOneToOneAskReply(Model model, HttpServletRequest request,OneToOneAskVO oneToOneAskVO) throws Exception {
		 notUserService.addOneToOneAskReply(oneToOneAskVO);
		 notUserService.postOneToOneAskReplyFromEmail(oneToOneAskVO);
		 return "notUserView/ResultMentOneToOneAskReply";
	 }
	
	 

}
