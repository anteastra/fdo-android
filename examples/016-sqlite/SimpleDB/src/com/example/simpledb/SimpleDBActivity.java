package com.example.simpledb;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;
import android.provider.BaseColumns;

public class SimpleDBActivity extends Activity implements View.OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_db);
	}
	
	@Override
	public void onClick(View arg0) {
		SQLiteDatabase db = new ContactDbHelper(getApplicationContext()).getWritableDatabase();
		
		if (db != null) {
			Toast.makeText(getApplicationContext(),
			"DB Contacts is created", Toast.LENGTH_LONG).show();
		}
		
		else {
			Toast.makeText(getApplicationContext(),
			"Error create database!", Toast.LENGTH_LONG).show();
		}
	}
}
