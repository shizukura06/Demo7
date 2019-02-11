package venthings.shizukura.wordlab;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Steven Dale Lucero on 03/06/2018.
 */

public class musicService  extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.bgm);
        player.setLooping(true);
        player.setVolume(100,100);
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        return 1;
    }
    public void onStart(Intent intent, int startId){

    }
    public void onPause(){

    }
        @Override
    public void onDestroy(){
            player.stop();
            player.release();

        }
    @Override
    public void onLowMemory(){

    }
}
