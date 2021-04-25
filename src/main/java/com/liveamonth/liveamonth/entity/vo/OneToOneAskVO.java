package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Data
public class OneToOneAskVO {
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

        public void setLabel(String label) {
            this.label = label;
        }
    }

    private int oneToOneAskNO;
    private OneToOneAskCategory oneToOneAskCategory;
    private String oneToOneAskSubject;
    private String oneToOneAskDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String oneToOneAskDate;
    int oneToOneAskViewCount;
    String oneToOneAskImageURL;
    String oneToOneAskUserEmail;
    String oneToOneAskReply;
    int userNO;

    public OneToOneAskVO() {
        this.oneToOneAskNO = 0;
        this.oneToOneAskCategory = null;
        this.oneToOneAskSubject = null;
        this.oneToOneAskDesc = null;
        this.oneToOneAskDate = null;
        this.oneToOneAskViewCount = 0;
        this.oneToOneAskImageURL = null;
        this.oneToOneAskUserEmail = null;
        this.oneToOneAskReply = null;
        this.userNO = 0;
    }


    public int getOneToOneAskNO() {
        return oneToOneAskNO;
    }

    public void setOneToOneAskNO(int oneToOneAskNO) {
        this.oneToOneAskNO = oneToOneAskNO;
    }

    public OneToOneAskCategory getOneToOneAskCategory() {
        return oneToOneAskCategory;
    }

    public void setOneToOneAskCategory(OneToOneAskCategory oneToOneAskCategory) {
        this.oneToOneAskCategory = oneToOneAskCategory;
    }

    public String getOneToOneAskSubject() {
        return oneToOneAskSubject;
    }

    public void setOneToOneAskSubject(String oneToOneAskSubject) {
        this.oneToOneAskSubject = oneToOneAskSubject;
    }

    public String getOneToOneAskDesc() {
        return oneToOneAskDesc;
    }

    public void setOneToOneAskDesc(String oneToOneAskDesc) {
        this.oneToOneAskDesc = oneToOneAskDesc;
    }

    public String getOneToOneAskDate() {
        return oneToOneAskDate;
    }


    public void setOneToOneAskDate(String oneToOneAskDate) {
        this.oneToOneAskDate = oneToOneAskDate;
    }


    public int getOneToOneAskViewCount() {
        return oneToOneAskViewCount;
    }


    public void setOneToOneAskViewCount(int oneToOneAskViewCount) {
        this.oneToOneAskViewCount = oneToOneAskViewCount;
    }


    public String getOneToOneAskImageURL() {
        return oneToOneAskImageURL;
    }

    public void setOneToOneAskImageURL(String oneToOneAskImageURL) {
        this.oneToOneAskImageURL = oneToOneAskImageURL;
    }


    public String getOneToOneAskUserEmail() {
        return oneToOneAskUserEmail;
    }


    public void setOneToOneAskUserEmail(String oneToOneAskUserEmail) {
        this.oneToOneAskUserEmail = oneToOneAskUserEmail;
    }


    public String getOneToOneAskReply() {
        return oneToOneAskReply;
    }

    public void setOneToOneAskReply(String oneToOneAskReply) {
        this.oneToOneAskReply = oneToOneAskReply;
    }

    public int getUserNO() {
        return userNO;
    }

    public void setUserNO(int userNO) {
        this.userNO = userNO;
    }


}
