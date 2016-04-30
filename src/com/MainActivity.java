package com;
import com.util.*;
import com.zxing.activity.*;

import com.fzu.android.fdkdzs.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Fragment implements OnClickListener{
	private Button btn_main_reset;
	private EditText tv_main_express_number;
	private TextView tv_main_express_name;
	private Button btn_main_search;
	private String code = "";
	private ProgressDialog progressDialog;
	private ImageView tv_scane_express_number;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.activity_main, null);		
	}	
public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	// 获取网络连接管理的对象
    
	boolean isNetwork = NetUilt.checkNet(getActivity());// 获取网络信息
	if (!isNetwork){
		setNetwork();
		//Toast.makeText(getActivity(), "网络连接不可用，请检查您的网络！", Toast.LENGTH_LONG).show();
	}
	
	tv_main_express_number = (EditText)  getView().findViewById(R.id.tv_main_express_number);
	btn_main_reset = (Button)  getView().findViewById(R.id.btn_main_reset);
	btn_main_reset.setOnClickListener(MainActivity.this);
	//tv_main_express_number.setText("");
	tv_scane_express_number = (ImageView)  getView().findViewById(R.id.scane_express_number);
	tv_scane_express_number.setOnClickListener(this);
	btn_main_search = (Button)  getView().findViewById(R.id.btn_main_search);
	tv_main_express_name = (TextView)  getView().findViewById(R.id.tv_main_express_name);
	tv_main_express_name.setOnClickListener(this);
	btn_main_search.setOnClickListener(this);
	}
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.scane_express_number:
		Intent openCameraIntent = new Intent(getActivity(),CaptureActivity.class);
		startActivityForResult(openCameraIntent, 0);  //0跟下面的onActivityResult方法对应
	
	case R.id.btn_main_reset:
		tv_main_express_number.setText("");
		break;
	case R.id.tv_main_express_name:
		Intent intent = new Intent(getActivity(), ExpressList.class);
		startActivityForResult(intent, 1);
		break;
	case R.id.btn_main_search:
		String name = tv_main_express_name.getText().toString();
		if(name.equals("")){
			Toast.makeText(getActivity(), "请先选择快递", Toast.LENGTH_SHORT).show();
		}else{
			String number = tv_main_express_number.getText().toString();
			if(number.equals("")){
				Toast.makeText(getActivity(), "快递号码不能为空", Toast.LENGTH_SHORT).show();
			}else{
				//searchForJson(number,name);
				progressDialog = new ProgressDialog(getActivity());
				QueryExpressUtil.queryExpressForNumber(number, name, code, getActivity(), progressDialog);
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
		code = data.getStringExtra("code");
		String name = data.getStringExtra("name");
		tv_main_express_name.setText(name);
		tv_main_express_number.setText("");
	}
	else if(requestCode == 0){    //扫描按钮触发的
		Bundle bundle = data.getExtras();
		String scanResult = bundle.getString("result");
		tv_main_express_number.setText(scanResult);
	}
	
}
public void setNetwork()
{
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setIcon(android.R.drawable.ic_dialog_alert);
    builder.setTitle(R.string.netstate);
    builder.setMessage(R.string.setnetwork);
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub
            Intent mIntent = new Intent();
          // mIntent.setAction(Intent.ACTION_MAIN);
          //mIntent.addCategory("android.intent.category.LAUNCHER");
          // mIntent.setFlags(0x10200000);
          //  ComponentName comp = new ComponentName("com.android.settings",
            //        "com.android.settings.Settings");
            //mIntent.setComponent(comp);
          //mIntent.setAction("android.intent.action.VIEW");
            if(android.os.Build.VERSION.SDK_INT > 10){ // 3.0以上 
            	mIntent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS); 
            	}else{  
            	mIntent.setClassName("com.android.settings", "com.android.settings.WirelessSettings"); 
            	} 
            startActivity(mIntent);
        }
    });
    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });
    builder.create();
    builder.show();
}
}
