package com.ab.yuri.coolconstellation.util;

import com.ab.yuri.coolconstellation.gson.Month;
import com.ab.yuri.coolconstellation.gson.Today;
import com.ab.yuri.coolconstellation.gson.Week;
import com.google.gson.Gson;

/**
 * Created by Yuri on 2017/1/16.
 */

public class Utility {
    public static Today handleTodayResponse(String response) {
        try {
            Gson gson=new Gson();
            Today today=gson.fromJson(response,Today.class);
            return today;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Week handleWeekResponse(String response) {
        try {
            Gson gson=new Gson();
            Week week=gson.fromJson(response,Week.class);
            return week;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Month handleMonthResponse(String response) {
        try {
            Gson gson=new Gson();
            Month month=gson.fromJson(response,Month.class);
            return month;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
