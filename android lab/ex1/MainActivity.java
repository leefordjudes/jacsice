package in.jacsice.android.guicomponents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



public class MainActivity extends Activity {
	
	private EditText ed1,ed2;
	private RadioGroup rg1;
	private RadioButton rb;
	private Button bu;
	
	public final static String EXTRA_MESSAGE = "username";
	private Intent intent;
	String message;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bu = (Button) findViewById(R.id.button1);
        
        
        bu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
										ed1 = (EditText) findViewById(R.id.editText1);
										ed2 = (EditText) findViewById(R.id.editText2);
										rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
										
										int selectedId=rg1.getCheckedRadioButtonId();
										rb=(RadioButton)findViewById(selectedId);
										
										String a = ed1.getText().toString();
										String b = ed2.getText().toString();
										String c = rb.getText().toString();
										
										if (a.equals("a") && b.equals("a")) {
											intent=new Intent(v.getContext(),ResultActivity.class);
									        message = "Welcome "+c+""+a+"\nYou are logged in.";
									        intent.putExtra(EXTRA_MESSAGE, message);
									        v.getContext().startActivity(intent);
											} 
										else {
											Toast msg = Toast.makeText(getBaseContext(), "Invalid User!!!", Toast.LENGTH_LONG);
											msg.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, -100);
											msg.show();
											}
										}
														});
    												}
												}
