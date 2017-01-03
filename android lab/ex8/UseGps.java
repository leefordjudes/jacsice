package com.emergency;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UseGps extends Activity
{
	//Button buttonSend;
	EditText textLat;
	EditText textlon;
@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	//buttonSend = (Button) findViewById(R.id.buttonSend);
	textLat = (EditText) findViewById(R.id.editTextLat);
	textlon = (EditText) findViewById(R.id.textlon);
	LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	LocationListener mlocListener = new MyLocationListener();
	mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
	// two provider: 1.GPS_PROVIDER 2.NETWORK_PROVIDER


}

public class MyLocationListener implements LocationListener
{
	
public void onLocationChanged(Location loc)
{
	loc.getLatitude();
	loc.getLongitude();
	Double lat=loc.getLatitude();
	Double lon=loc.getLongitude();
	textLat.setText(lat.toString());
	textlon.setText(lon.toString());
}

public void onProviderDisabled(String provider)
{
	Toast.makeText( getApplicationContext(),"Gps Disabled",Toast.LENGTH_SHORT).show();
}

public void onProviderEnabled(String provider)
{
	Toast.makeText( getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show();
}

public void onStatusChanged(String provider, int status, Bundle extras)
{}

}

public void showLocation(View v){
	Toast.makeText(getApplicationContext(),"Your Location is \nLatitude: "+textLat.getText().toString()+"\nLongitude: "+textlon.getText().toString(), Toast.LENGTH_LONG).show();
	}

}