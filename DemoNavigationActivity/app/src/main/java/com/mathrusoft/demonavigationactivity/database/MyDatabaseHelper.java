package com.mathrusoft.demonavigationactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mathrusoft.demonavigationactivity.model.ModelStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 27/02/17.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "MY_DB";

    private static MyDatabaseHelper instance;

    public static MyDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MyDatabaseHelper(context);
        }
        return instance;
    }

    private MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    private static final String CREATE_STUDENT = " create table student ( _id INTEGER primary key autoincrement ," +
            "name text , branch text , usn text ); ";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("MYAPP", "inside onCreate ");
        sqLiteDatabase.execSQL(CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS student ");

        Log.d("MYAPP", "inside DB UPDATE");

        onCreate(sqLiteDatabase);
    }


    public long saveStudent(ModelStudent modelStudent) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", modelStudent.getName());
        contentValues.put("branch", modelStudent.getBranch());
        contentValues.put("usn", modelStudent.getUsn());

        long id = database.insert("student", null, contentValues);

        database.close();

        return id;
    }

    public List<ModelStudent> getAllStudents() {
        List<ModelStudent> modelStudentList = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();

        String sql = " select * from student; ";

        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    ModelStudent modelStudent = new ModelStudent();
                    modelStudent.setName(cursor.getString(cursor.getColumnIndex("name")));
                    modelStudent.setBranch(cursor.getString(cursor.getColumnIndex("branch")));
                    modelStudent.setUsn(cursor.getString(cursor.getColumnIndex("usn")));

                    modelStudentList.add(modelStudent);
                }
            }
            cursor.close();
        }


        database.close();

        return modelStudentList;
    }


}
