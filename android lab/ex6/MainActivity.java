package com.example.rssfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText title, link, description;
	private Button b1, b2;
	//private String finalUrl = "http://192.168.1.83:8080/android/ex6/searchengines.xml";
	private String finalUrl = "http://android.jacsice.in/searchengines.xml";
	//private String finalUrl = "http://android.jacsice.in/colleges.xml";
	private HandleXML obj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		title = (EditText) findViewById(R.id.editText);
		link = (EditText) findViewById(R.id.editText2);
		description = (EditText) findViewById(R.id.editText3);

		b1 = (Button) findViewById(R.id.button);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				obj = new HandleXML(finalUrl);
				obj.fetchXML();

				while (obj.parsingComplete);
				title.setText(obj.getTitle());
				link.setText(obj.getLink());
				description.setText(obj.getDescription());
			}
		});

		b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this, Second.class);
				startActivity(in);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}