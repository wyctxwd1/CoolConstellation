package com.ab.yuri.coolconstellation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Yuri on 2017/1/16.
 */

public class ConstellationAdapter extends RecyclerView.Adapter<ConstellationAdapter.ViewHolder> {
    private Context mContext;
    private List<Constellation> mConstellationList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View constellationView;
        ImageView constellationImg;
        TextView constellationName;

        public ViewHolder(View view) {
            super(view);
            constellationView=view;
            constellationImg= (ImageView) view.findViewById(R.id.constellation_img);
            constellationName= (TextView) view.findViewById(R.id.constellation_name);
        }
    }

    public ConstellationAdapter(List<Constellation> constellationList){
        mConstellationList=constellationList;
    }

    @Override
    public ConstellationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.choose_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.constellationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Constellation constellation=mConstellationList.get(position);
                Intent intent=new Intent(mContext,ConstellationActivity.class);
                intent.putExtra(ConstellationActivity.CONSTELLATION_NAME,constellation.getConstellationName());
                intent.putExtra(ConstellationActivity.CONSTELLATION_IMG_VIEW,constellation.getConstellationImgView());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ConstellationAdapter.ViewHolder holder, int position) {
        Constellation constellation=mConstellationList.get(position);
        holder.constellationName.setText(constellation.getConstellationName());
        Glide.with(mContext).load(constellation.getConstellationImg()).into(holder.constellationImg);


    }

    @Override
    public int getItemCount() {
        return mConstellationList.size();
    }
}