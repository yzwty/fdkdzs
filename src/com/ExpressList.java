package com;

import com.adapter.ListViewAdapter;

import com.fzu.android.fdkdzs.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ExpressList  extends Activity{
	private ListView lv_common;
	 public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.fragment_all); 
	        final String[] all_name = getResources().getStringArray(R.array.common);
			final String[] all_code = getResources().getStringArray(R.array.common_code);
			lv_common = (ListView)findViewById(R.id.lv_all);
			lv_common.setAdapter(new ListViewAdapter(this, all_name));
			lv_common.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent data = new Intent();
					data.putExtra("code", all_code[position]);
					data.putExtra("name", all_name[position]);
					setResult(0, data);
					finish();
				}
				
			});
	        
	 }

}
