package com.example.externalstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button b1, b2;
	private EditText e;
	private String path = Environment.getExternalStorageDirectory().getPath()
			+ "/myfile.txt";
	private TextView result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.buttonone);
		b2 = (Button) findViewById(R.id.buttontwoss);
		e = (EditText) findViewById(R.id.editText1);
		result = (TextView) findViewById(R.id.result);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					File myfile = new File(path);
					myfile.createNewFile();
					FileOutputStream fos = new FileOutputStream(myfile);
					OutputStreamWriter out = new OutputStreamWriter(fos);
					out.append(e.getText());
					out.close();
					fos.close();
					Toast.makeText(getApplicationContext(),
							"saved 'myfile.txt' in "+path, Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					File myFile = new File(path);
					FileInputStream fis = new FileInputStream(myFile);
					BufferedReader bd = new BufferedReader(
							new InputStreamReader(fis));
					String adata = "";
					String buff = "";
					while ((adata = bd.readLine()) != null) {
						buff += adata + "\n";
					}

					result.setText(buff);
					bd.close();
					Toast.makeText(getBaseContext(), "done reding 'myfile.txt from "+path,
							Toast.LENGTH_LONG).show();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
