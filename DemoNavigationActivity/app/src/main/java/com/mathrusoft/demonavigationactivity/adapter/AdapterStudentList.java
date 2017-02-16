package com.mathrusoft.demonavigationactivity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.demonavigationactivity.R;
import com.mathrusoft.demonavigationactivity.model.ModelStudent;

import java.util.List;

/**
 * Created by sharanangadi on 16/02/17.
 */

public class AdapterStudentList extends ArrayAdapter<ModelStudent> {

    List<ModelStudent> modelStudentList;

    Context mContext;

    int layout;

    public AdapterStudentList(Context context, int resource, List<ModelStudent> objects) {
        super(context, resource, objects);

        layout = resource;
        mContext = context;
        modelStudentList = objects;
    }

    @Override
    public int getCount() {
        return modelStudentList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }

        TextView studentName = (TextView) convertView.findViewById(R.id.student_name);
        TextView studentUSN = (TextView) convertView.findViewById(R.id.student_usn);
        TextView studentBranch = (TextView) convertView.findViewById(R.id.student_branch);

        ModelStudent student = modelStudentList.get(position);

        studentName.setText(student.getName());
        studentUSN.setText(student.getUsn());
        studentBranch.setText(student.getBranch());

        return convertView;
    }
}

