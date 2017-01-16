package com.ab.yuri.coolconstellation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ab.yuri.coolconstellation.gson.Month;
import com.ab.yuri.coolconstellation.gson.Today;
import com.ab.yuri.coolconstellation.gson.Week;
import com.ab.yuri.coolconstellation.util.HttpUtil;
import com.ab.yuri.coolconstellation.util.Utility;
import com.bumptech.glide.Glide;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ConstellationActivity extends AppCompatActivity {
    public static final String CONSTELLATION_NAME="constellation_name";
    public static final String CONSTELLATION_IMG_VIEW="constellation_img_view";
    private Toolbar toolBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView constellationImgView;
    private LinearLayout todayTest;
    private LinearLayout weekTest;
    private LinearLayout monthTest;
    public SwipeRefreshLayout refreshLayout;
    private ImageView bg;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation);
        Intent intent=getIntent();
        final String constellationName=intent.getStringExtra(CONSTELLATION_NAME);
        int constellationImg=intent.getIntExtra(CONSTELLATION_IMG_VIEW,0);

        toolBar= (Toolbar) findViewById(R.id.constellation_toolbar);
        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.constellation_collapsing_toolbar);
        constellationImgView= (ImageView) findViewById(R.id.constellation_image_view);
        todayTest= (LinearLayout) findViewById(R.id.today_test);
        weekTest= (LinearLayout) findViewById(R.id.week_test);
        monthTest= (LinearLayout) findViewById(R.id.month_test);
        refreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        bg= (ImageView) findViewById(R.id.bg);

        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestTodayConstellation(constellationName);
                requestWeekConstellation(constellationName);
                requestMonthConstellation(constellationName);

            }
        });

        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }



        setSupportActionBar(toolBar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbarLayout.setTitle(constellationName);
        Glide.with(this).load(constellationImg).into(constellationImgView);
        Glide.with(this).load(R.drawable.bg).into(bg);


        requestTodayConstellation(constellationName);
        requestWeekConstellation(constellationName);
        requestMonthConstellation(constellationName);







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void requestTodayConstellation(final String constellationName){
        String constellationTodayUrl="http://web.juhe.cn:8080/constellation/getAll?consName="+constellationName+"&type=today&key=3d7aac36b1e02edd483218102e65d0ee";
        HttpUtil.sendOkHttpRequest(constellationTodayUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();
                        refreshLayout.setRefreshing(false);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseToday=response.body().string();
                final Today today= Utility.handleTodayResponse(responseToday);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (today!=null&&"200".equals(today.resultCode)){
                            showTodayInfo(today);
                        }else {
                            Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();

                        }
                        refreshLayout.setRefreshing(false);
                    }

                });

            }
        });

    }

    public void requestWeekConstellation(final String constellationName){
        String constellationWeekUrl="http://web.juhe.cn:8080/constellation/getAll?consName="+constellationName+"&type=week&key=3d7aac36b1e02edd483218102e65d0ee";
        HttpUtil.sendOkHttpRequest(constellationWeekUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();
                        refreshLayout.setRefreshing(false);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseWeek=response.body().string();
                final Week week= Utility.handleWeekResponse(responseWeek);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (week!=null&&"200".equals(week.resultCode)){
                            showWeekInfo(week);
                        }else {
                            Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();

                        }
                        refreshLayout.setRefreshing(false);
                    }
                });

            }
        });

    }

    public void requestMonthConstellation(final String constellationName){
        String constellationMonthUrl="http://web.juhe.cn:8080/constellation/getAll?consName="+constellationName+"&type=month&key=3d7aac36b1e02edd483218102e65d0ee";
        HttpUtil.sendOkHttpRequest(constellationMonthUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();
                        refreshLayout.setRefreshing(false);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseMonth=response.body().string();
                final Month month= Utility.handleMonthResponse(responseMonth);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (month!=null&&"200".equals(month.resultCode)){
                            showMonthInfo(month);
                        }else {
                            Toast.makeText(ConstellationActivity.this,"获取星座信息失败",Toast.LENGTH_SHORT).show();

                        }
                        refreshLayout.setRefreshing(false);
                    }
                });

            }
        });

    }




    private void showTodayInfo(Today today){
        todayTest.removeAllViews();

        View view= LayoutInflater.from(this).inflate(R.layout.today_item,todayTest,false);
        TextView todayDate= (TextView) view.findViewById(R.id.today_date);
        TextView todayAll= (TextView) view.findViewById(R.id.today_all);
        TextView todayColor= (TextView) view.findViewById(R.id.today_color);
        TextView todaySum= (TextView) view.findViewById(R.id.today_sum);

        todayDate.setText(today.todayDateTime);
        todayAll.setText("综合指数："+today.todayAll);
        todayColor.setText("幸运色："+today.todayColor);
        todaySum.setText("今日概述："+today.todaySummary);
        todayTest.addView(view);

    }

    private void showWeekInfo(Week week){
        weekTest.removeAllViews();
        View view= LayoutInflater.from(this).inflate(R.layout.week_item,weekTest,false);
        TextView weekDate= (TextView) view.findViewById(R.id.week_date);
        TextView weekHeath= (TextView) view.findViewById(R.id.week_health);
        TextView weekLove= (TextView) view.findViewById(R.id.week_love);
        TextView weekWork= (TextView) view.findViewById(R.id.week_work);

        weekDate.setText(week.weekDate);
        weekHeath.setText("健康运势："+week.weekHealth);
        weekLove.setText("爱情运势："+week.weekLove);
        weekWork.setText("工作运势："+week.weekWork);
        weekTest.addView(view);

    }

    private void showMonthInfo(Month month){
        monthTest.removeAllViews();
        View view=LayoutInflater.from(this).inflate(R.layout.month_item,monthTest,false);
        TextView monthDate= (TextView) view.findViewById(R.id.month_date);
        TextView monthHeath= (TextView) view.findViewById(R.id.month_health);
        TextView monthLove= (TextView) view.findViewById(R.id.month_love);
        TextView monthWork= (TextView) view.findViewById(R.id.month_work);
        TextView monthAll= (TextView) view.findViewById(R.id.month_all);

        monthDate.setText(month.monthDate);
        monthHeath.setText("健康运势："+month.monthHealth);
        monthLove.setText("爱情运势："+month.monthLove);
        monthWork.setText("工作运势："+month.monthWork);
        monthAll.setText("综合运势："+month.monthAll);
        monthTest.addView(view);

    }





}
