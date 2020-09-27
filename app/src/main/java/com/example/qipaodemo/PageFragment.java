package com.example.qipaodemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Author: SherlockShi
 * Date:   2016-11-01 16:31
 * Description:
 */

public class PageFragment extends Fragment {

    private static final String PAGE_NAME_KEY = "PAGE_NAME_KEY";

    public static PageFragment getInstance(String pageName) {
        Bundle args = new Bundle();
        args.putString(PAGE_NAME_KEY, pageName);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);

        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_page_name);
        textView.setText(getArguments().getString(PAGE_NAME_KEY));

        return view;
    }
}
