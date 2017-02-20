package com.mathrusoft.demopref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sharanangadi on 20/02/17.
 */

public class ActivitySharedPref extends AppCompatActivity {

    EditText mEditTextName;
    Button mButtonSaveToPref;
    Button mButtonUpdateFromPref;

    TextView mTextViewName;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shared_pref);

        mContext = this.getApplicationContext();

        mEditTextName = (EditText) findViewById(R.id.name);
        mButtonSaveToPref = (Button) findViewById(R.id.save_to_pref);


        mTextViewName = (TextView) findViewById(R.id.name_from_pref);
        mButtonUpdateFromPref = (Button) findViewById(R.id.get_value_from_pref);


        mButtonSaveToPref.setOnClickListener(mOnClickListener);
        mButtonUpdateFromPref.setOnClickListener(mOnClickListenerUpdate);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = mEditTextName.getText().toString();

            SharedPreferences preferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("name", name);

            editor.commit();

            Toast.makeText(mContext, " Name " + name, Toast.LENGTH_SHORT).show();
        }
    };


    View.OnClickListener mOnClickListenerUpdate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences preferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
            String name = preferences.getString("name", "NO VALUE");

            mTextViewName.setText(name);

        }
    };

}
