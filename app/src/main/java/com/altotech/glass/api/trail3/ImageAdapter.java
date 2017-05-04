package com.altotech.glass.api.trail3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by yixua on 3/05/2017.
 */

public class ImageAdapter extends BaseAdapter{
    LayoutInflater layoutInflater;
    ArrayList<Integer> list;

    public ImageAdapter(Context context, ArrayList<Integer> list){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.card_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        imageView.setImageResource(list.get(i));
        return view;
    }
}
