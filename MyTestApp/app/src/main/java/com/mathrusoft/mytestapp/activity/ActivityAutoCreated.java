package com.mathrusoft.mytestapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.mytestapp.R;

public class ActivityAutoCreated extends AppCompatActivity {

    Button mButtonGreeting;
    EditText mEditTextName;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_created);

//        ActivityAutoCreated.this.getApplicationContext()
        mContext = this.getApplicationContext();

        mButtonGreeting = (Button) findViewById(R.id.button_greeting);
        mButtonGreeting.setOnClickListener(mOnClickListener);

        mEditTextName = (EditText) findViewById(R.id.edittext_name);


    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            String name = mEditTextName.getText().toString();

            Toast.makeText(mContext, "Welcome to " + name, Toast.LENGTH_SHORT).show();
        }
    };



}
