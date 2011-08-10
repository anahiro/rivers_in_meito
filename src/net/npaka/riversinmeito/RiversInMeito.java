package net.npaka.riversinmeito;

import android.app.*;
import android.os.*;
import android.view.*;
import android.webkit.*;

public class RiversInMeito extends Activity {
	private WebView webView; //webÉrÉÖÅ[
	private Handler handler;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle sis) {
        super.onCreate(sis);
 
        handler = new Handler();
        
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSupportZoom(true);
        
        webView.addJavascriptInterface(new JSInterface(), "JSInterface");
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }
    
    public final class JSInterface{
		int i=0;
    	public void ClickFujinokigawa(){
    		handler.post(new Runnable(){
    			public void run(){
    	    		android.util.Log.e("RiversInMeito","ClickFujinokigawa "+ (++i));
    				webView.loadUrl("file:///android_asset/fujinokigawa.html");
    			}
    		});
    	}
    	public void ClickKanaregawa(){
    		handler.post(new Runnable(){
    			public void run(){
    	    		android.util.Log.e("RiversInMeito","ClickKanaregawa "+ (++i));
    				webView.loadUrl("file:///android_asset/kanaregawa.html");
    			}
    		});
    	}
    	public void ClickYadagawa(){
    		handler.post(new Runnable(){
    			public void run(){
    	    		android.util.Log.e("RiversInMeito","ClickYadagawa "+ (++i));
    				webView.loadUrl("file:///android_asset/yadagawa.html");
    			}
    		});
    	}
    	public void ClickUedagawa(){
    		handler.post(new Runnable(){
    			public void run(){
    	    		android.util.Log.e("RiversInMeito","ClickUedagawa "+ (++i));
       				webView.loadUrl("file:///android_asset/uedagawa.html");
       			 }
    		});
    	}
    	public void ClickMenu(){
    		handler.post(new Runnable(){
    			public void run(){
    	    		android.util.Log.e("RiversInMeito","ClickMenu "+ (++i));
    	            webView.loadUrl("file:///android_asset/index.html");
    			}
    		});
    	}
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
    	if((keyCode == KeyEvent.KEYCODE_BACK) & (webView.canGoBack())){
            webView.goBack();
    		return false;
    	} else {
    		return super.onKeyUp(keyCode, event);
    	}
    }
}