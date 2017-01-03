package in.jacsice.android.layoutmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button clickBtn, longClickBtn, allBtn, btnShow;
	TextView sample;
	EditText nameTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		clickBtn = (Button) findViewById(R.id.btnClick);
		longClickBtn = (Button) findViewById(R.id.btnLongClick);
		allBtn = (Button) findViewById(R.id.btnAll);
		btnShow = (Button) findViewById(R.id.btnShowName);
		sample = (TextView) findViewById(R.id.txtSample);
		nameTxt = (EditText) findViewById(R.id.txtName);
		
		clickBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "Hai from borderless button!", Toast.LENGTH_SHORT).show();
			}
			});
		
		/*Implement Long Click Listener*/
		longClickBtn.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
			Toast.makeText(getApplicationContext(), "Hai from default style button!",
			Toast.LENGTH_SHORT).show();
			return false;
			}
			});
		
		allBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "You Just Clicked Me!",
			Toast.LENGTH_SHORT).show();
			}
			});
		
		allBtn.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
			Toast.makeText(getApplicationContext(), "You clicked me for so long!",
			Toast.LENGTH_SHORT).show();
			return true; 
			// return true means to disable event bubble & calling onClick again. 
			// return false means, its calls the onClick event again.
			}
			});
			
		btnShow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			sample.setText(nameTxt.getText().toString());
			}
			});
	}

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
