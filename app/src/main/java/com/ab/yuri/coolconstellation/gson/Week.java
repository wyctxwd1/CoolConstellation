package com.ab.yuri.coolconstellation.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Week {

    /**
     * name : 金牛座
     * weekth : 3
     * date : 2017年01月16日-2017年01月22日
     * health : 健康：本周金牛人忙碌的工作会给身体造成不小的负担，注意平衡，建议进行食补。 作者：星言，forseiya
     * job : 求职：本周金牛人求职运看似机会无限，但是暗藏压力和陷阱，注意慧眼识别。
     * love : 恋爱：本周单身金牛人开始收敛部分社交活动，桃花运自然受到一些影响，已婚的朋友开始审视相互之间的差异。
     * money : 财运：本周金牛人财运压力大，辛苦工作但是汇报甚微。
     * work : 工作：本周金牛人与领导之间的问题会逐步暴露出来，但也是一轮新的调整的开始。
     * resultcode : 200
     * error_code : 0
     */

    @SerializedName("date")
    public String weekDate;
    @SerializedName("health")
    public String weekHealth;
    @SerializedName("love")
    public String weekLove;
    @SerializedName("work")
    public String weekWork;
    @SerializedName("resultcode")
    public String resultCode;
}
