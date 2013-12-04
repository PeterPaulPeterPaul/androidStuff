package com.example.ids2app;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity {

    WebView myWebView;
    
    @SuppressWarnings("deprecation")
    @SuppressLint("SetJavaScriptEnabled")
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_main);
		 
	         myWebView = (WebView) findViewById(R.id.webview);
	         WebSettings webSettings = myWebView.getSettings();
	         webSettings.setJavaScriptEnabled(true); //Enables Javascript. Remove this line if your site doesn't require javascript
	         myWebView.getSettings().setPluginState(PluginState.ON); //Enables plugins like Adobe flash. Remove if not required
	         myWebView.loadUrl("http://hypothetical-motion.appspot.com/login"); //Change this with your website's url
	 
	         myWebView.setWebViewClient(new myWebViewClient());
	}
    
    private class myWebViewClient extends WebViewClient {
    	 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
 
            view.loadUrl(url);
            return false;
        }
 
            } 
 
         @Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {
 
            if (keyCode == KeyEvent.KEYCODE_BACK){
                if(myWebView.canGoBack()){
                    myWebView.goBack();
                    return true;
                }
            }
 
            return super.onKeyDown(keyCode, event);
        } 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
