package com.example.alarm_final;


import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	private TextView tv;
	private static final int t1 = 1;
	private static final int finished = 2;
	private static int counter=4;// Current second is 5th second
	//private static Bundle b;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.b=savedInstanceState;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl1);
		tv = (TextView)findViewById(R.id.test);
		rl.setOnTouchListener(this);
		// Create an offset from the current time in which the alarm will go
		// off.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 5);
		tv.setText("Alarm in 5 Seconds");
		// Create a new PendingIntent and add it to the AlarmManager
		Intent intent = new Intent(this, AlarmReceiverActivity.class);
		//startActivity(intent);
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 12345,
										intent, PendingIntent.FLAG_CANCEL_CURRENT);
		//pending intent means gets an intent and waits to trigger ro start 
		AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
		//AlarmManager.RTC_WAKEUP  -- if an application is in closed state, at that time also the activity is triggered.
		//RTC - real time clock
	/*	
		int s=5;
		for(int i=5;i>=0;i--){
			s=i;
			tv = (TextView)findViewById(R.id.test);
			tv.setText("Alarm in "+s+" Seconds");
			
			for(int j=100000;j>=1;j--);
			//{s=i;}
			//try{Thread.sleep(1000);s=i;}catch(InterruptedException ie){}
				}
	*/
			startthread(getWindow().getDecorView().getRootView());
	}
	public void startthread(View v){
		tv.setText("Start Running");
		thread1.start();
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
				if(counter>0)
					{handler.sendEmptyMessage(t1);}
				else{handler.sendEmptyMessage(finished);}
				}
						
			}
		
		});
	
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
				if(msg.what == t1) {
									tv.setText((counter--)+" Seconds to Alarm");
									}
				if(msg.what == finished) {
									tv.setText("Alarmed.");
									}
													}
							};

	
	
	public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
            	
            	Calendar cal1 = Calendar.getInstance();
        		cal1.add(Calendar.SECOND, 5);
        		Intent intent1 = new Intent(this, AlarmReceiverActivity.class);
        		PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 12345,intent1, PendingIntent.FLAG_CANCEL_CURRENT);
        		AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
        		am.set(AlarmManager.RTC_WAKEUP, cal1.getTimeInMillis(), pendingIntent1);
        		Thread t1 = new Thread(thread1);
        		counter = 4; // Current second is 5th second
        		t1.start();
            break;
        }
        return true;
    }
	
}