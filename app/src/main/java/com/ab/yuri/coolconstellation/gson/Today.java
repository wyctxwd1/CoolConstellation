package com.ab.yuri.coolconstellation.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Today {

    /**
     * date : 20170116
     * name : 狮子座
     * datetime : 2017年01月16日
     * all : 40%
     * color : 紫色
     * health : 60%
     * love : 40%
     * money : 20%
     * number : 2
     * QFriend : 白羊座
     * summary : 居家事宜引起你的关注，家庭关系可能有波动，或是装修买房需要你认真把关。部分人受到投资亏损的消息。出门在外注意交通安全，临走时候也不要一时心急忘记要带的东西。
     * work : 20%
     * resultcode : 200
     * error_code : 0
     */

    @SerializedName("datetime")
    public String todayDateTime;
    @SerializedName("all")
    public String todayAll;
    @SerializedName("color")
    public String todayColor;
    @SerializedName("summary")
    public String todaySummary;

    @SerializedName("resultcode")
    public String resultCode;
}
