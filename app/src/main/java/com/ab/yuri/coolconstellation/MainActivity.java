package com.ab.yuri.coolconstellation;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ab.yuri.coolconstellation.util.HttpUtil;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private List<Constellation> constellationList=new ArrayList<>();
    private ConstellationAdapter constellationAdapter;
    private RecyclerView recyclerView;
    private ImageView bingPicImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        bingPicImg= (ImageView) findViewById(R.id.bing_pic_img);

        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        initConstellation();
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        constellationAdapter=new ConstellationAdapter(constellationList);
        recyclerView.setAdapter(constellationAdapter);

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String bingPic=prefs.getString("bing_pic",null);
        if (bingPic!=null){
            Glide.with(this).load(bingPic).into(bingPicImg);
        }else {
            loadBingPic();
        }

    }

    private void initConstellation(){
        Constellation baiyang=new Constellation("白羊座",R.drawable.ic_baiyang,R.drawable.baiyang);
        constellationList.add(baiyang);
        Constellation jinniu=new Constellation("金牛座",R.drawable.ic_jinniu,R.drawable.jinniu);
        constellationList.add(jinniu);
        Constellation shuangzi=new Constellation("双子座",R.drawable.ic_shuangzi,R.drawable.shuangzi);
        constellationList.add(shuangzi);
        Constellation juxie=new Constellation("巨蟹座",R.drawable.ic_juxie,R.drawable.juxie);
        constellationList.add(juxie);
        Constellation shizi=new Constellation("狮子座",R.drawable.ic_shizi,R.drawable.shizi);
        constellationList.add(shizi);
        Constellation chunv=new Constellation("处女座",R.drawable.ic_chunv,R.drawable.chunv);
        constellationList.add(chunv);
        Constellation tianchen=new Constellation("天秤座",R.drawable.ic_tianchen,R.drawable.tiancheng);
        constellationList.add(tianchen);
        Constellation tianxie=new Constellation("天蝎座",R.drawable.ic_tianxie,R.drawable.tianxie);
        constellationList.add(tianxie);
        Constellation sheshou=new Constellation("射手座",R.drawable.ic_sheshou,R.drawable.sheshou);
        constellationList.add(sheshou);
        Constellation mojie=new Constellation("摩羯座",R.drawable.ic_mojie,R.drawable.mojie);
        constellationList.add(mojie);
        Constellation shuiping=new Constellation("水瓶座",R.drawable.ic_shuiping,R.drawable.shuiping);
        constellationList.add(shuiping);
        Constellation shuangyu=new Constellation("双鱼座",R.drawable.ic_shuangyu,R.drawable.shuangyu);
        constellationList.add(shuangyu);
    }

    //加载背景图片
    private void loadBingPic(){
        String requestBingPic="http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic=response.body().string();
                SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(MainActivity.this).load(bingPic).into(bingPicImg);
                    }
                });

            }
        });
    }
}
