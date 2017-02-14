package com.mathrusoft.demofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sharanangadi on 14/02/17.
 */

public class ActivityDemoInclude extends AppCompatActivity {

    Button mButtonOK;
    Button mCancel;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_include);

        mContext = this.getApplicationContext();

        mButtonOK = (Button) findViewById(R.id.button_ok);
        mCancel = (Button) findViewById(R.id.button_cancel);

        mButtonOK.setOnClickListener(mOnClickListener);
        mCancel.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_ok:
                    Toast.makeText(mContext, "OK Click", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_cancel:
                    Toast.makeText(mContext, "Cancel Click", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}



