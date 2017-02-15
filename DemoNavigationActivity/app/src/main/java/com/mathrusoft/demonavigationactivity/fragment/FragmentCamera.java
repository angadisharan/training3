package com.mathrusoft.demonavigationactivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mathrusoft.demonavigationactivity.R;

/**
 * Created by sharanangadi on 15/02/17.
 */

public class FragmentCamera extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, null);
        return  view;
    }
}
