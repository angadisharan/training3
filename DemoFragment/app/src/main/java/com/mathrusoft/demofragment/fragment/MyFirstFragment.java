package com.mathrusoft.demofragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mathrusoft.demofragment.R;

/**
 * Created by sharanangadi on 14/02/17.
 */

public class MyFirstFragment extends Fragment {

    private static final String TAG = "MYAPP:MyFirstFragment";

    Button mButtonGreet;


    Context mContext;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        mButtonGreet = (Button) view.findViewById(R.id.button_greet);
        mButtonGreet.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "Welcome from fragment", Toast.LENGTH_SHORT).show();
        }
    };

}
