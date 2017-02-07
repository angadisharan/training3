package com.mathrusoft.mytestapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mathrusoft.mytestapp.R;

/**
 * Created by sharanangadi on 07/02/17.
 */

public class ActivityDemoWidget extends AppCompatActivity {


    CheckBox mCheckBoxAndroid;
    CheckBox mCheckBoxJava;
    CheckBox mCheckBoxNodejs;

    Context mContext;

    RadioGroup mRadioGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_widget);

        mContext = this.getApplicationContext();

        mCheckBoxAndroid = (CheckBox) findViewById(R.id.checkbox_android);
        mCheckBoxJava = (CheckBox) findViewById(R.id.checkbox_java);
        mCheckBoxNodejs = (CheckBox) findViewById(R.id.checkbox_nodejs);

        mCheckBoxJava.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCheckBoxJava.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCheckBoxNodejs.setOnCheckedChangeListener(mOnCheckedChangeListener);


        mRadioGroup = (RadioGroup) findViewById(R.id.gender);

        mRadioGroup.setOnCheckedChangeListener(mGenderChangeListner);

        Log.d("MYAPP", " mCheckBoxAndroid " + mCheckBoxAndroid);


    }


    CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.checkbox_android:
                    Toast.makeText(mContext, "Selected Android ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_java:
                    Toast.makeText(mContext, "Selected Java ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_nodejs:
                    Toast.makeText(mContext, "Selected Nodejs ", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };

    RadioGroup.OnCheckedChangeListener mGenderChangeListner = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            switch (id) {
                case R.id.gender_female:
                    Toast.makeText(mContext, "Selected Female ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gender_male:
                    Toast.makeText(mContext, "Selected Male ", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
