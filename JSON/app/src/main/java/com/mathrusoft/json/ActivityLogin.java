package com.mathrusoft.json;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharanangadi on 04/04/17.
 */

public class ActivityLogin extends AppCompatActivity {


    Context mContext;

    TextView mTextView;
    EditText mEditTextUserName;
    EditText mEditTextPassword;
    Button mButtonSubmit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this.getApplicationContext();

        mTextView = (TextView) findViewById(R.id.text_status);

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextPassword = (EditText) findViewById(R.id.password);

        mButtonSubmit = (Button) findViewById(R.id.button_submit);
        mButtonSubmit.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user_name = mEditTextUserName.getText().toString();
            String password = mEditTextPassword.getText().toString();

            if (TextUtils.isEmpty(user_name)) {
                mEditTextUserName.setError("User name is empty");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                mEditTextPassword.setError("Password is empty");
                return;
            }

//            Toast.makeText(ActivityLogin.this, password + " " + user_name, Toast.LENGTH_SHORT).show();

            makeNetwordCall(user_name, password);


        }
    };

    private void makeNetwordCall(final String user_name, final String password) {

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://www.eduwati.com/test/jjjjjlogin";

        showProgress(true);

        Response.Listener succesListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);
                Toast.makeText(mContext, response, Toast.LENGTH_LONG).show();

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                showProgress(false);

                Log.e("MYAPP", "Volley error", error);
                error.printStackTrace();

                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, succesListener, errorListener) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");

                return headers;
            }

            @Override
            public byte[] getBody() {

                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("user_name", user_name);
                    jsonObject.put("password", password);


                    Log.d("MYAPP", "sending body " + jsonObject.toString());

                    String stringBody = jsonObject.toString();

                    return stringBody.getBytes();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                return null;
            }
        };


        queue.add(stringRequest);

    }



    Dialog dialog;
    private void showProgress(boolean show) {
        if (dialog == null){
            dialog = new ProgressDialog(this);
            dialog.setTitle("Please wait...");
        }

        if (show){
            dialog.show();
        } else  {
            dialog.dismiss();
        }

    }


}
