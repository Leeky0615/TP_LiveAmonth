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
import java.util.HashMap;
import java.util.Locale;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EReviewPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.REVIEW_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.REVIEW_VO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReviewCategoryName;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewAttribute.REVIEW_CATEGORY_LIST;

@Controller
public class ReviewController {
	@Autowired
	private  ReviewService reviewService;


	@GetMapping("/review")
	public String showDefauleReviewPage(Model model) throws Exception{
		ArrayList<HashMap<String, Object>> allReviewList = reviewService.getAllReviewList();
		ArrayList<HashMap<String, Object>> freeReviewList = reviewService.getFreeReviewList();
		ArrayList<HashMap<String, Object>> popularReviewList = reviewService.getPopularReviewList();
		model.addAttribute(ALL_REVIEW_LIST.getText(), allReviewList);
		model.addAttribute(FREE_REVIEW_LIST.getText(), freeReviewList);
		model.addAttribute(POPULAR_REVIEW_LIST.getText(), popularReviewList);

		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return "Review";
	}

	@GetMapping("/categoryReviewPage")
	public String showCategoryReviewPage(Model model, HttpServletRequest request) throws Exception {
		String category = String.valueOf(request.getParameter("category"));
		HashMap<String, Object> reviewCategory = new HashMap<>();
		ArrayList<HashMap<String, Object>> reviewList = null;

		switch (category) {
			case "all":
				reviewList = reviewService.getAllReviewList();
				break;
			case "popular":
				reviewList = reviewService.getPopularReviewList();
				break;
			case "free":
				reviewList = reviewService.getFreeReviewList();
				break;
			default:
				reviewList = reviewService.getCategoryReviewList(category);
				break;

		}
		model.addAttribute("reviewList", reviewList);
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return CATEGORY_REVIEW_PAGE.getPath();
	}


	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) {
		model.addAttribute(REVIEW_CATEGORY_LIST.getText(), EReviewCategoryName.values());
		return REVIEW_WRITER.getPath();
	}

	@RequestMapping(value = "addReview")
	public String addReview(HttpServletRequest request, ReviewVO reviewVO, RedirectAttributes rttr) {
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String dTime = formatter.format(systemTime);
		reviewVO.setReviewDate(dTime);

		HttpSession session = request.getSession();
		UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
		reviewVO.setUserNO(session_UserVO.getUserNO());

		int reviewNO = 0;
		try {
			reviewNO = reviewService.addReview(reviewVO);
		} catch (Exception e) {
			rttr.addAttribute("message", "후기 등록에 실패하셨습니다.");
			e.printStackTrace();
			return DEFUALT_REVIEW_PAGE.getPath();
		}
		rttr.addAttribute(REVIEW_NO.getText(), reviewNO);
		return REDIRECT_REVIEW_CONTENT.getRedirectPath();
	}

	@GetMapping("/getReview")
	public String getReview(Model model, HttpServletRequest request){
		int reviewNO = Integer.parseInt(String.valueOf(request.getParameter(REVIEW_NO.getText())));

		ReviewVO reviewVO = null;
		try {
			reviewVO = reviewService.getReviewVO(reviewNO);
		} catch (Exception e) {
			model.addAttribute("message", "후기 조회에 실패했습니다.");
			e.printStackTrace();
			return DEFUALT_REVIEW_PAGE.getPath();
		}
		model.addAttribute(REVIEW_VO.getText(), reviewVO);
		return REVIEW_CONTENT.getPath();
	}
}
