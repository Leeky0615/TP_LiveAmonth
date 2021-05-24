package com.liveamonth.liveamonth.constants;

public class ControllerPathConstants {
    /*
     * View(JSP)의 파일 경로를 모아놓은 클래스
     * 1. getPath() : View에 해당하는 directory를 더해서 리턴.
     * 2. getText() : 텍스트만 리턴
     * 3. 'redirect:'를 사용하는 경우 enum에 'REDIRECT_+@@@@' 형식으로 enum 선언 -> 가져올때는 getText() 사용
     */
    public ControllerPathConstants() {}

    /*
     * MainController Path Constants
     */
    public enum ETemplatePath {
        MAIN("Main"),
        MY_PAGE("MyPage"),
        CITY("City"),
        REVIEW("Review"),
        CUSTOMER_CENTER("CustomerCenter");
        private String path;
        private ETemplatePath(String path) {this.path = path;}
        public String getPath() {return this.path;}
    }

    /*
     * MyPageController Path Constants
     */
    public enum EMyPagePath {
        REDIRECT_MY_PAGE("redirect:myPage"),
        MODIFY_USER_INFO("ModifyUserInfo"),
        RE_CHECK_PASSWORD("ReCheckPassword"),
        RESULT_MENT("ResultMent"),
    	FINALLY_ASK_DROP_USER("FinallyAskDropUser"),
    	ONE_TO_ONE_ASK("OneToOneAsk"),
    	SHOW_ONE_TO_ONE_ASK("ShowOneToOneAsk"),
    	Write_ONE_TO_ONE_ASK("WriteOneToOneAsk"),
    	RESULT_MENT_ONE_TO_ONE_ASK("ResultMentOneToOneAsk"),
    	RESULT_MENT_DELETE_ONE_TO_ONE_ASK("ResultMentDeleteOneToOneAsk");
        private String path;
        private EMyPagePath(String path) {this.path = path;}
        public String getPath() {return "myPageView/"+this.path;}
        public String getText() {return this.path;}
    }

    /*
     * SignController Path Constants
     */
    public enum ESignPath {
        FIND_ID("FindID"),
        FIND_PW("FindPW"),
        RESULT_MENT_FIND_ID("ResultMentFindID"),
        RESULT_MENT_FIND_PW("ResultMentFindPW"),
        RESULT_MENT_SIGN_UP("ResultMentSignUp"),
        SIGN_IN("SignIn"),
        SIGN_UP("SignUp");
        private String path;
        private ESignPath(String path) {this.path = path;}
        public String getPath() {return "signView/"+ this.path;}
    }

    /*
     * CityInfoController Path Constants
     */
    public enum ECityInfoPath {
        CITY_INFO_GRID("CityInfoGrid"),
        CITY_INFO("CityInfo");
        private String path;
        private ECityInfoPath(String path) {this.path = path;}
        public String getPath() {return "cityInfoView/"+this.path;}
    }

    /*
     * ReviewController Path Constants
     */
    public enum EReviewPath {
        DEFAULT_REVIEW_PAGE("DefaultReviewPage"),
        REVIEW_CONTENT("ReviewContent"),
        REVIEW_WRITER("ReviewWriter"),
        CATEGORY_REVIEW_PAGE("CategoryReviewPage"),
        SEARCH_REVIEW_PAGE("SearchReviewPage"),
        REDIRECT_REVIEW_CONTENT("redirect:getReview");
        private String path;
        private EReviewPath(String path) {this.path = path;}
        public String getPath() {return "reviewView/"+this.path;}
        public String getRedirectPath() {return this.path;}
    }

    /*
     * ScheduleController Path Constants
     */
    public enum ESchedulePath {
        OTHER_SCHEDULE("OtherSchedule"),
        OTHER_SCHEDULE_LIST("OtherScheduleList"),
        SCHEDULE("Schedule"),
        REDIRECT_OTHER_SCHEDULELIST("redirect:otherScheduleList"),
        REDIRECT_SCHEDULE("redirect:schedule"),
        REDIRECT_OTHER_SCHEDULE("redirect:otherSchedule");
        private String path;
        private ESchedulePath(String path) {this.path = path;}
        public String getPath() {return "scheduleView/"+this.path;}
        public String getRedirectPath() {return this.path;}
    }

    /*
     * CustomerCenterController Path Constants
     */
    public enum ECustomerCenterPath {
        FAQ("Faq","FAQ"),
        PERSONAL_TERMS("PersonalTerms","개인정보 처리방침"),
        TERMS_AND_CONDITIONS("TermsAndConditions","이용약관"),
        NOTICE("Notice","공지사항");
        private String path;
        private String menuName;
        private ECustomerCenterPath(String path,String menuName) {
            this.path = path;
            this.menuName = menuName;
        }
        public String getPath() {return "customerCenterView/"+this.path;}
        public String getText() {return this.path;}
        public String getMenuName() {return this.menuName;}
    }
}
