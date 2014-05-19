package com.example.test.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

public class PlaceholderFragment2 extends Fragment {
	
	int i = 0;
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
        View rootView = inflater.inflate(R.layout.fragment_main2, container, 
        		false);        
        return rootView;
    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	
    	Button button = (Button) getActivity().findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getFragmentManager();
				PlaceholderFragment fragment1 = (PlaceholderFragment) 
						fm.findFragmentById(R.id.fragment1);				
				String value = fragment1.inner;
				TextView view = (TextView) getActivity().findViewById(R.id.text);
				view.setText(value + ". Counted: " + ++i);
			}
		});
        
    }
}