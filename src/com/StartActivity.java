package com;

import android.app.Activity;
import android.content.Intent; 
import android.os.Bundle; 
import android.os.Handler; 
import com.fzu.android.fdkdzs.R;
public class StartActivity  extends Activity{
	    private final int SPLASH_DISPLAY_LENGHT = 2500; //延迟2.5秒 

	    @Override 
	    public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.start); 
	        new Handler().postDelayed(new Runnable(){ 

	         @Override 
	         public void run() { 
	             Intent mainIntent = new Intent(StartActivity.this,MainTabActivity.class); 
	             StartActivity.this.startActivity(mainIntent); 
	             StartActivity.this.finish(); 
	         } 
	            
	        }, SPLASH_DISPLAY_LENGHT); 
	    } 
}

