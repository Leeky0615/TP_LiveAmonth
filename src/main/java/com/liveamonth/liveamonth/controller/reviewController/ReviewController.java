package com.liveamonth.liveamonth.controller.reviewController;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
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
import java.util.HashMap;
import java.util.Locale;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EReviewPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.PAIGING;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.SELECTED_PAGE;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewAttribute.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;

@Controller
public class ReviewController {
	@Autowired
	private  ReviewService reviewService;


	@GetMapping("/review")
	public String showDefauleReviewPage(Model model) throws Exception{
		int selectPage = 1;
		ArrayList<HashMap<String, Object>> allReviewList = reviewService.getAllReviewList(selectPage);
		ArrayList<HashMap<String, Object>> freeReviewList = reviewService.getFreeReviewList(selectPage);
		ArrayList<HashMap<String, Object>> popularReviewList = reviewService.getPopularReviewList(selectPage);
		model.addAttribute(ALL_REVIEW_LIST.getText(), allReviewList);
		model.addAttribute(FREE_REVIEW_LIST.getText(), freeReviewList);
		model.addAttribute(POPULAR_REVIEW_LIST.getText(), popularReviewList);

		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return "Review";
	}

	@GetMapping("/categoryReviewPage")
	public String showCategoryReviewPage(Model model, HttpServletRequest request) throws Exception {
		String category = String.valueOf(request.getParameter("category"));
		ArrayList<HashMap<String, Object>> reviewList = null;

		int selectPage = 1;
		if (request.getParameter(SELECTED_PAGE.getText()) != null) {
			selectPage = Integer.parseInt(request.getParameter(SELECTED_PAGE.getText()));
		}

		switch (category) {
			case "all":
				reviewList = reviewService.getAllReviewList(selectPage);
				break;
			case "popular":
				reviewList = reviewService.getPopularReviewList(selectPage);
				break;
			case "free":
				reviewList = reviewService.getFreeReviewList(selectPage);
				break;
			default:
				reviewList = reviewService.getCategoryReviewList(category,selectPage);
				break;

		}


		PagingDTO paging = reviewService.showPaging(selectPage,category);

		model.addAttribute(PAIGING.getText(), paging);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("category",category);
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return CATEGORY_REVIEW_PAGE.getPath();
	}

	@GetMapping("/getReview")
	public String getReview(Model model, HttpServletRequest request) throws Exception{
		int reviewNO = Integer.parseInt(String.valueOf(request.getParameter(REVIEW_NO.getText())));

		ReviewVO reviewVO = reviewService.getReviewVO(reviewNO);

		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		model.addAttribute(REVIEW_VO.getText(), reviewVO);
		return REVIEW_CONTENT.getPath();
	}

	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) throws Exception {
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return REVIEW_WRITER.getPath();
	}

	@RequestMapping(value = "addReview")
	public String addReview(HttpServletRequest request, ReviewVO reviewVO, RedirectAttributes rttr) throws Exception {
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String dTime = formatter.format(systemTime);
		reviewVO.setReviewDate(dTime);

		HttpSession session = request.getSession();
		UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
		reviewVO.setUserNO(session_UserVO.getUserNO());

		int reviewNO = reviewService.addReview(reviewVO);
		rttr.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		rttr.addAttribute(REVIEW_NO.getText(), reviewNO);
		return REDIRECT_REVIEW_CONTENT.getRedirectPath();
	}
}
