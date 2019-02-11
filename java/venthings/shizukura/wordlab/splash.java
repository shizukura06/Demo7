package venthings.shizukura.wordlab;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.splash);

    // if (ContextCompat.checkSelfPermission(this,
    //         Manifest.permission.MEDIA_CONTENT_CONTROL)
    //         != PackageManager.PERMISSION_GRANTED) {
    //     ActivityCompat.requestPermissions(this,new String[]{

    //             Manifest.permission.INTERNET,
    //             Manifest.permission.MEDIA_CONTENT_CONTROL},1);

    //   }
    Thread splash = new Thread(){
      public void run(){
        try{

          // while (ContextCompat.checkSelfPermission(splash.this,
          //         Manifest.permission.MEDIA_CONTENT_CONTROL)
          //         != PackageManager.PERMISSION_GRANTED){
          //
          // }
          //              mina.animate();
          sleep(5000);
          Intent splashintent=new Intent(getBaseContext(),mainMenu.class);
          //overridePendingTransition(R.anim.fade,R.anim.fade_out);
          startActivity(splashintent);
          finish();
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    splash.start();
  }
  @Override
  public void onBackPressed(){

  }
}