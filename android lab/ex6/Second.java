package com.example.rssfeed;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class Second extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);
      WebView w1=(WebView)findViewById(R.id.webView);
      //w1.loadUrl("http://192.168.1.83:8080/android/ex6/searchengines.xml");
      w1.loadUrl("http://android.jacsice.in/searchengines.xml");
      //w1.loadUrl("http://android.jacsice.in/colleges.xml");
   }
}
