package course.examples.Services.MusicService;

import course.examples.Services.MusicService.MusicService.MyBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MusicServiceClient extends Activity {
	
	MusicService mService;
	
	private ServiceConnection mServiceConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName className,
				IBinder service) {
			// Используется для взаимодействия со службой
			MyBinder binder = (MyBinder)service;
			mService = binder.getService();
		}
		
		public void onServiceDisconnected(ComponentName className) {
		
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		
		// Intent used for starting the MusicService
		final Intent musicServiceIntent = new Intent(this,
				MusicService.class);
		
		final Button bindButton = (Button) findViewById(R.id.buttonBind);
		bindButton.setOnClickListener(new OnClickListener() {
			public void onClick(View src) {
				
				// Bind the MusicService using the Intent
				//startService(musicServiceIntent);
				MusicServiceClient.this.bindService(musicServiceIntent, mServiceConnection, Context.BIND_AUTO_CREATE);

			}
		});

		final Button unbindButton = (Button) findViewById(R.id.buttonUnbind);
		unbindButton.setOnClickListener(new OnClickListener() {
			public void onClick(View src) {

				// Unbind the MusicService using the Intent
				MusicServiceClient.this.unbindService(mServiceConnection);

			}
		});
		
		final Button performButton = (Button) findViewById(R.id.buttonStart);
		performButton.setOnClickListener(new OnClickListener() {
			public void onClick(View src) {

				Toast.makeText(MusicServiceClient.this, mService.getRandomNumber(), Toast.LENGTH_SHORT).show();

			}
		});

	}



}