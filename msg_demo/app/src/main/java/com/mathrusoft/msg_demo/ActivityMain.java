package com.mathrusoft.msg_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityMain extends AppCompatActivity {

    Button mButtonSendSMS;

    EditText mEditTextMobile;
    EditText mEditTextMessage;


    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        mEditTextMobile = (EditText) findViewById(R.id.mobile_number);
        mEditTextMessage = (EditText) findViewById(R.id.message);



        mButtonSendSMS = (Button) findViewById(R.id.button_send_sms);
        mButtonSendSMS.setOnClickListener(mOnClickListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String mobile = mEditTextMobile.getText().toString();
            mobile = mobile.replaceAll(" ", "");
            if (mobile.length() != 10) {
                mEditTextMobile.setError("Invalid Mobile Number");
                return;
            }
            String message = mEditTextMessage.getText().toString();
            if (message.length() <= 5) {
                mEditTextMessage.setError("Invalid message");
                return;
            }
            triggerAPI();
        }
    };

    private void triggerAPI() {
        String url = "http://sms.mathrusoft.com:4001/mobile_api/sms/send";


        Response.Listener<String> successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mEditTextMobile.setText("");
                mEditTextMessage.setText("");

                Toast.makeText(mContext, "Message sent success", Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "Please try again", Toast.LENGTH_SHORT).show();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, successListener, errorListener) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("user_id", "33");
                headers.put("token", "qweqweqw");
                headers.put("mauserid", "33");
                headers.put("matoken", "qweqwe");

                return headers;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject body = new JSONObject();

                try {
                    JSONObject sms = new JSONObject();
//                    sms.put("mobile", "8277483505");
//                    sms.put("message", "Welcome to Mathrusoft Technologies demo second message");
//                    sms.put("route", "TRANSACTIONAL");

                    sms.put("mobile", mEditTextMobile.getText().toString());
                    sms.put("message", mEditTextMessage.getText().toString());
                    sms.put("route", "TRANSACTIONAL");


                    body.put("sms", sms);
                } catch (JSONException e) {
                    Log.d("MYAPP", "Exception ", e);
                }
                return body.toString().getBytes();
            }
        };

//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(stringRequest);


        Volley.newRequestQueue(this).add(stringRequest);

//        {
//            "sms": {
//            "mobile": "8277483505",
//                    "message": "Welcome to Mathrusoft Technologies demo message",
//                    "route":"TRANSACTIONAL"
//        }
//        }


    }


}
