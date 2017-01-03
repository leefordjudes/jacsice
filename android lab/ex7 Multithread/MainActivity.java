package com.example.multthreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tvOutput;
	private static final int t1 = 1;
	private static final int t2 = 2;
	private static final int t3 = 3;
	private static int counter=0;
	private boolean start=true; 
	private static int ft=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvOutput = (TextView) findViewById(R.id.textView1);
		//below initializations are useful when the application restarts or resumes.
		counter =0;
		start = true;
		ft=0;
	}
	
	
	public void fetchData(View v) {
		if(start){
			tvOutput.setText("Main thread");
			thread1.start();
			thread2.start();
			thread3.start();
			start=false;
		}else{
			if(ft!=3)
			{tvOutput.append("\n -- Already Running");}
			else{tvOutput.append("\n -- Finished Run");}
			}
		}
	
		Thread thread1 = new Thread(new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) 
				{
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				handler.sendEmptyMessage(t1);
				}
			ft++;
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) 
				{
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
								e.printStackTrace();
								}
				handler.sendEmptyMessage(t2);
				}
			ft++;
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
		@Override
		public void run() {
				for (int i = 0; i < 5; i++) 
				{
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
							e.printStackTrace();
							}
				handler.sendEmptyMessage(t3);
				}
			ft++;			
			}
		});
		
		Handler handler = new Handler() {
					public void handleMessage(android.os.Message msg) {
							if(msg.what == t1) {
												tvOutput.append("\nIn thread 1"+" - "+(counter++));
												}
							if(msg.what == t2) {
												tvOutput.append("\nIn thread 2"+" - "+(counter++));
												}
							if(msg.what == t3) {
												tvOutput.append("\nIn thread 3"+" - "+(counter++));
												}
																	}
										};
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
