package com.liveamonth.liveamonth.controller.reviewController;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.SCHEDULE_PLACE_LIST;

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
		model.addAttribute(SCHEDULE_PLACE_LIST.getText(), EntityConstants.CityName.values());
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
	public String reviewWrite(Model model) throws Exception{
		return "reviewView/Review";
	}
}
