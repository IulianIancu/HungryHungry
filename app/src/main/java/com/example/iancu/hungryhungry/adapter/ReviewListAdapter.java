package com.example.iancu.hungryhungry.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.model.Review;
import com.example.iancu.hungryhungry.model.ReviewSearch;
import com.example.iancu.hungryhungry.model.UserReview;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Iancu on 08/11/2016.
 */

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {
    ReviewSearch reviewSearch;
    Context context;

    public ReviewListAdapter(ReviewSearch reviewSearch,Context context){
        this.reviewSearch=reviewSearch;
        this.context =context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.recycler_review_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Review userReview =reviewSearch.getUserReviews().get(position).getReview();
        holder.name.setText(userReview.getUser().getName());
        holder.review.setText(userReview.getReviewText());
        holder.score.setText(""+userReview.getRating());
        holder.time.setText(userReview.getReviewTimeFriendly());
        Glide.with(context).load(userReview.getUser().getProfileImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return reviewSearch.getReviewsShown();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.reviewer_image)
        ImageView image;
        @BindView(R.id.reviewer_name)
        TextView name;
        @BindView(R.id.review)
        TextView review;
        @BindView(R.id.review_time)
        TextView time;
        @BindView(R.id.review_score)
        TextView score;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(itemView);
        }
    }
}
