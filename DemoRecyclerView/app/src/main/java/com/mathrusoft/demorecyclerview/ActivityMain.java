package com.mathrusoft.demorecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mathrusoft.demorecyclerview.adapter.NewsAdapter;
import com.mathrusoft.demorecyclerview.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 25/04/17.
 */

public class ActivityMain extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<News> namesList = dummyData();

        mNewsAdapter = new NewsAdapter(namesList);
        mRecyclerView.setAdapter(mNewsAdapter);

    }

    private List<News> dummyData() {
        List<News> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            News news = new News();
            news.setTitle("Title " + i);
            news.setDescription("Description " + i);
            news.setImage("https://pbs.twimg.com/profile_images/718314968102367232/ypY1GPCQ.jpg");
            list.add(news);

        }
        return list;
    }
}
