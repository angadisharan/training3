package com.mathrusoft.demonavigationactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mathrusoft.demonavigationactivity.adapter.AdapterStudentList;
import com.mathrusoft.demonavigationactivity.model.ModelStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 16/02/17.
 */

public class AndroidDemoCustomAdapter extends AppCompatActivity {

    ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_list);
        mListView = (ListView) findViewById(R.id.list_view);

        createDummyStudents();
    }

    private void createDummyStudents() {
        List<ModelStudent> studentList = new ArrayList<>();


        for (int i = 0; i < 25; i++) {
            ModelStudent modelStudent = new ModelStudent();
            modelStudent.setName("Name " + i);
            modelStudent.setBranch("Branch " + i);
            modelStudent.setUsn("USN-" + i);

            studentList.add(modelStudent);
        }

        AdapterStudentList adapterStudentList = new AdapterStudentList(this, R.layout.item_student_list, studentList);

        mListView.setAdapter(adapterStudentList);
    }
}
