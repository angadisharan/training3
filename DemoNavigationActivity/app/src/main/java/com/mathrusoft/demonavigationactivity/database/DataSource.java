package com.mathrusoft.demonavigationactivity.database;

import android.content.Context;

import com.mathrusoft.demonavigationactivity.model.ModelStudent;

import java.util.List;

/**
 * Created by sharanangadi on 27/02/17.
 */

public class DataSource {

    MyDatabaseHelper myDatabaseHelper;

    public DataSource(Context context) {
        myDatabaseHelper = MyDatabaseHelper.getInstance(context);
    }

    public long saveStudent(ModelStudent modelStudent) {
        return myDatabaseHelper.saveStudent(modelStudent);
    }

    public List<ModelStudent> getAllStudents() {
        return myDatabaseHelper.getAllStudents();
    }
}
