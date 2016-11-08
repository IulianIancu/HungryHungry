package com.example.iancu.hungryhungry.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.fragment.RestaurantList;
import com.example.iancu.hungryhungry.model.NearbyRestaurant;
import com.example.iancu.hungryhungry.model.Restaurant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Iancu on 02/11/2016.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {
    private List<NearbyRestaurant> rests;
    private int rowLayout;
    private RestaurantList context;

    public RestaurantListAdapter(List<NearbyRestaurant> rests,int rowLayout,RestaurantList contxt){
        this.rests =rests;
        this.rowLayout=rowLayout;
        this.context=contxt;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rest_list_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NearbyRestaurant r1 =rests.get(position);
        final Restaurant r2 =r1.getRestaurant();
        holder.name.setText("Name : "+r2.getName());
        holder.price.setText("Price for two : "+r2.getAverageCostForTwo()+r2.getCurrency());
        holder.cuisines.setText("Cuisines : "+r2.getCuisines());
        Glide.with(context).load(r2.getThumb()).into(holder.img);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(context.getContext(),"BOOP "+ position +r2.getR().getResId(), Toast.LENGTH_SHORT).show();
                context.clikedRest(r2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return rests.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemClickListener listener;
        @BindView(R.id.rest_name)
        TextView name;
        @BindView(R.id.rest_cuisines)
        TextView cuisines;
        @BindView(R.id.rest_price)
        TextView price;
        @BindView(R.id.rest_image)
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }
        public void setClickListener(ItemClickListener clickListener){
            this.listener =clickListener;
        }

        @Override
        public void onClick(View v) {listener.onClick(v,getLayoutPosition());

        }
    }
}
