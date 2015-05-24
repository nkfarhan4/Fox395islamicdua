package com.app.islamicduaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.app.islamicduaapp.R;

public class ActivitySplash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		 Thread background = new Thread() {
	            public void run() {
	                try {
	                    sleep(2 * 1000);
	                    Intent i = new Intent(getBaseContext(), ActivityHome.class);
	                    startActivity(i);
	                    finish();
	                } catch (Exception e) {
	                }
	            }
	        };
	        background.start();
	}
}
