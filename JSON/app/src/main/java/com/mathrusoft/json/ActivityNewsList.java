package com.mathrusoft.json;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharanangadi on 10/04/17.
 */

public class ActivityNewsList extends AppCompatActivity {


    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mContext = this.getApplication();

        fetchNewsFromServer();
    }

    private void fetchNewsFromServer() {

        String url = "http://api.mathrusoft.com:81/news";

        RequestQueue queue = Volley.newRequestQueue(this);

        showProgress(true);

        Response.Listener succesListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                showNewsList(response);

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
                headers.put("user_id", "494");
                headers.put("token", "ouiEUUeOH9");

                return headers;
            }

            @Override
            public byte[] getBody() {

                try {
                    JSONObject jsonObject = new JSONObject();
                    JSONObject news = new JSONObject();
                    news.put("_id", "96349");

                    jsonObject.put("news", news);

                    return jsonObject.toString().getBytes();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                return null;
            }
        };


        queue.add(stringRequest);


    }

    private void showNewsList(String response) {

        try {
            JSONArray jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject newsJson = jsonArray.getJSONObject(i);

                Log.d("MYAPP", newsJson.toString());
            }


        } catch (JSONException e) {
            Log.d("MYAPP", "JSON EXCEPTION ", e);
        }


    }

    Dialog dialog;

    private void showProgress(boolean show) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setTitle("Please wait...");
        }

        if (show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }

    }
}
