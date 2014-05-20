package com.example.progressdialogproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ProgressDialogActivity extends Activity {

	private static final int ID_PROGRESS = 0;
	private ProgressThread thread;
	private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        
        Button button = (Button) findViewById(R.id.buttonDoTask);
        button.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(ID_PROGRESS);
			}
        	
        });
    }
    
    @Override
    public Dialog onCreateDialog(int id) {
    	switch(id) {
    	case ID_PROGRESS:
    		dialog = new ProgressDialog(ProgressDialogActivity.this);
    		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    		dialog.setMessage("Loading...");
    		thread = new ProgressThread(handler);
    		thread.start();
    		return dialog;
    	default:
    		return null;
    	}
    }
      
    
    final Handler handler = new Handler() {
    	public void handleMessage(Message msg) {
	    	int total = msg.getData().getInt("total");
	    	dialog.setProgress(total);
	    	if (total >= 100){
		    	dismissDialog(ID_PROGRESS);
		    	thread.setState(ProgressThread.STATE_DONE);
		    	Toast.makeText(getApplicationContext(), "Task is finished",
		    	Toast.LENGTH_SHORT).show();
	    	}
	   	}
    };

}
