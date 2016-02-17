package com.tz.test.adapter;

import java.util.List;

import com.tz.test.R;
import com.tz.test.bean.Bean;
import com.tz.test.holder.MyViewHolder;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapterWithCommonAdapter extends Commadapter<Bean> {

	public MyAdapterWithCommonAdapter(List<Bean> list, Context context,int layoutId) {
		super(list, context,layoutId);
	}

	@Override
	public void convert(MyViewHolder holder, Bean bean) {
		holder.setText(R.id.tvTitle, bean.getTitle())
				.setText(R.id.tvContent, bean.getContent())
				.setText(R.id.tvDesc, bean.getDesc())
				.setText(R.id.tvScore, bean.getScore());
		final TextView tv = holder.getView(R.id.tvTitle);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, tv.getText(), 3).show();
			}
		});
	}

}
