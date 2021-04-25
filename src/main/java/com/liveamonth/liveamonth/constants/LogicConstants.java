package com.liveamonth.liveamonth.constants;

public class LogicConstants {
    public LogicConstants() {}

    public enum EAlertMessage{
        MAXIMUM_SCHEDULE_CONTENT("스케쥴은 최대 4개만 등록 가능합니다."),
        ADD_SCHEDULE_CONTENT("스케줄이 등록되었습니다"),
        FAIL_TO_ADD_SCHEDULE_CONTENT("스케줄 추가에 실패하였습니다."),
        COMPLETE_SCHEDULE_MODIFICATION_CONTENT("스케줄 수정이 완료되었습니다."),
        FAIL_TO_MODIFY_SCHEDULE_CONTENT("스케줄 수정에 실패하였습니다."),
        COMPLETE_SCHEDULE_DELETION_CONTENT("스케줄이 삭제되었습니다.."),
        FAIL_TO_DELETE_SCHEDULE_CONTENT("스케줄 삭제에 실패하였습니다."),

        ADD_SCHEDULE("캘린더가 추가되었습니다"),
        FAIL_TO_ADD_SCHEDULE("캘린더 추가에 실패하였습니다."),
        COMPLETE_SCHEDULE_MODIFICATION("캘린더가 수정되었습니다."),
        FAIL_TO_MODIFY_SCHEDULE("캘린더 수정에 실패하였습니다."),
        COMPLETE_SCHEDULE_DELETION("캘린더가 삭제되었습니다.."),
        FAIL_TO_DELETE_SCHEDULE("캘린더 삭제에 실패하였습니다."),

        ADD_SCHEDULEREPLY("댓글 등록이 완료되었습니다."),
        FAIL_TO_ADD_SCHEDULEREPLY("댓글 등록에 실패하였습니다.");

        private String text;
        private EAlertMessage(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EScheduleAttributes{
        SELECTED_SCHEDULE_NO("selectedScheduleNO"),
        MESSAGE("message"),
        SCHEDULE_VO_LIST("scheduleVOList"),
        USER_VO_LIST("userVOList"),
        PLACE_LIST("placeList"),
        SCHEDULE_SEX("sex"),
        SCHEDULE_AGE("age"),
        SCHEDULE_PLACE("place"),
        MODIFY_SCHEDULE_CONTENT_SUBJECT("modifyScheduleContentSubject"),
        MODIFY_SCHEDULE_CONTENT_DESC("modifyScheduleContentDesc"),
        MODIFY_SCHEDULE_CONTENT_COST("modifyScheduleContentCost"),
        DATE_LIST("dateList"),
        TODAY_INFORMATION("todayInformation"),
        SCHEDULEREPLY_VO_LIST("scheduleVOReplyList"),
        SELECT_SCHEDULE("selectSchedule");
        private String text;
        private EScheduleAttributes(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum EMyPageAttributes {
        CHECK_USER("checkUser");
        private String text;
        private EMyPageAttributes(String text) {this.text = text;}
        public String getText() {return this.text;}
    }

    public enum ESignAttributes{
        FIRST_IN("firstIn");
        private String text;
        private ESignAttributes(String text){this.text = text;}
        public String getText() {return this.text;}
    }
}
