package com.mathrusoft.demorecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.mathrusoft.demorecyclerview.CustomVolleyRequestQueue;
import com.mathrusoft.demorecyclerview.R;
import com.mathrusoft.demorecyclerview.model.News;

import java.util.List;

/**
 * Created by sharanangadi on 25/04/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    List<News> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public NetworkImageView mImageView;
        public TextView mTextTitle;
        public TextView mTextDesc;

        public ViewHolder(View v) {
            super(v);
            mTextTitle = (TextView) v.findViewById(R.id.text_name);
            mTextDesc = (TextView) v.findViewById(R.id.text_description);
            mImageView = (NetworkImageView) v.findViewById(R.id.image_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(List<News> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        News news = mDataset.get(position);

        CustomVolleyRequestQueue customVolleyRequestQueue = new CustomVolleyRequestQueue(holder.mImageView.getContext());

        holder.mImageView.setImageUrl(news.getImage(), customVolleyRequestQueue.getImageLoader());
        holder.mImageView.setErrorImageResId(R.drawable.loading);
        holder.mImageView.setDefaultImageResId(R.drawable.loading);
        holder.mTextDesc.setText(news.getDescription());
        holder.mTextTitle.setText(news.getTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
