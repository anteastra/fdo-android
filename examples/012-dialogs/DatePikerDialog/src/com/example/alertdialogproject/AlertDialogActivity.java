package com.example.alertdialogproject;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {
	
	private static final int ID_DIALOG_ALERT = 0;
	
	private TextView text;
	private int years;
	private int months;
	private int days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        
        text = (TextView)findViewById(R.id.textView);
        final Calendar c = Calendar.getInstance();
        years = c.get(Calendar.YEAR);
        months = c.get(Calendar.MONTH);
        days = c.get(Calendar.DAY_OF_MONTH);
        updateDisplay();
        
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
    	switch(id) {
    	case ID_DIALOG_ALERT:
    		
    		DatePickerDialog dialog = new DatePickerDialog(
    				this, dateSetListener, years, months, days);
    		
    		return dialog;
    		
    	default:
    		return null;
    	}
    }
    
    private void updateDisplay() {
    	text.setText(
	    	new StringBuilder()
	    	.append(months + 1).append("-")
	    	.append(days).append("-")
	    	.append(years).append(" "));
    }
    
    private DatePickerDialog.OnDateSetListener dateSetListener =
    		new DatePickerDialog.OnDateSetListener() {
	    		@Override
	    		public void onDateSet(DatePicker view, int year,
	    				int monthOfYear, int dayOfMonth) {
		    		years = year;
		    		months = monthOfYear;
		    		days = dayOfMonth;
		    		updateDisplay();
	    		}
    		};

}
