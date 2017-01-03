package in.jacsice.android.guicomponents;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends Activity {
	
	private TextView tv1;
	private Button bu1,bu2,bu3;
	private String tamilstr="jq;fs; tuT ey;tuthFf!";
	private Typeface tf=null;
	private String message="english text";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        

        // Create the text view
        tv1 = (TextView) findViewById(R.id.textview1);
        tv1.setTextSize(40);
        tv1.setText(message);

        // Set the text view as the activity layout
        //setContentView(tv1);
        
        bu1 = (Button) findViewById(R.id.button1);
        bu2 = (Button) findViewById(R.id.button2);
        bu3 = (Button) findViewById(R.id.button3);
        
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl1);
        
        bu1.setOnClickListener(new View.OnClickListener() {
			
			@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				
				//Drawable dbg = v.getBackground();
				
				tv1.setText(message);
				rl.setBackgroundColor(getResources().getColor(R.color.Red));
				tv1.setTextColor(getResources().getColor(R.color.White));
				tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
				Typeface tf = Typeface.SANS_SERIF;
				tv1.setTypeface(tf,Typeface.NORMAL);
				
				//v.setBackground(dbg);
				bu2.setBackgroundResource(android.R.drawable.btn_default);
				//bu3.setBackgroundResource(android.R.drawable.btn_default);
				
				Toast msg = Toast.makeText(getBaseContext(), "Theme 1 clicked!!", Toast.LENGTH_LONG);
				msg.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, -100);
				msg.show();
			}
        });
        
        bu2.setOnClickListener(new View.OnClickListener() {
			
        	@SuppressWarnings("deprecation")
        	@Override
			public void onClick(View v) {
        		
        		
        		tv1.setText(message);
				rl.setBackgroundColor(getResources().getColor(R.color.Green));
				tv1.setTextColor(getResources().getColor(R.color.Black));
				tv1.setTextSize(24);
				//Typeface tf = Typeface.MONOSPACE;
				//tv1.setTypeface(tf,Typeface.ITALIC);
				Typeface tf = Typeface.createFromAsset(getAssets(), "font/ALGER.TTF");
				tv1.setTypeface(tf,Typeface.ITALIC);
				//bu1.setBackgroundResource(android.R.drawable.btn_default);
				bu2.setBackgroundResource(android.R.drawable.btn_default);
				//bu3.setBackgroundResource(android.R.drawable.btn_default);
				
				Toast msg = Toast.makeText(getBaseContext(), "Theme 2 clicked!!", Toast.LENGTH_LONG);
				msg.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, -100);
				msg.show();
			}
        });

		bu3.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				//bu1.setBackgroundResource(android.R.drawable.btn_default);
				bu2.setBackgroundResource(android.R.drawable.btn_default);
				//bu3.setBackgroundResource(android.R.drawable.btn_default);
				rl.setBackgroundColor(getResources().getColor(R.color.Blue));
				tv1.setTextColor(getResources().getColor(R.color.Yellow));
				tv1.setTextSize(32);
				tv1.setText(tamilstr);
				//Typeface tf = Typeface.SERIF;
				//tv1.setTypeface(tf,Typeface.BOLD);
				Typeface tf = Typeface.createFromAsset(getAssets(), "font/TAMIL BIBLE.TTF");
				tv1.setTypeface(tf,Typeface.BOLD);
				Toast msg = Toast.makeText(getBaseContext(), "Theme 3 clicked!!", Toast.LENGTH_LONG);
				msg.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, -100);
				msg.show();
			}
		});
	}
	
}
