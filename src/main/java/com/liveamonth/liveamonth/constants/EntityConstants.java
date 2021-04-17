package com.liveamonth.liveamonth.constants;

public class EntityConstants {
    public EntityConstants() { }

    public enum ECityInfo {
        CITY_INFO_VO("cityInfoVO"),
        CITY_INFO_NO("cityInfoNO"),
        CITY_INFO_CATEGORY("cityInfoCategory"),
        CITY_INFO_NAME("cityInfoName"),
        CITY_INFO_IMAGE_URL("cityInfoImageURL"),
        CITY_INFO_DESC("cityInfoDesc");
        private String text;
        private ECityInfo(String text) {this.text = text;}
        public String getText() {return this.text;}
    }
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

    public enum ESchedule{
        SCHEDULE_VO("scheduleVO"),
        SCHEDULE_NO("scheduleNO"),
        SCHEDULE_SUBJECT("scheduleSubject"),
        SCHEDULE_LIKE_COUNT("scheduleLikeCount"),
        SCHEDULE_STATUS("scheduleStatus"),
        SCHEDULE_PLACE("place");
        private String text;
        private ESchedule(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

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
}
