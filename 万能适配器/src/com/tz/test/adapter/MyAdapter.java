package com.tz.test.adapter;

import java.util.List;

import com.tz.test.R;
import com.tz.test.bean.Bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	private List<Bean> mList;
	private Context mContext;

	public MyAdapter(List<Bean> list,Context context) {
		this.mList = list;
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Bean getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lv_main, parent, false);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvDesc= (TextView) convertView.findViewById(R.id.tvDesc);
			holder.tvScore= (TextView) convertView.findViewById(R.id.tvScore);
			holder.tvContent= (TextView) convertView.findViewById(R.id.tvContent);
			convertView.setTag(holder);
		}else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		Bean bean  = getItem(position);
		holder.tvTitle.setText(bean.getTitle()); 
		holder.tvContent.setText(bean.getContent()); 
		holder.tvDesc.setText(bean.getDesc()); 
		holder.tvScore.setText(bean.getScore()); 
		
		return convertView;
	}
	
	private class ViewHolder
	{
		TextView tvTitle;
		TextView tvContent;
		TextView tvDesc;
		TextView tvScore;
		
	}

}
