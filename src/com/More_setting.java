package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fzu.android.fdkdzs.R;
public class More_setting extends Fragment implements OnClickListener{
	TextView about;
	TextView update_software;
	private Update_Express Update_Express;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		return inflater.inflate(R.layout.more, null);		
	}	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		about = (TextView)  getView().findViewById(R.id.about);
		update_software = (TextView)  getView().findViewById(R.id.update);
		about.setOnClickListener(this);
		update_software.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.update:
			Toast.makeText(getActivity(), "亲，已经是最新版本了哦",Toast.LENGTH_SHORT).show();
			//Update_Express = new Update_Express(getActivity());
			//Update_Express.checkUpdateInfo();  
			break;
		case R.id.about:
			Intent intent = new Intent(getActivity(), AboutMe.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}