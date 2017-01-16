package com.ab.yuri.coolconstellation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Constellation> constellationList=new ArrayList<>();
    private ConstellationAdapter constellationAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);



        initConstellation();
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        constellationAdapter=new ConstellationAdapter(constellationList);
        recyclerView.setAdapter(constellationAdapter);

    }

    private void initConstellation(){
        Constellation baiyang=new Constellation("白羊座",R.drawable.ic_baiyang);
        constellationList.add(baiyang);
        Constellation jinniu=new Constellation("金牛座",R.drawable.ic_jinniu);
        constellationList.add(jinniu);
        Constellation shuangzi=new Constellation("双子座",R.drawable.ic_shuangzi);
        constellationList.add(shuangzi);
        Constellation juxie=new Constellation("巨蟹座",R.drawable.ic_juxie);
        constellationList.add(juxie);
        Constellation shizi=new Constellation("狮子座",R.drawable.ic_shizi);
        constellationList.add(shizi);
        Constellation chunv=new Constellation("处女座",R.drawable.ic_chunv);
        constellationList.add(chunv);
        Constellation tianchen=new Constellation("天秤座",R.drawable.ic_tianchen);
        constellationList.add(tianchen);
        Constellation tianxie=new Constellation("天蝎座",R.drawable.ic_tianxie);
        constellationList.add(tianxie);
        Constellation sheshou=new Constellation("射手座",R.drawable.ic_sheshou);
        constellationList.add(sheshou);
        Constellation mojie=new Constellation("摩羯座",R.drawable.ic_mojie);
        constellationList.add(mojie);
        Constellation shuiping=new Constellation("水瓶座",R.drawable.ic_shuiping);
        constellationList.add(shuiping);
        Constellation shuangyu=new Constellation("双鱼座",R.drawable.ic_shuangyu);
        constellationList.add(shuangyu);
    }
}
