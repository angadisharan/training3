package com.mathrusoft.demonavigationactivity.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mathrusoft.demonavigationactivity.R;
import com.mathrusoft.demonavigationactivity.adapter.AdapterStudentList;
import com.mathrusoft.demonavigationactivity.database.DataSource;
import com.mathrusoft.demonavigationactivity.model.ModelStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 28/02/17.
 */

public class FragmentStudentList extends Fragment {

    ListView mListViewStudent;

    AdapterStudentList mAdapterStudentList;
    List<ModelStudent> mModelStudentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_list, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());

    }

    private void initViews(View view) {
        mListViewStudent = (ListView) view.findViewById(R.id.student_list);
        mAdapterStudentList = new AdapterStudentList(getActivity(), R.layout.item_student_list, mModelStudentList);

        mListViewStudent.setAdapter(mAdapterStudentList);

        new AsyncGetDataFromDB().execute();
    }


    ProgressDialog progressDialog;

    class AsyncGetDataFromDB extends AsyncTask<Void, Void, List<ModelStudent>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
        }

        @Override
        protected List<ModelStudent> doInBackground(Void... voids) {
            DataSource dataSource = new DataSource(getActivity().getApplicationContext());
            List<ModelStudent> modeStudentList = dataSource.getAllStudents();

            return modeStudentList;
        }



        @Override
        protected void onPostExecute(List<ModelStudent> studentList) {
            super.onPostExecute(studentList);

            mModelStudentList.clear();
            mModelStudentList.addAll(studentList);
            mAdapterStudentList.notifyDataSetChanged();

            progressDialog.dismiss();
        }
    }

}
