package com.mathrusoft.mylogin;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sharanangadi on 10/02/17.
 */

public class ActivityShowDialog extends AppCompatActivity {

    Button mButtonShowDialog;
    Button mButtonShowProgressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_dialog);

        mButtonShowDialog = (Button) findViewById(R.id.show_dialog);
        mButtonShowDialog.setOnClickListener(mOnClickListener);

        mButtonShowProgressDialog = (Button) findViewById(R.id.show_progress_dialog);
        mButtonShowProgressDialog.setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.show_dialog:
                    showDialog();
                    break;
                case R.id.show_progress_dialog:
                    showProgressDialog();
                    break;
            }

        }
    };

    private void showProgressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(ActivityShowDialog.this);
        progressDialog.setMessage("Please wait...");

        progressDialog.setCancelable(false);
        progressDialog.show();
//        TO RESTRICT USER FROM CANCELING ON CLICKING OUTSIDE
//        progressDialog.dismiss();
    }


    private void showDialog() {

//        Dialog dialog = new Dialog(ActivityShowDialog.this);
//        dialog.setTitle("Title");
//        dialog.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityShowDialog.this)
                .setTitle("Hello Title")
                .setMessage("Dialog Message here")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivityShowDialog.this, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivityShowDialog.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = builder.create();

//        TO RESTRICT USER FROM CANCELING ON CLICKING OUTSIDE
//        alertDialog.setCancelable(false);

        alertDialog.show();

    }

}
