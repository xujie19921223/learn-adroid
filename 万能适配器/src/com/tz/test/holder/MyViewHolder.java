package com.tz.test.holder;

import com.tz.test.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder {
	
	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	
	private MyViewHolder( Context  context,int position, int layoutId, ViewGroup parent) {
		mViews = new SparseArray<View>();
		this.mConvertView = LayoutInflater.from(context).inflate(R.layout.item_lv_main, parent, false);
		this.mPosition = position;
		this.mConvertView.setTag(this);
	}
	
	
    public static MyViewHolder get(Context  context,int position, int layoutId, ViewGroup parent,View convertView)
    {
    	if (null ==convertView) {
    		return new MyViewHolder(context, position, layoutId, parent);
			
		}else
		{
		 MyViewHolder holder = (MyViewHolder) convertView.getTag();
		 holder.mPosition = position;
		 return holder;
		}
    }
	public View getConvertView() {
		return mConvertView;
	}
    /**
     * 通过viewId获取控件
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId){
    	View view = mViews.get(viewId);
    	if (null==view) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
    	return (T) view;
    }
    public MyViewHolder setText(int viewId,String text)
    {
    	TextView tv = getView(viewId);
    	tv.setText(text);
    	return this;
    }
    public MyViewHolder setImageResource(int viewId,int resId)
    {
    	ImageView view = getView(viewId);
    	view.setImageResource(resId);
    	return this;
    }
    public MyViewHolder setImageBitmap(int viewId,Bitmap bitmap)
    {
    	ImageView view = getView(viewId);
    	view.setImageBitmap(bitmap);
    	return this;
    }
    public MyViewHolder setImageURI(int viewId,String url)
    {
    	ImageView view = getView(viewId);
//    	ImageLoader.getInstance().load(view，url);
    	return this;
    }
}
