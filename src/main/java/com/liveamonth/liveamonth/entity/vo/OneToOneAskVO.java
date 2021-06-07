package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import static com.liveamonth.liveamonth.constants.EntityConstants.*;

@Data
public class OneToOneAskVO {

    // Attributes
    private int oneToOneAskNO;
    private OneToOneAskCategory oneToOneAskCategory;
    private String oneToOneAskSubject;
    private String oneToOneAskDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String oneToOneAskDate;
    String oneToOneAskImage;
    String oneToOneAskUserEmail;
    String oneToOneAskReply;

    int userNO; // Reference

    // Constructor
    public OneToOneAskVO() {
        this.oneToOneAskNO = 0;
        this.oneToOneAskCategory = null;
        this.oneToOneAskSubject = null;
        this.oneToOneAskDesc = null;
        this.oneToOneAskDate = null;
        this.oneToOneAskImage = null;
        this.oneToOneAskUserEmail = null;
        this.oneToOneAskReply = null;

        this.userNO = 0;
    }

    // Getter & Setter
    public int getOneToOneAskNO() {
        return oneToOneAskNO;
    }
    public void setOneToOneAskNO(int oneToOneAskNO) {
        this.oneToOneAskNO = oneToOneAskNO;
    }

    public OneToOneAskCategory getOneToOneAskCategory() {return oneToOneAskCategory;}
    public void setOneToOneAskCategory(OneToOneAskCategory oneToOneAskCategory) {this.oneToOneAskCategory = oneToOneAskCategory;}

    public String getOneToOneAskImage() {return oneToOneAskImage;}
    public void setOneToOneAskImage(String oneToOneAskImage) {this.oneToOneAskImage = oneToOneAskImage;}

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

    public String getOneToOneAskUserEmail() {
        return oneToOneAskUserEmail;
    }
    public void setOneToOneAskUserEmail(String oneToOneAskUserEmail) {this.oneToOneAskUserEmail = oneToOneAskUserEmail;}

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

    // Get URL
    public String getOneToOneAskImageURL(){
        return IMAGE_URL +"onetooneask/"+this.getOneToOneAskImage();
    }
}
