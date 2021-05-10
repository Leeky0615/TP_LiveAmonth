package com.liveamonth.liveamonth.controller.reviewController;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EReviewPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewAttribute.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.ALL_REVIEW_LIST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.CHECK_USER;

@Controller
public class ReviewController {
	@Autowired
	private  ReviewService reviewService;



	@GetMapping("/review")
	public String showFristReviewList(Model model) throws Exception{
		ArrayList<ReviewVO> reviewList = reviewService.getAllReviewList();
		model.addAttribute(ALL_REVIEW_LIST.getText(), reviewList);
		return FIRST_REVIEW_PAGE.getPath();
	}

	@GetMapping("/getReview")
	public String getReview(Model model, HttpServletRequest request) throws Exception{
		int reviewNO = Integer.parseInt(String.valueOf(request.getParameter(REVIEW_NO.getText())));

		ReviewVO reviewVO = reviewService.getReviewVO(reviewNO);

		model.addAttribute(REVIEW_VO.getText(), reviewVO);
		return REVIEW_CONTENT.getPath();
	}

	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) throws Exception {
		model.addAttribute(REVIEW_TYPE_LIST.getText(), EReviewTypeName.values());
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		model.addAttribute(REVIEW_PLACE_LIST.getText(), CityName.values());
		return REVIEW_WRITER.getPath();
	}

	@RequestMapping(value = "addReview")
	public String addSchedule(HttpServletRequest request, ReviewVO reviewVO, RedirectAttributes rttr) throws Exception {
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String dTime = formatter.format(systemTime);
		reviewVO.setReviewDate(dTime);

		HttpSession session = request.getSession();
		UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
		reviewVO.setUserNO(session_UserVO.getUserNO());

		int reviewNO = reviewService.addReview(reviewVO);
		rttr.addAttribute(REVIEW_NO.getText(), reviewNO);
		return REDIRECT_REVIEW_CONTENT.getRedirectPath();
	}
}
