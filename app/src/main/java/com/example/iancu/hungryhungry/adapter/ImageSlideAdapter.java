package com.example.iancu.hungryhungry.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.iancu.hungryhungry.CustomImageView;
import com.example.iancu.hungryhungry.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Iancu on 07/11/2016.
 */

public class ImageSlideAdapter extends RecyclerView.Adapter<ImageSlideAdapter.ViewHolder> {
    Context ctxt;
    List<String> images;
    int rowLayout;
    public ImageSlideAdapter(List<String> images,int rowLayout,Context ctxt){
        this.ctxt =ctxt;
        this.images =images;
        this.rowLayout = rowLayout;

    }
    @Override
    public ImageSlideAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_pane,parent,false);
        return new ImageSlideAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageSlideAdapter.ViewHolder holder, int position) {
        Glide.with(ctxt).load(images.get(position)).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image_description);
            itemView.setTag(itemView);
        }
    }
}
