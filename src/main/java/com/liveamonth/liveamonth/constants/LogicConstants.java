package com.liveamonth.liveamonth.constants;

public class LogicConstants {
    /*
     * Controller 클래스에서 사용되는 Static & model.attribute 상수
     * -> VO와 관련된 Enum은 모두 EntityConstants로
     */
    public LogicConstants() {}

    public enum EAlertMessage{
        MAXIMUM_SCHEDULE_CONTENT("스케쥴은 최대 4개만 등록 가능합니다."),
        ADD_SCHEDULE_CONTENT("스케줄이 등록되었습니다"),

        ADD_SCHEDULE("캘린더가 추가되었습니다"),
        FAIL_TO_ADD_SCHEDULE("캘린더 추가에 실패하였습니다."),
        COMPLETE_SCHEDULE_MODIFICATION("캘린더가 수정되었습니다."),
        FAIL_TO_MODIFY_SCHEDULE("캘린더 수정에 실패하였습니다."),
        COMPLETE_SCHEDULE_DELETION("캘린더가 삭제되었습니다.."),
        FAIL_TO_DELETE_SCHEDULE("캘린더 삭제에 실패하였습니다."),

        ADD_SCHEDULEREPLY("댓글 등록이 완료되었습니다."),
        FAIL_TO_ADD_SCHEDULEREPLY("댓글 등록에 실패하였습니다."),
        COMPLETE_SCHEDULEREPLY_MODIFICATION("댓글이 수정되었습니다."),
        FAIL_TO_MODIFY_SCHEDULEREPLY("댓글 수정에 실패하였습니다."),
        COMPLETE_SCHEDULEREPLY_DELETION("댓글이 삭제되었습니다.."),
        FAIL_TO_DELETE_SCHEDULEREPLY("댓글 삭제에 실패하였습니다.");

        private String text;
        private EAlertMessage(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EScheduleAttributes{
        SELECTED_SCHEDULE_NO("selectedScheduleNO"),
        MESSAGE("message"),
        SCHEDULE_PLACE_LIST("schedulePlaceList"),
        SCHEDULE_ACTION("action"),
        SCHEDULE_LIST("list"),
        SCHEDULE_FILTER("filter"),
        MODIFY_SCHEDULE_CONTENT_SUBJECT("modifyScheduleContentSubject"),
        MODIFY_SCHEDULE_CONTENT_DESC("modifyScheduleContentDesc"),
        MODIFY_SCHEDULE_CONTENT_COST("modifyScheduleContentCost"),
        DATE_LIST("dateList"),
        TODAY_INFORMATION("todayInformation"),
        SCHEDULEREPLY_VO_LIST("scheduleVOReplyList"),
        SELECT_SCHEDULE("selectSchedule"),
        FITERED_OTHER_SCHEDULE_LIST("otherScheduleList"),
        REQUEST_LIST("requestList"),
        OTHER_SCHEDULE_AND_LIKE_COUNT("otherScheduleAndLikeCount");
        private String text;
        private EScheduleAttributes(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EScheduleStaticInt {
        FIRST_SCHEDULEREPLY_NO(501),
        FIRST_SCHEDULE_NO(200),
        STATIC_DISPLAY_PAGE_NUM(15),
        FIRST_SCHEDULECONTENT_NO(301);
        private int text;
        private EScheduleStaticInt(int text) {this.text = text;}
        public int getText(){return this.text;}
    }


    public enum EScheduleFilterAndOrders{
        SCHEDULE_FO_SEX("userSex"),
        SCHEDULE_FO_AGE("userAge"),
        SCHEDULE_FO_PLACE("schedulePlace"),
        SCHEDULE_FO_ORDER("orderBy");
        private String text;
        private EScheduleFilterAndOrders(String text) {this.text = text;}
        public String getText() {return this.text;}
    }
    public enum EMyPageAttributes {
        CHECK_USER("checkUser");

        private String text;
        private EMyPageAttributes(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum ECityInfoAttributes {
        PAGE("page"),
        CITY_NAME("cityName"),
        SELECTED_CITY_NAME("selectedCityName"),
        CITY_INTRO("cityIntro"),
        CITY_INTRO_LIST("cityIntroList"),
        CITY_VIEW_LIST("cityViewList"),
        CITY_FOOD_LIST("cityFoodList"),
        CITY_NAME_LIST("cityNameList");
        private String text;
        private ECityInfoAttributes(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum ESignAttributes{
        FIRST_IN("firstIn");
        private String text;
        private ESignAttributes(String text){this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EPaging{
        SELECTED_PAGE("selectedPage"),
        LIKE_STATUS("likeStatus"),
        LIKE_COUNT("likeCount"),
        START_NO("startNO"),
        PAIGING("paging");

        private String text;
        private EPaging(String text){this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EReviewAttribute{
        REVIEW_TYPE_LIST("reviewTypeList"),
        REVIEW_PLACE_LIST("reviewPlaceList"),
        REVIEW_CATEGORY_LIST("reviewCategoryList");

        private String text;
        private EReviewAttribute(String text){this.text = text;}
        public String getText() {return this.text;}
    }
}
