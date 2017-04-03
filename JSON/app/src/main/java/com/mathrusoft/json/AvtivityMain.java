package com.mathrusoft.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvtivityMain extends AppCompatActivity {


    TextView mTextViewOutPut;
    TextView mTextViewAcademicYear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtivity_main);

        mTextViewOutPut = (TextView) findViewById(R.id.text_view_output);
        mTextViewAcademicYear = (TextView) findViewById(R.id.text_view_academic_year);

        try {
            JSONObject jsonObject = new JSONObject(response);
            String student_name = jsonObject.getString("student_first_name");
            String student_lastname = jsonObject.getString("student_last_name");
            String father_name = "";

            JSONObject parent_details = jsonObject.getJSONObject("parent_details");
            if (parent_details != null) {
                father_name = parent_details.getString("father_name");
            }


            mTextViewOutPut.setText(student_name + " " + student_lastname + " " + father_name);

            JSONArray academic_array = jsonObject.getJSONArray("academic_class_history");
            String year = "";
            for (int i = 0; i < academic_array.length(); i++) {

                JSONObject academic = academic_array.getJSONObject(i);
                year += academic.getString("year");

                Log.d("MYAPP", "Inside loop " + year);

            }


            JSONObject myJson = new JSONObject();
            myJson.put("rank", 1);


            JSONObject tempJSON = new JSONObject();
            tempJSON.put("temp_key", "temp_value");

            myJson.put("temp", tempJSON);

            Log.d("MYAPP", "MyJSON " + myJson.toString());

            Toast.makeText(this, "MyJSON " + myJson.toString(), Toast.LENGTH_LONG).show();


            mTextViewAcademicYear.setText(year);

        } catch (JSONException e) {
            Log.e("MYAPP", "JSON Exception", e);
//            e.printStackTrace();
        }


    }


    String response = "{\n" +
            "  \"student_first_name\": \"Shruti\",\n" +
            "  \"student_last_name\": \"Patil\",\n" +
            "  \"interests\": [\n" +
            "    \"cricket\",\n" +
            "    \"reading\",\n" +
            "    \"programming\"\n" +
            "  ],\n" +
            "  \"academic_class_history\": [\n" +
            "    {\n" +
            "      \"year\": \"2016 - 2017\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"year\": \"2015 - 2016\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"year\": \"2014 - 2013\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"parent_details\": {\n" +
            "    \"father_name\": \"Ram\",\n" +
            "    \"mother_name\": \"Sita\"\n" +
            "  }\n" +
            "}";


}
