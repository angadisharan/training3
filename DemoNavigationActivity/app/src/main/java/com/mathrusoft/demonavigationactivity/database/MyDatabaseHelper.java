package com.mathrusoft.demonavigationactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mathrusoft.demonavigationactivity.model.ModelStudent;

/**
 * Created by sharanangadi on 27/02/17.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
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
        sqLiteDatabase.execSQL(CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS student ");

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
}
