package com.liveamonth.liveamonth.constants;

public class ControllerPathConstants {
    public enum EMainPath {
        MAIN("Main");
        private String path;
        private EMainPath(String path) {this.path = path;}
        public String getPath() {return this.path;}
    }
    public enum EMyPagePath {
        MY_PAGE("MyPage"),
        MODIFY_USER_INFO("ModifyUserInfo"),
        RE_CHECK_USER_PW("ReCheckUserPW"),
        DROP_USER("DropUser"),
        RESULT_MENT_DROP_USER("ResultMentDropUser"),
        RESULT_MENT_MODIFY_USER_INFO("ResultMentModifyUserInfo");
        private String path;
        private EMyPagePath(String path) {this.path = "myPageView/"+path;}
        public String getPath() {return this.path;}
    }
    public enum ESignPath {
        FIND_ID("FindID"),
        FIND_PW("FindPW"),
        RESULT_MENT_FIND_ID("ResultMentFindID"),
        RESULT_MENT_FIND_PW("ResultMentFindPW"),
        RESULT_MENT_SIGN_UP("ResultMentSignUp"),
        SIGN_IN("SignIn"),
        SIGN_UP("SignUp");
        private String path;
        private ESignPath(String path) {this.path = "signView/"+path;}
        public String getPath() {return this.path;}
    }
    public enum ECityInfoPath {
        CITY_INFO("CityInfo"),
        JEJU_INFO("JejuInfo"),
        YEOSU_INFO("YeosuInfo"),
        SEOUL_INFO("SeoulInfo"),
        GYEONGJU_INFO("GyeongjuInfo"),
        BUSAN_INFO("BusanInfo"),
        GANGNEUNG_INFO("GangneungInfo");
        private String path;
        private ECityInfoPath(String path) {this.path = "cityInfoView/"+path;}
        public String getPath() {return this.path;}
    }
    public enum EReviewPath {
        REVIEW("Review");
        private String text;
        private EReviewPath(String path) {this.text = "reviewView/"+path;}
        public String getPath() {return this.text;}
    }
    public enum ESchedulePath {
        OTHER_SCHEDULE("scheduleView/OtherSchedule"),
        OTHER_SCHEDULE_LIST("scheduleView/OtherScheduleList"),
        SCHEDULE("scheduleView/Schedule"),
        REDIRECT_SCHEDULE("redirect:schedule");
        private String text;
        private ESchedulePath(String path) {this.text = path;}
        public String getPath() {return this.text;}
    }
}
