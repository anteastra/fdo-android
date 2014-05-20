package com.example.alertdialogproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {
	
	private static final int ID_DIALOG_ALERT = 0;
	
	CharSequence[] colors = {"Red", "Green", "Blue"};
	final boolean[] checkedItems = {true, false, true};

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
    		
    		builder.setTitle("Pick a color");
    		
    		builder.setCancelable(false);
    		
    		builder.setMultiChoiceItems(colors, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
    			
				@Override
				public void onClick(DialogInterface dialog, int which,
						boolean isChecked) {
					checkedItems[which] = isChecked;
				}
    		});
    		
    		builder.setPositiveButton("OK",
    				new DialogInterface.OnClickListener() {    				
    					
    					public void onClick(DialogInterface dialog, int id) {
    						StringBuilder state = new StringBuilder();
    						
    						for (int i = 0; i < colors.length; i++) {
    							state.append("Color: " + colors[i] + ", state: ");
    							if (checkedItems[i])
    								state.append("checked\n");
    							else
    								state.append("unchecked\n");
    						}
    						
    						Toast.makeText(getApplicationContext(),
    						state.toString(), Toast.LENGTH_LONG).show();
    					}
    		});
    		
    		builder.setNegativeButton("Cancel",
    				new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog, int id) {
    						dialog.cancel();
    						Toast.makeText(getApplicationContext(),
    							"Dialog cancel", Toast.LENGTH_SHORT).show();
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
