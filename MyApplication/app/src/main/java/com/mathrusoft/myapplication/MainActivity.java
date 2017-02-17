package com.mathrusoft.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButtonGreeting;

    Context mContext;


    RadioGroup mRadioGroup;


    CheckBox mCheckBoxJava;
    CheckBox mCheckBoxAndroid;
    CheckBox mCheckBoxNodejs;
    CheckBox mCheckBoxMysql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplication();

        mRadioGroup = (RadioGroup) findViewById(R.id.select_gender);
        mRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);

        mButtonGreeting = (Button) findViewById(R.id.button_greeting);
        mButtonGreeting.setOnClickListener(mOnClickListener);


        mCheckBoxJava = (CheckBox) findViewById(R.id.java);
        mCheckBoxAndroid = (CheckBox) findViewById(R.id.android);
        mCheckBoxNodejs = (CheckBox) findViewById(R.id.nodejs);
        mCheckBoxMysql = (CheckBox) findViewById(R.id.mysql);

        mCheckBoxJava.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        mCheckBoxAndroid.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        mCheckBoxNodejs.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        mCheckBoxMysql.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "Greeting", Toast.LENGTH_SHORT).show();
        }
    };

    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            switch (id) {
                case R.id.male:
                    Toast.makeText(mContext, "Male selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.female:
                    Toast.makeText(mContext, "Female selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener mOnCheckboxCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.java:
                    Toast.makeText(mContext, "Java Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.android:
                    Toast.makeText(mContext, "Android Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nodejs:
                    Toast.makeText(mContext, "Nodejs Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mysql:
                    Toast.makeText(mContext, "Mysql Checked", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
