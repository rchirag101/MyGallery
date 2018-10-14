package com.example.chirag.mygallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
/**
 * Created by chirag on 13-10-2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    // Constructor
    public ImageAdapter(Context c) {     mContext = c;
    }
    public int getCount() {
        return mThumbIds.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10,10,10,10);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.mipmap.c1,R.mipmap.c2,R.mipmap.c3,
            R.mipmap.c4,R.mipmap.c5,R.mipmap.c6,
            R.mipmap.c7,R.mipmap.c8,R.mipmap.c9
    };
}
