package com.example.broadcastreciever;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayService extends Service {
	MediaPlayer player;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
		player = MediaPlayer.create(this, R.raw.umbrella);
		player.setLooping(false);
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
		player.start();
	}
	
	@Override
		public void onDestroy() {
		Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
		player.stop();
	}
}