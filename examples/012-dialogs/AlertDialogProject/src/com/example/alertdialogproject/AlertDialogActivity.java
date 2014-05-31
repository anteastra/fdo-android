package com.example.alertdialogproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlertDialogActivity extends Activity {
	
	private static final int ID_DIALOG_ALERT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        
        Button button = (Button) findViewById(R.id.buttonAlertD);
        button.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(ID_DIALOG_ALERT);
			}
        	
        });
    }
    
    @Override
    public Dialog onCreateDialog(int id) {    	
    	Dialog dialog = null;
    	switch(id) {
    	case ID_DIALOG_ALERT:
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		
    		builder.setMessage("Are you sure you want to exit?");
    		
    		builder.setCancelable(false);
    		
    		builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				// Закрываем текущий Activity
    				AlertDialogActivity.this.finish();
    			}
    		});
    		
    		builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialogInt, int id) {
    				// Закрываем диалог и возвращаемся к текущему Activity
    				dialogInt.cancel();
    			}
    		});
    		
    		AlertDialog alert = builder.create();
    		
    		dialog = alert;
    		
    		break;
    	default:
    		dialog = null;
    	}
    	return dialog;
    }

}
