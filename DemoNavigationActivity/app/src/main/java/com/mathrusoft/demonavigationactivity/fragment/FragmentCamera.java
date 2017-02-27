package com.mathrusoft.demonavigationactivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.demonavigationactivity.R;
import com.mathrusoft.demonavigationactivity.database.DataSource;
import com.mathrusoft.demonavigationactivity.model.ModelStudent;

/**
 * Created by sharanangadi on 15/02/17.
 */

public class FragmentCamera extends Fragment {
    EditText mEditTextName;
    EditText mEditTextBranch;
    EditText mEditTextUSN;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews(getView());
    }

    private void initViews(View view) {
        mEditTextName = (EditText) view.findViewById(R.id.name);
        mEditTextBranch = (EditText) view.findViewById(R.id.branch);
        mEditTextUSN = (EditText) view.findViewById(R.id.usn);

        view.findViewById(R.id.submit).setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModelStudent modelStudent = new ModelStudent();
            modelStudent.setName(mEditTextName.getText().toString());
            modelStudent.setBranch(mEditTextBranch.getText().toString());
            modelStudent.setUsn(mEditTextUSN.getText().toString());




            DataSource dataSource = new DataSource(getActivity().getApplicationContext());
            long id = dataSource.saveStudent(modelStudent);

            mEditTextName.setText("");
            mEditTextBranch.setText("");
            mEditTextUSN.setText("");

            Toast.makeText(getActivity(), "Object saved id " + id, Toast.LENGTH_SHORT).show();
        }
    };
}
