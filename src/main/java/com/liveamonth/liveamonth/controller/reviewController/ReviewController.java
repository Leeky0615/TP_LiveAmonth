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

import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewAttribute.*;

@Controller
public class ReviewController {
	@Autowired
	private  ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/review")
	public String showFristReviewList(Model model) throws Exception{
		ArrayList<ReviewVO> reviewList = reviewService.getAllReviewList();

		model.addAttribute("AllReviewList", reviewList);
		return "reviewView/FirstReviewList";
	}

	@GetMapping("/getReview")
	public String getReview(Model model, HttpServletRequest request) throws Exception{
		int reviewNO = Integer.parseInt(String.valueOf(request.getParameter("reviewNO")));

		ReviewVO reviewVO = reviewService.getReviewVO(reviewNO);

		model.addAttribute("reviewVO", reviewVO);
		return "reviewView/ReviewContent";
	}

	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) throws Exception {
		model.addAttribute(REVIEW_TYPE_LIST.getText(), EReviewTypeName.values());
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		model.addAttribute(REVIEW_PLACE_LIST.getText(), CityName.values());
		return "reviewView/ReviewWriter";
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
		rttr.addAttribute("reviewNO", reviewNO);
		return "redirect:getReview";
	}
}
