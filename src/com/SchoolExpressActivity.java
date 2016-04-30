package com;

import com.fzu.android.fdkdzs.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SchoolExpressActivity extends Activity implements OnClickListener{
	private TextView ems_Company,ems_school,company_address,company_phone,ems_cost,ems_more;
	String company_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.school_express_info);
		ems_Company = (TextView)this.findViewById(R.id.ems_company);
		ems_school = (TextView)this.findViewById(R.id.ems_school);
		company_address = (TextView)this.findViewById(R.id.company_address);
		company_phone =(TextView)this.findViewById(R.id.company_phone);
		company_phone.setOnClickListener(this);
		ems_cost = (TextView)this.findViewById(R.id.ems_cost);
		ems_more = (TextView)this.findViewById(R.id.ems_more);
		Bundle bundle = getIntent().getExtras();
		company_name = bundle.getString("name");
		//Log.v("name", name);
		this.ems_Company.setText(company_name);
		//Log.v("name", bundle.getString(name));
		String school_number = bundle.getString("number");
		//Log.v("number", school_number);
		//this.ems_school.setText(school_number);
		//number = getIntent().getStringExtra("number");
		//name = getIntent().getStringExtra("name");
		/*服务端未实现，以下仅是示例*/
		
			this.ems_school.setText(school_number);
		if(company_name.equals("申通")){
				this.company_address.setText("福州大学学生公寓36号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重8元\n江浙沪首重10元\n安徽江西湖南湖北首重13元\n河南河北北京天津广西山东首重16元\n重庆陕西四川云南贵州山西黑龙江吉林辽宁首重18");
				this.ems_more.setText("实际价格以到店为准");
				}
			else if(company_name.equals("EMS")){
				this.company_address.setText("福州大学学生公寓28号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重10元\n江浙沪广东首重12元\n山东安徽江西湖南湖北北京天津首重13元\n河南河北首重15元\n重庆陕西四川广西山西吉林辽宁首重18\n云南贵州山西黑龙江海南首重22");
				this.ems_more.setText("实际价格以到店为准");
				}	
			else if(company_name.equals("顺丰")){
				this.company_address.setText("暂无信息");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("暂无信息");
				this.ems_more.setText("暂无信息");
				}		
			else if(company_name.equals("圆通")){
				this.company_address.setText("福州大学学生公寓37号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重8元\n江浙沪广东首重10元\n山东安徽江西湖南湖北北京天津首重12元\n河南河北首重13元\n重庆陕西四川广西山西首重15元\n吉林辽宁云南贵州山西黑龙江海南首重17");
				this.ems_more.setText("实际价格以到店为准");
				}	
			else if(company_name.equals("中通")){
				this.company_address.setText("福州大学学生公寓34号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重8元\n江浙沪首重10元\n安徽江西湖南湖北首重12元\n河南河北北京天津广西山东首重15元\n重庆陕西四川云南贵州山西黑龙江吉林辽宁首重18");
				this.ems_more.setText("实际价格以到店为准");
				}	
			else if(company_name.equals("韵达")){
				this.company_address.setText("福州大学学生公寓39号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重8元\n江浙沪首重10元\n安徽江西湖南湖北首重15元\n河南河北北京天津广西山东首重18元\n重庆陕西四川云南贵州山西黑龙江吉林辽宁首重22");
				this.ems_more.setText("实际价格以到店为准");
				}		
			else if(company_name.equals("天天")){
				this.company_address.setText("福州大学学生公寓29号楼下电脑之家");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重8元\n江浙沪广东首重10元\n山东安徽江西湖南湖北北京天津首重12元\n河南河北首重13元\n重庆陕西四川广西山西首重15元\n吉林辽宁首重16\n云南贵州山西黑龙江海南首重18");
				this.ems_more.setText("实际价格以到店为准");
				}	
			else if(company_name.equals("汇通")){
				this.company_address.setText("福州大学学生公寓36号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重6元\n江浙沪广东江苏安徽首重7元\n湖南湖北江西首重8元\n山西首重9元\n河南河北天津山东广西首重10元\n重庆陕西四川云南贵州海南首重11元\n吉林辽宁黑龙江首重12元");
				this.ems_more.setText("实际价格以到店为准");
				}		
			else if(company_name.equals("全峰")){
				this.company_address.setText("福州大学学生公寓39号楼下");
				this.company_phone.setText("暂无信息");
				this.ems_cost.setText("省内首重7元\n江浙沪首重10元\n江西湖北湖南山东首重11元\n河北广西重庆四川陕西山西贵州海南云南首重13元\n黑龙江辽宁吉林首重16元\n内蒙甘肃宁夏青海首重18元");
				this.ems_more.setText("实际价格以到店为准");
				}else{
					this.company_address.setText("暂无信息");
					this.company_phone.setText("暂无信息");
					this.ems_cost.setText("暂无信息");
					this.ems_more.setText("暂无信息");
				}
		  }	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//if(company_name.equals("申通")){
		//	Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15695291307"));
        //通知activtity处理传入的call服务
		//startActivity(intent);
		//}
	
	}
}
