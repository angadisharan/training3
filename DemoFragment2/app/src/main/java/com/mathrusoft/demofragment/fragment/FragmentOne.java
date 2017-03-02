package com.mathrusoft.demofragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mathrusoft.demofragment.R;

/**
 * Created by sharanangadi on 02/03/17.
 */

public class FragmentOne extends Fragment {

    TextView mTextView;

    EditText mEditText;
    EditText mEditTextBranch;
    Button mButton;

    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        mTextView = (TextView) view.findViewById(R.id.fragment_text);
        mEditText = (EditText) view.findViewById(R.id.name);
        mEditTextBranch = (EditText) view.findViewById(R.id.branch);
        mButton = (Button) view.findViewById(R.id.submit);
        mButton.setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = mEditText.getText().toString();
            if (TextUtils.isEmpty(name)) {
                mEditText.setError("Please enter name");
                return;
            }
            String branch = mEditTextBranch.getText().toString();
            if (TextUtils.isEmpty(branch)){
                mEditTextBranch.setError("Please enter branch");
                return;
            }

            String message = "Welcome " + name;
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    };
}
