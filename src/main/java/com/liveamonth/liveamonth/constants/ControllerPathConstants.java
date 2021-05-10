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
    public enum EMainPath {
        MAIN("Main");
        private String path;
        private EMainPath(String path) {this.path = path;}
        public String getPath() {return this.path;}
    }

    /*
     * MyPageController Path Constants
     */
    public enum EMyPagePath {
        MY_PAGE("MyPage"),
        MODIFY_USER_INFO("ModifyUserInfo"),
        RE_CHECK_PASSWORD("ReCheckPassword"),
        RESULT_MENT("ResultMent"),
    	FINALLY_ASK_DROP_USER("FinallyAskDropUser"),
    	ONE_TO_ONE_ASK("OneToOneAsk"),
    	SHOW_ONE_TO_ONE_ASK("ShowOneToOneAsk"),
    	Write_ONE_TO_ONE_ASK("WriteOneToOneAsk"),
    	RESULT_MENT_ONE_TO_ONE_ASK("ResultMentOneToOneAsk"),
    	RESULT_MENT_DELETE_ONE_TO_ONE_ASK("ResultMentDeleteOneToOneAsk"),
        PERSONAL_TERMS("PersonalTerms"),
        FAQ("Faq");
        private String path;
        private EMyPagePath(String path) {this.path = path;}
        public String getPath() {return "myPageView/"+this.path;}
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
        FIRST_REVIEW_PAGE("FirstReviewList"),
        REVIEW_CONTENT("ReviewContent"),
        REVIEW_WRITER("ReviewWriter"),
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
        REDIRECT_SCHEDULE("redirect:schedule"),
        REDIRECT_OTHER_SCHEDULE("redirect:otherSchedule");
        private String path;
        private ESchedulePath(String path) {this.path = path;}
        public String getPath() {return "scheduleView/"+this.path;}
        public String getRedirectPath() {return this.path;}
    }
}
