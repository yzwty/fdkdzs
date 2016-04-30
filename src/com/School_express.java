package com;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.fzu.android.fdkdzs.R;
public class School_express extends Fragment implements OnClickListener{
	TextView tv_express_name;
	EditText tv_school_express_name;
	Button tv_school_express_search;
	private ProgressDialog progressDialog;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		return inflater.inflate(R.layout.school_express, null);		
	}	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tv_express_name = (TextView)  getView().findViewById(R.id.company_name);
		tv_express_name.setOnClickListener(this);
		tv_school_express_name = (EditText)  getView().findViewById(R.id.school_name);
		tv_school_express_search = (Button)  getView().findViewById(R.id.school_express_search);
		tv_school_express_search.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.company_name:
			Intent intent = new Intent(getActivity(), ExpressList.class);
			startActivityForResult(intent, 1);
			break;
		case R.id.school_express_search:
			String name = tv_express_name.getText().toString();
			if(name.equals("")){
				Toast.makeText(getActivity(), "请先选择快递", Toast.LENGTH_SHORT).show();
			}else{
				String number = tv_school_express_name.getText().toString();
				if(number.equals("")){
					Toast.makeText(getActivity(), "你还没输入学校", Toast.LENGTH_SHORT).show();
				}else{
					 if(number.equals("福州大学")){
					Bundle bundle = new Bundle();
					    bundle.putString("name", name);
					    bundle.putString("number", number);  
						Intent e = new Intent(getActivity(), SchoolExpressActivity.class);
					   e.putExtras(bundle);
					   startActivity(e);
					   }else{
						  Toast.makeText(getActivity(), "暂时没有该学校快递网点信息，请等待更新哦！！！", Toast.LENGTH_SHORT).show(); 
					   }
					 
					//progressDialog = new ProgressDialog(getActivity());
				//	QueryExpressUtil.queryExpressForNumber(number, name, code, getActivity(), progressDialog);
				}
			}
			break;
		default:
			break;
		}
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(data == null){
			return;
		}
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1){       //说明是快递选择触发的
			String code = data.getStringExtra("code");
			String name = data.getStringExtra("name");
			tv_express_name.setText(name);
		}
		
	}
}