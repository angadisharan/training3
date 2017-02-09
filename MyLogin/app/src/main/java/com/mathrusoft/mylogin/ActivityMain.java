package com.mathrusoft.mylogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sharanangadi on 09/02/17.
 */

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "MYAPP:ActivityMain";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "inside onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "inside onStart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside onDestroy");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside onResume");
    }
}
