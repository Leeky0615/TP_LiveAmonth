package com.liveamonth.liveamonth.constants;

public class EntityConstants {
    /*
     * DB테이블 및 VO클래스에서 사용하는 Attributes
     * 1. DB테이블의 attribute이름과 설정한 text의 값이 같아야 함.
     * 2. 테이블의 row값을 하나의 객체로 받아오기 위해 "테이블 명+VO" 추가.
     * 3. 테이블의 row값을 여러개의 객체로 받아오기 위해 "테이블 명+VO_LIST" 추가
     */

    public EntityConstants() { }

    /*
    * CityInfo Table Constants
    */
    public enum ECityInfo {
        CITY_INFO_VO("cityInfoVO"),
        CITY_INFO_VO_LIST("cityInfoVOList"),
        CITY_INFO_NO("cityInfoNO"),
        CITY_INFO_CATEGORY("cityInfoCategory"),
        CITY_INFO_NAME("cityInfoName"),
        CITY_INFO_IMAGE_URL("cityInfoImageURL"),
        CITY_INFO_DESC("cityInfoDesc");
        private String text;
        private ECityInfo(String text) {this.text = text;}
        public String getText() {return this.text;}
    }
    public enum ECityName{
        CITY_GN("강릉","gangneung"),
        CITY_SE("서울","seoul"),
        CITY_KJ("경주","kyungju"),
        CITY_YS("여수","yeosu"),
        CITY_BS("부산","busan"),
        CITY_JJ("제주","jeju");
        private String nameKR, nameEN;
        private ECityName(String nameKR, String nameEN){
            this.nameKR = nameKR;
            this.nameEN = nameEN;
        }
        public String getNameKR() {return this.nameKR;}
        public String getNameEN() {return this.nameEN;}
    }
    public enum ECityCategory{
        CATEGORY_INTRO("INTRO","Intro"),
        CATEGORY_FOOD("FOOD","Food"),
        CATEGORY_VIEW("VIEW","View");
        private String category_uc;
        private String category_lc;
        private ECityCategory(String category_uc,String category_lc) {
            this.category_uc = category_uc;
            this.category_lc = category_lc;
        }
        public String getCategoryUppercase() {return this.category_uc;}
        public String getCategoryLowerCase() {return this.category_lc;}
    }

    /*
     * ReviewReply Table Constants
     */
    public enum EReviewReply {
        REVIEW_REPLY_VO("reviewReplyVO"),
        REVIEW_REPLY_NO("reviewReplyNO"),
        REVIEW_REPLY_DESC("reviewReplyDesc"),
        REVIEW_REPLY_DATE("reviewReplyDate"),
        REVIEW_REPLY_REF_NO("reviewReplyRefNO");
        private String text;
        private EReviewReply(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    /*
     * Review Table Constants
     */
    public enum EReview {
        REVIEW_VO("reviewVO"),
        REVIEW_NO("reviewNO"),
        REVIEW_CATEGORY("reviewCategory"),
        REVIEW_SUBJECT("reviewSubject"),
        REVIEW_DESC("reviewDesc"),
        REVIEW_LIKE_COUNT("reviewLikeCount"),
        REVIEW_DATE("reviewDate"),
        REVIEW_VIEW_COUNT("reviewViewCount");
        private String text;
        private EReview(String text) {this.text = text;}
        public String getText() {return this.text;}
    }


    /*
     * ScheduleContent Table Constants
     */
    public enum EScheduleContent {
        SCHEDULE_CONTENT_VO("scheduleContentVO"),
        SCHEDULE_CONTENT_NO("scheduleContentNO"),
        SCHEDULE_CONTENT_SUBJECT("scheduleContentSubject"),
        SCHEDULE_CONTENT_DESC("scheduleContentDesc"),
        SCHEDULE_CONTENT_DATE("scheduleContentDate"),
        SCHEDULE_CONTENT_COST("scheduleContentCost");
        private String text;
        private EScheduleContent(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    /*
     * ScheduleReply Table Constants
     */
    public enum EScheduleReply {
        SCHEDULE_REPLY_VO("reviewReplyVO"),
        SCHEDULE_REPLY_NO("reviewReplyNO"),
        SCHEDULE_REPLY_DESC("reviewReplyDesc"),
        SCHEDULE_REPLY_DATE("reviewReplyDate"),
        SCHEDULE_REPLY_REF_NO("reviewReplyRefNO");
        private String text;
        private EScheduleReply(String text) {this.text = text;}
        public String getText() {return this.text;}
    }


    /*
     * Schedule Table Constants
     */
    public enum ESchedule{
        SCHEDULE_VO("scheduleVO"),
        SCHEDULE_VO_LIST("scheduleVOList"),
        SCHEDULE_NO("scheduleNO"),
        SCHEDULE_SUBJECT("scheduleSubject"),
        SCHEDULE_LIKE_COUNT("scheduleLikeCount"),
        SCHEDULE_STATUS("scheduleStatus"),
        SCHEDULE_PLACE("schedulePlace");
        private String text;
        private ESchedule(String text) {this.text = text;}
        public String getText() {return this.text;}
    }


    /*
     * User Table Constants
     */
    public enum EUser{
        USER_VO("userVO"),
        USER_NO("userNO"),
        USER_ID("userID"),
        USER_PASSWORD("userPassword"),
        USER_NAME("userName"),
        USER_NICKNAME("userNickname"),
        USER_AGE("userAge"),
        USER_SEX("userSex"),
        USER_EMAIL("userEmail");
        private String text;
        private EUser(String text) {this.text = text;}
        public String getText() {return this.text;}
    }


    /*
     * OneToOneAsk Table Constants
     */
    public enum EOneToOneAsk{
    	ONE_TO_ONE_ASK_NO("oneToOneAskNO"),
        ONE_TO_ONE_ASK_VO("oneToOneAskVO"),
        ONE_TO_ONE_ASK_VO_LIST("oneToOneAskVOList"),
        ONE_TO_ONE_ASK_CATEGORY("oneToOneAskCategory");
        private String text;
        private EOneToOneAsk(String text) {this.text = text;}
        public String getText() {return this.text;}
    }
}
