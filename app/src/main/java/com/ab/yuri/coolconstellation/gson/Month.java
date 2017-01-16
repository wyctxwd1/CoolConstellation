package com.ab.yuri.coolconstellation.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Month {

    /**
     * date : 2017年01月
     * name : 金牛座
     * month : 1
     * all : 热衷于参加各种各样的聚会和团体活动，魅力值剧增，可能会成为朋友圈中的万人迷。
     * health : 注意踝关节，出行小心扭伤。
     * love : 单身的人多多出去放电吧，你迷人的魅力值得更多人欣赏。有伴的人，在人多的场合可能会莫名其妙吵起来，要多多注意，遇到意见不合的情况，多一点耐心，少一点冲动会更好。
     * money : 这个月水星逆行在资源宫关联人际宫的海王星，小心与人产生财务纠纷。
     * work : 忙碌的事情可能会出现反反复复的情况，有些重要合约的签订也要小心，粗心不得。同事之间，可能会有些误会，让你不想去面对，有时候多一分解释会更好。
     * happyMagic :
     * resultcode : 200
     * error_code : 0
     */

    @SerializedName("date")
    public String monthDate;
    @SerializedName("all")
    public String monthAll;
    @SerializedName("health")
    public String monthHealth;
    @SerializedName("love")
    public String monthLove;
    @SerializedName("work")
    public String monthWork;
    @SerializedName("resultcode")
    public String resultCode;
}
