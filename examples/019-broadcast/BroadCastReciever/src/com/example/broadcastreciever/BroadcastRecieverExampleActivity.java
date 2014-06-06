package com.example.broadcastreciever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BroadcastRecieverExampleActivity extends Activity 
				implements View.OnClickListener {
	
	private static String ACTION = "com.samples.media.PLAYER";
	private static final String TYPE = "type";
	private static final int ID_ACTION_PLAY = 0;
	private static final int ID_ACTION_STOP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_reciever_example);
  
    }
    
    @Override
    public void onClick(View v) {
    	Toast.makeText(BroadcastRecieverExampleActivity.this, "click", Toast.LENGTH_SHORT).show();
	    switch (v.getId()) {
	    case R.id.bStart:
		    Intent iStart = new Intent(ACTION);
		    iStart.putExtra(TYPE, ID_ACTION_PLAY);
		    sendBroadcast(iStart);
		    break;
		    
	    case R.id.bStop:
		    Intent iStop = new Intent(ACTION);
		    iStop.putExtra(TYPE, ID_ACTION_STOP);
		    sendBroadcast(iStop);
		    break;
	    }
    }


}
