package com.example.tabeditor;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
        
        @Override
        public void onStart(){
        	super.onStart();
        	
        	TabHost tabs = (TabHost) getActivity().findViewById(android.R.id.tabhost);

    		tabs.setup();

    		TabHost.TabSpec spec = tabs.newTabSpec("tag1");

    		spec.setContent(R.id.tab1);
    		spec.setIndicator("Tab 1");
    		tabs.addTab(spec);

    		spec = tabs.newTabSpec("tag2");
    		spec.setContent(R.id.tab2);
    		spec.setIndicator("Tab 2");
    		tabs.addTab(spec);

    		spec = tabs.newTabSpec("tag3");
    		spec.setContent(R.id.tab3);
    		spec.setIndicator("Tab 3");
    		tabs.addTab(spec);

    		tabs.setCurrentTab(0);
        }
    }

}
