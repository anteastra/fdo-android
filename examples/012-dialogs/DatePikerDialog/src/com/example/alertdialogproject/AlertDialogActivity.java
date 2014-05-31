package com.example.alertdialogproject;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {
	
	private static final int ID_DIALOG_ALERT = 0;
	private static final int ID_DIALOG_TIME = 1;
	
	private TextView text;
	private TextView textTime;
	private int years;
	private int months;
	private int days;
	
	
	private int hour;
	private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        
        text = (TextView)findViewById(R.id.textView);
        textTime = (TextView)findViewById(R.id.textViewTime);
        
        
        Calendar c = Calendar.getInstance();
        years = c.get(Calendar.YEAR);
        months = c.get(Calendar.MONTH);
        days = c.get(Calendar.DAY_OF_MONTH);
        
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);
        updateDisplay();
        
        Button button = (Button) findViewById(R.id.buttonAlertD);
        button.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(ID_DIALOG_ALERT);
			}
        	
        });
        
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(ID_DIALOG_TIME);
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
    		
    	case ID_DIALOG_TIME:
    		TimePickerDialog dialog2 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					hour = hourOfDay;
					min = minute;
					updateDisplay();
				}
			}, hour, min, true);
    		
    		return dialog2;
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
    	
    	textTime.setText(String.valueOf(hour)+":"+min);
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
