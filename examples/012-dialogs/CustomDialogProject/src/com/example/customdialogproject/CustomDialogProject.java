package com.example.customdialogproject;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;


public class CustomDialogProject extends Activity {
	
	private final static int ID_CUSTOM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_project);
        
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(ID_CUSTOM);
			}
        	
        });
    }

    
    @Override
    protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case ID_CUSTOM:
		    LayoutInflater inflater = getLayoutInflater();
		    View layout = inflater.inflate(
		    		R.layout.custom_layout,
		    		null);
		    
		    TextView text = (TextView)layout.findViewById(R.id.textView1);
		    text.setText("Are you sure you want to exit?");
		    ImageView image = (ImageView) layout.findViewById(R.id.imageView1);
		    image.setImageResource(R.drawable.ic_launcher);
		    
		    AlertDialog.Builder builder = new AlertDialog.Builder(this);
		    builder.setView(layout);
		    builder.setMessage("This is a custom dialog!");
		    builder.setPositiveButton("Yes",
			    new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int id) {
				    	CustomDialogProject.this.finish();
				    }
		    });
		    
		    builder.setNegativeButton("No",
			    new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int id) {
				    dialog.cancel();
			    }
		    });
		    
		    builder.setCancelable(false);
		    return builder.create();
		    
		default:
		    return null;
	    }
    }

}
