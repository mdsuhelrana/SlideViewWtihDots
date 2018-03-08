package com.example.mdsuhelrana.slidepagewithdots2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Md Suhel Rana on 2/18/2018.
 */

public class SlidepagerAdapter extends PagerAdapter {
    private Context context;

    public SlidepagerAdapter(Context context) {
        this.context = context;
    }

    private int layout[]={R.layout.slide_1,R.layout.slide_2,R.layout.slide_3,R.layout.slide_4};
    @Override
    public int getCount() {
        return layout.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(layout[position],container,false);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout)object);
    }
}
