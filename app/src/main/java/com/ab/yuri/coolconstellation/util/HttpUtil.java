package com.ab.yuri.coolconstellation.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Yuri on 2017/1/14.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client =new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
