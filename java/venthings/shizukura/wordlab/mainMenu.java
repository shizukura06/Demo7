package venthings.shizukura.wordlab;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private boolean mBackKeyFlag = false;
    Button a,b,c,d,e,musicSvc,dev,about;
//    MediaPlayer player,player2;
    public SharedPreferences db;
    public SharedPreferences.Editor dbEdit;
    Drawable newgame1,newgame2,loadgame1,loadgame2,settings1,settings2,help1,help2,exit1,exit2;
    public Intent svc;
    public Intent[] intents;
    public TextView text3,substances;
    int i,level,substance;
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 0){
                mBackKeyFlag = false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.fade, R.anim.fade_out);
        setContentView(R.layout.activity_settings);
//        player2 = MediaPlayer.create(this, R.raw.down);
//        player2.setLooping(false);
//        player2.setVolume(100, 100);
//        player = MediaPlayer.create(this, R.raw.up);
//        player.setLooping(false);
//        player.setVolume(100, 100);
        a = (Button) findViewById(R.id.newgame);
        b = (Button) findViewById(R.id.laod);
        c = (Button) findViewById(R.id.ettings);
        d = (Button) findViewById(R.id.elf);
        musicSvc = (Button) findViewById(R.id.btn_music);
        dev = (Button) findViewById(R.id.btn_developer);
        about = (Button) findViewById(R.id.btn_about);
/*        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yess = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://facebook.com/WordLab-238404860048555"));
                startActivity(yess);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yess = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://facebook.com/WordLab-238404860048555"));
                startActivity(yess);
            }
        });
   */
        substances = (TextView) findViewById(R.id.textView4);
        db = getSharedPreferences("DB", 0);
        level = db.getInt("level", 1);
        substance = db.getInt("substance", 400);
        i = db.getInt("music", 1);
        substances.setText(String.valueOf(substance));
        intents = new Intent[]{
                new Intent(mainMenu.this, A_lvl1.class),
                new Intent(mainMenu.this, A_lvl2.class),
                new Intent(mainMenu.this, A_lvl3.class),
                new Intent(mainMenu.this, A_lvl4.class),
                new Intent(mainMenu.this, A_lvl5.class),
                new Intent(mainMenu.this, A_lvl6.class),
                new Intent(mainMenu.this, A_lvl7.class),
                new Intent(mainMenu.this, A_lvl8.class),
                new Intent(mainMenu.this, A_lvl9.class),
                new Intent(mainMenu.this, A_lvl10.class),
                new Intent(mainMenu.this, A_lvl11.class),
                new Intent(mainMenu.this, A_lvl12.class),
                new Intent(mainMenu.this, A_lvl13.class),
                new Intent(mainMenu.this, A_lvl14.class),
                new Intent(mainMenu.this, A_lvl15.class),
                new Intent(mainMenu.this, A_lvl16.class)
        };

        try {
            if (i == 1) {
                svc = new Intent(this, musicService.class);
                startService(svc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.setDrawerListener((DrawerLayout.DrawerListener) b);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 1) {
                    Intent splashintent = new Intent(getBaseContext(), started.class);
                    startActivity(splashintent);

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu.this);
                    builder.setMessage("Are you sure you want to start new game? It will delete all your progress and Coins will reset.")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dbEdit = getSharedPreferences("DB", 0).edit();
                                    dbEdit.putInt("level", 1);
                                    dbEdit.putInt("substance", 400);
                                    dbEdit.putInt("current", 1);
                                    substance = db.getInt("substance", 400);
                                    substances.setText(String.valueOf(substance));
                                    dbEdit.apply();
                                    dialog.cancel();
                                    Intent splashintent = new Intent(getBaseContext(), started.class);
                                    startActivity(splashintent);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle(R.string.app_name);
                    alert.show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splashintent = new Intent(getBaseContext(), started.class);
                startActivity(splashintent);
            }
        });
        musicSvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    svc = new Intent(mainMenu.this, musicService.class);
                    stopService(svc);
                    i = 0;
                    dbEdit = getSharedPreferences("DB", 0).edit();
                    dbEdit.putInt("music", i);
                    dbEdit.apply();

                } else {
                    svc = new Intent(mainMenu.this, musicService.class);
                    startService(svc);
                    i = 1;
                    dbEdit = getSharedPreferences("DB", 0).edit();
                    dbEdit.putInt("music", i);
                    dbEdit.apply();
                }
            }
        });
/*        musicSvc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MediaPlayer.create(mainMenu.this, R.raw.up).start();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    MediaPlayer.create(mainMenu.this, R.raw.down).start();

                }
                return false;
            }
        });
 */       c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
  /*      //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        a.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    MediaPlayer.create(mainMenu.this,R.raw.up).start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {    a.setBackground(getDrawable(R.drawable.newgame2)); }
                    }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    MediaPlayer.create(mainMenu.this,R.raw.down).start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {a.setBackground(getDrawable(R.drawable.newgame1));       }
                }
                return false;
            }
        });
        b.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    player.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  b.setBackground(getDrawable(R.drawable.loadgame2));   }
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    player2.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { b.setBackground(getDrawable(R.drawable.loadgame1));          }
                }
                return false;
            }
        });
        c.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    player.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {c.setBackground(getDrawable(R.drawable.settings2)); }
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    player2.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  c.setBackground(getDrawable(R.drawable.settings1));      }
                }
                return false;
            }
        });
        d.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    player.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  d.setBackground(getDrawable(R.drawable.help2));      }
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    player2.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { d.setBackground(getDrawable(R.drawable.help1));     }
                }
                return false;
            }
        });
        e.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    player.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  e.setBackground(getDrawable(R.drawable.exit2));         }
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    player2.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {   e.setBackground(getDrawable(R.drawable.exit1));        }
                }
                return false;
            }
        });

    */
    }
  @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
        //    drawer.closeDrawer(GravityCompat.START);
        //} else {
    //    MediaPlayer.create(mainMenu.this,R.raw.up).start();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (!mBackKeyFlag) {
                Toast.makeText(this, "Touch Back key again to exit", Toast.LENGTH_SHORT).show();
                mBackKeyFlag = true;
                mHandler.sendEmptyMessageDelayed(0, 2000);
            } else {
                super.onBackPressed();
                finishAffinity();


            }
            //}
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
                                                                   
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public void onDestroy(){
        try {

            Intent  svc = new Intent(this, musicService.class);
            stopService(svc);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        super.onDestroy();
    }
   */
  @Override
    public void onPause(){
      super.onPause();
      try {

            Intent  svc = new Intent(this, musicService.class);
            stopService(svc);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}