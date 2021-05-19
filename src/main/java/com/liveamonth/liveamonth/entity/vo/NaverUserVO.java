package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class NaverUserVO {

    public String naverID;
    public String email;
    public String name;
    public String gender;
    public String birthyear;
    public String nickname;

    public NaverUserVO(){
        this.naverID = null;
        this.email =  null;
        this.name = null;
        this.gender =  null;
        this.birthyear =  null;
        this.nickname =  null;
    }
}
