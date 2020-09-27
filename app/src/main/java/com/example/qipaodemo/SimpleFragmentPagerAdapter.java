package com.example.qipaodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author: SherlockShi
 * Date:   2016-11-01 17:38
 * Description:
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> mFragmentList;
    private List<String> mPageTitleList;
    private List<Integer> mBadgeCountList;

    public SimpleFragmentPagerAdapter(Context context,
                                      FragmentManager fm,
                                      List<Fragment> fragmentList,
                                      List<String> pageTitleList,
                                      List<Integer> badgeCountList) {
        super(fm);
        this.mContext = context;
        this.mFragmentList = fragmentList;
        this.mPageTitleList = pageTitleList;
        this.mBadgeCountList = badgeCountList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPageTitleList.get(position);
    }

    public View getTabItemView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_layout_item, null);
        TextView textView =  view.findViewById(R.id.textview);
        ImageView imageView = view.findViewById(R.id.imageView);
        //文字
        textView.setText(mPageTitleList.get(position));
        //放图片
//        imageView.setImageBitmap();
        //角标
        TextView target = view.findViewById(R.id.badgeview_target);
        target.setText("100");
        return view;
    }

    public static String formatBadgeNumber(int value) {
        if (value <= 0) {
            return null;
        }

        if (value < 100) {
            // equivalent to String#valueOf(int);
            return Integer.toString(value);
        }

        // my own policy
        return "99+";
    }
}
