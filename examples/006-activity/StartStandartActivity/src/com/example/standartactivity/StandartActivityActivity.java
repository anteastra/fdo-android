package com.example.standartactivity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;

public class StandartActivityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_activity);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.standart_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_standart_activity, container, false);
            return rootView;
        }
        
        @Override
        public void onStart() {
        	super.onStart();
        	
        	View button;
            button = getActivity().findViewById(R.id.buttonMusic);
            button.setOnClickListener(new OnClickListener() {

     			@Override
     			public void onClick(View v) {
     				Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
     				startActivity(intent);
     			}
             	
            });
             
            button = getActivity().findViewById(R.id.buttonRecorder);
            button.setOnClickListener(new OnClickListener() {

     			@Override
     			public void onClick(View v) {
     				Intent intent = new Intent(Media.RECORD_SOUND_ACTION);
     				startActivity(intent);
     			}
             	
            });
        }
    }

}
