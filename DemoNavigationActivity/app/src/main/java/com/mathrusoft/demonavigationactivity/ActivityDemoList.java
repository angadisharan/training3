package com.mathrusoft.demonavigationactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sharanangadi on 16/02/17.
 */

public class ActivityDemoList extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_list);

        mListView = (ListView) findViewById(R.id.list_view);

        String stringArray[] = {
                "Java",
                "Android",
                "Nodejs",
                "Angular JS",
                "PHP",
                "J2EE",
                ".NET",
                "Ruby",
                "Mysql",
                "Java",
                "Android",
                "Nodejs",
                "Angular JS",
                "PHP",
                "J2EE",
                ".NET",
                "Ruby",
                "Mysql"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);

        mListView.setAdapter(arrayAdapter);

    }
}
