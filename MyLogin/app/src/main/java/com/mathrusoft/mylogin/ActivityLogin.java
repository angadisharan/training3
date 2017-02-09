package com.mathrusoft.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLogin extends AppCompatActivity {

    private static final String TAG =  "MYAPP:ActivityLogin";

    Button mButtonLaunchActivityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mButtonLaunchActivityMain = (Button) findViewById(R.id.button_launch_main_activity);
        mButtonLaunchActivityMain.setOnClickListener(mOnClickListener);

        Log.d(TAG, "inside onCreate");
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Launching activity
            Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
            startActivity(intent);

        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "inside onStart");
        System.out.println("inside onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "inside onPause");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside onDestroy");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside onRestart");
    }
}
