package com.tz.test;

import java.util.ArrayList;
import java.util.List;

import com.tz.test.adapter.MyAdapter;
import com.tz.test.adapter.MyAdapterWithCommonAdapter;
import com.tz.test.bean.Bean;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
public class MainActivity extends Activity {

	private List<Bean> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initView();
		
	}

	private void initDatas() {
    list = new ArrayList<Bean>();
	for (int i = 0; i < 6; i++) {
		Bean bean = new Bean();
		bean.setContent("content"+i);
		bean.setTitle("title"+i);
		bean.setDesc("desc"+i);
		bean.setScore("score"+i);
		list.add(bean);
	} 	
	}

	private void initView() {
		ListView lvMain = (ListView) findViewById(R.id.lv_main);
//		MyAdapter adapter = new MyAdapter(list, this);
		MyAdapterWithCommonAdapter adapter = new MyAdapterWithCommonAdapter(list, this,R.layout.item_lv_main);
		lvMain.setAdapter(adapter);
		
		
	}
}
