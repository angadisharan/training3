package com.mathrusoft.mylogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import util.Constant;

/**
 * Created by sharanangadi on 13/02/17.
 */

public class ActivityDemoStoredPref extends AppCompatActivity {

    EditText mEditTextName;
    TextView mTextViewPrefName;
    Button mButtonSubmit;
    Button mButtonUpdatePrefValue;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this.getApplicationContext();

        setContentView(R.layout.activity_demo_shared_pref);

        mEditTextName = (EditText) findViewById(R.id.edittext_name);
        mTextViewPrefName = (TextView) findViewById(R.id.name_from_pref);
        mButtonSubmit = (Button) findViewById(R.id.submit);
        mButtonUpdatePrefValue = (Button) findViewById(R.id.update_pref_value);

        mButtonSubmit.setOnClickListener(mOnClickListener);
        mButtonUpdatePrefValue.setOnClickListener(mOnClickListener);


//        init value from pref


    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.submit:
                    String name = mEditTextName.getText().toString();

                    SharedPreferences preferences = mContext.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString(Constant.KEY_NAME, name);
                    editor.commit();
                    break;
                case R.id.update_pref_value:
                    preferences = mContext.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE);
                    String prefString = preferences.getString(Constant.KEY_NAME, "No Pref value");
                    mTextViewPrefName.setText(prefString);
                    break;
            }
        }
    };
}
