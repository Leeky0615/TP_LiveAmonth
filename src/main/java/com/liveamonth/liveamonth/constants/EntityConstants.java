package com.liveamonth.liveamonth.constants;

public class EntityConstants {
    /*
     * DB테이블 및 VO클래스에서 사용하는 Attributes
     * 1. DB테이블의 attribute이름과 설정한 text의 값이 같아야 함.
     * 2. 테이블의 row값을 하나의 객체로 받아오기 위해 "테이블 명+VO" 추가.
     * 3. 테이블의 row값을 여러개의 객체로 받아오기 위해 "테이블 명+VO_LIST" 추가
     */
    public EntityConstants() {
    }

    public static String ImageURL = "https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/";

    /*
     * sign Table Constants
     */
    public enum ESignUp {
        EMAIL("email");
        private String text;
        private ESignUp(String text) {
            this.text = text;
        }
        public String getText() {
            return this.text;
        }
    }

    /*
     * City Table Constants
     */
    public enum ECity {
        CITY_VO("cityVO"),
        CITY_VO_LIST("cityVOList"),
        CITY_NO("cityNO"),
        CITY_NAME("cityName");
        private String text;

        private ECity(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    public enum CityName {
        SEOUL("서울"),
        GANGNEUNG("강릉"),
        GYEONGJU("경주"),
        BUSAN("부산"),
        YEOSU("여수"),
        JEJU("제주"),
        ALL_PLACE("전지역");
        private String nameKR;

        private CityName(String nameKR) {
            this.nameKR = nameKR;
        }

        public String getNameKR() {
            return this.nameKR;
        }
    }

    public enum ECityInfo {
        CITY_INFO_VO("cityInfoVO"),
        CITY_INFO_VO_LIST("cityInfoVOList"),
        CITY_INFO_NO("cityInfoNO"),
        CITY_INFO_CATEGORY("cityInfoCategory"),
        CITY_INFO_DESC("cityInfoDesc"),
        CITY_INFO_IMAGE("cityInfoImage");
        private String text;

        private ECityInfo(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    public enum CityInfoCategory {
        INTRO("Intro", "intro/"),
        FOOD("Food", "food/"),
        VIEW("View", "view/");
        private String text;
        private String path;

        private CityInfoCategory(String text, String path) {
            this.text = text;
            this.path = path;
        }

        public String getText() {
            return this.text;
        }

        public String getPath() {
            return this.path;
        }
    }

    public enum ECityTransport {
        CITY_TRANSPORT_VO("cityTransportVO"),
        CITY_TRANSPOR_VO_LIST("cityTransportVOList"),
        CITY_TRANSPOR_NO("cityTransportNO"),
        CITY_TRANSPOR_CATEGORY("cityTransportCategory"),
        CITY_TRANSPOR_DESC("cityTransportCount");
        private String text;

        private ECityTransport(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    public enum CityTransportCategory {
        SUBWAY("지하철역"),
        BUS("버스 노선"),
        BICYCLE("공공자전거"),
        BUS_TERMINAL("버스 터미널"),
        TRAIN("기차역"),
        AIRPORT("공항");
        private String nameKR;
        private CityTransportCategory(String nameKR) {
            this.nameKR = nameKR;
        }
        public String getNameKR() {
            return this.nameKR;
        }
    }

    public enum ECityWeather {
        CITY_WEATHER_VO("cityTransportVO"),
        CITY_WEATHER_VO_LIST("cityTransportVOList"),
        CITY_WEATHER_NO("cityTransportNO"),
        CITY_WEATHER_MONTH("cityWeatherMonth"),
        CITY_WEATHER_MAX_TEMP("cityWeatherMaxTemp"),
        CITY_WEATHER_MIN_TEMP("cityWeatherMinTemp"),
        CITY_WEATHER_AVG_TEMP("cityWeatherAVGTemp");
        private String text;
        private ECityWeather(String text) {
            this.text = text;
        }
        public String getText() {
            return this.text;
        }
    }

    public enum Month {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sept, Oct, Nov, Dec}

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

        private EReviewReply(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
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
        REVIEW_DATE("reviewDate"),
        REVIEW_VIEW_COUNT("reviewViewCount");
        private String text;

        private EReview(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }



    public enum EReviewCategoryName{
        SEOUL_HOUSE_BOARD("서울ㅣ숙박시설"),
        GANGNEUNG_HOUSE_BOARD("강릉ㅣ숙박시설"),
        GYEONGJU_HOUSE_BOARD("경주ㅣ숙박시설"),
        BUSAN_HOUSE_BOARD("부산ㅣ숙박시설"),
        YEOSU_HOUSE_BOARD("여수ㅣ숙박시설"),
        JEJU_HOUSE_BOARD("제주ㅣ숙박시설"),

        SEOUL_GO_BOARD("서울ㅣ가볼만한곳"),
        GANGNEUNG_GO_BOARD("강릉ㅣ가볼만한곳"),
        GYEONGJU_GO_BOARD("경주ㅣ가볼만한곳"),
        BUSAN_GO_BOARD("부산ㅣ가볼만한곳"),
        YEOSU_GO_BOARD("여수ㅣ가볼만한곳"),
        JEJU_GO_BOARD("제주ㅣ가볼만한곳"),

        SEOUL_FOOD_BOARD("서울ㅣ먹을만한곳"),
        GANGNEUNG_FOOD_BOARD("강릉ㅣ먹을만한곳"),
        GYEONGJU_FOOD_BOARD("경주ㅣ먹을만한곳"),
        BUSAN_FOOD_BOARD("부산ㅣ먹을만한곳"),
        YEOSU_FOOD_BOARD("여수ㅣ먹을만한곳"),
        JEJU_FOOD_BOARD("제주ㅣ먹을만한곳"),

        SEOUL_REVIEW_BOARD("서울ㅣ솔직후기"),
        GANGNEUNG_REVIEW_BOARD("강릉ㅣ솔직후기"),
        GYEONGJU_REVIEW_BOARD("경주ㅣ솔직후기"),
        BUSAN_REVIEW_BOARD("부산ㅣ솔직후기"),
        YEOSU_REVIEW_BOARD("여수ㅣ솔직후기"),
        JEJU_REVIEW_BOARD("제주ㅣ솔직후기"),

        FREE_BOARD("자유게시판");
        private String nameKR;
        private EReviewCategoryName(String nameKR){this.nameKR = nameKR;}
        public String getNameKR() {return this.nameKR;}
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

        private EScheduleContent(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
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

        private EScheduleReply(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }


    /*
     * Schedule Table Constants
     */
    public enum ESchedule {
        SCHEDULE_VO("scheduleVO"),
        SCHEDULE_VO_LIST("scheduleVOList"),
        SCHEDULE_NO("scheduleNO"),
        SCHEDULE_SUBJECT("scheduleSubject"),
        SCHEDULE_VIEW_COUNT("scheduleViewCount"),
        SCHEDULE_STATUS("scheduleStatus"),
        SCHEDULE_PLACE("schedulePlace"),
        SCHEDULE_PAY_START_DAY("schedulePayStartDay"),
        SCHEDULE_PAY_FINISH_DAY("schedulePayFinishDay");
        private String text;

        private ESchedule(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }


    /*
     * User Table Constants
     */
    public enum EUser {
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

        private EUser(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }


    /*
     * OneToOneAsk Table Constants
     */
    public enum EOneToOneAsk {
        ONE_TO_ONE_ASK_NO("oneToOneAskNO"),
        ONE_TO_ONE_ASK_VO("oneToOneAskVO"),
        ONE_TO_ONE_ASK_VO_LIST("oneToOneAskVOList"),
        ONE_TO_ONE_ASK_CATEGORY("oneToOneAskCategory");
        private String text;

        private EOneToOneAsk(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    public enum OneToOneAskCategory {
        CATEGORY("카테고리"),
        CATEGORY1("카테고리1"),
        CATEGORY2("카테고리2"),
        CATEGORY3("카테고리3"),
        CATEGORY4("카테고리4");
        private String label;
        OneToOneAskCategory(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }
    }

    public enum EPage {
        DISPLAY_PAGE("displayPage");
        private String text;

        private EPage(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }


    public enum EEmail {
        select("선택하세요"),
        naver("naver.com"),
        google("gmail.com"),
        self("직접입력");
        private String label;

        EEmail(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
