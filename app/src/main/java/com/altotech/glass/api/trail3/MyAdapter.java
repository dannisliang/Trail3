package com.altotech.glass.api.trail3;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	LayoutInflater mInflater;
	ArrayList<String> mList;
	public MyAdapter(Context context, ArrayList<String> list) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Log.e("sn", "pos=" + arg0 + " convertview=" + arg1 + " childcount="
				+ arg2.getChildCount());
		if (arg1 == null) {
			arg1 = mInflater.inflate(R.layout.card_item, null);
		}
		TextView tv = (TextView) arg1.findViewById(R.id.tv);
		tv.setText(mList.get(arg0));
		return arg1;
	}
}
