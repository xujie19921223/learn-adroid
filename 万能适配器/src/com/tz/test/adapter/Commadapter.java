package com.tz.test.adapter;

import java.util.List;

import com.tz.test.R;
import com.tz.test.bean.Bean;
import com.tz.test.holder.MyViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class Commadapter<T> extends BaseAdapter {
    
	protected List<T> mList;
	protected   Context mContext;
	protected  LayoutInflater inflater;
	private int mLayoutId;

	public Commadapter(List<T> list,Context context,int layoutId) {
		this.mList = list;
		this.mContext = context;
		this.mLayoutId = layoutId;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public  View getView(int position, View convertView, ViewGroup parent) 
	{
		MyViewHolder holder = MyViewHolder.get(mContext, position, mLayoutId, parent, convertView);
		convert(holder,mList.get(position));
		return holder.getConvertView();
	}
	
	public abstract void convert(MyViewHolder holder,T t);
	

}
