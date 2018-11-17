package venthings.shizukura.wordlab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.opengl.Visibility;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import pl.droidsonroids.gif.*;

public class started extends AppCompatActivity {
    public Button s,lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,lvl8,lvl9;
    public SharedPreferences.Editor dbEdit;
    GifTextView[] lvl;
    public SharedPreferences db;
    int level,levelOrig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade,R.anim.fade_out);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_started);

        lvl = new GifTextView[]{
                (GifTextView)findViewById(R.id.lvl101),
                (GifTextView)findViewById(R.id.lvl102),
                (GifTextView)findViewById(R.id.lvl103),
                (GifTextView)findViewById(R.id.lvl104),
                (GifTextView)findViewById(R.id.lvl105),
                (GifTextView)findViewById(R.id.lvl106),
                (GifTextView)findViewById(R.id.lvl107),
                (GifTextView)findViewById(R.id.lvl108),
                (GifTextView)findViewById(R.id.lvl109),
                (GifTextView)findViewById(R.id.lvl110),
                (GifTextView)findViewById(R.id.lvl111),
                (GifTextView)findViewById(R.id.lvl112),
                (GifTextView)findViewById(R.id.lvl113),
                (GifTextView)findViewById(R.id.lvl114),
                (GifTextView)findViewById(R.id.lvl115),
                (GifTextView)findViewById(R.id.lvl116),

        };
        levelOrig = 0;
        db = getSharedPreferences("DB",0);
        level = db.getInt("level",1);
        iloloading();
        /*
        lvl1 = (Button)findViewById(R.id.lvl101);
        lvl2 = (Button)findViewById(R.id.lvl102);
        lvl3 = (Button)findViewById(R.id.lvl103);
        lvl4 = (Button)findViewById(R.id.lvl104);
        lvl5 = (Button)findViewById(R.id.lvl105);
        lvl6 = (Button)findViewById(R.id.lvl106);
        lvl7 = (Button)findViewById(R.id.lvl107);
        lvl8 = (Button)findViewById(R.id.lvl108);
        lvl9 = (Button)findViewById(R.id.lvl109);
        */
   //     if(lvl[0].getText() != ""){
        lvl[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent a = new Intent(started.this, A_lvl1.class);
                    startActivity(a);
                    finish();

            }
        });//        }
          //  if(lvl[1].getText() != "") {
                lvl[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(lvl[1].getVisibility() == View.VISIBLE) {
                            Intent b = new Intent(started.this, A_lvl2.class);
                            startActivity(b);
                            finish();
                        }
                    }
                });
        //    }
    //        if(lvl[2].getText() != "") {
        lvl[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[2].getVisibility() == View.VISIBLE) {
                    Intent c = new Intent(started.this, A_lvl3.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[3].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl4.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[4].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl5.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[5].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl6.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[6].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl7.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[7].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl8.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[8].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl9.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[9].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl10.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[10].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl11.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[11].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl12.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[12].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl13.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[13].getVisibility() != View.INVISIBLE) {
                    Intent c = new Intent(started.this, A_lvl14.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[14].getVisibility() == View.VISIBLE) {
                    Intent c = new Intent(started.this, A_lvl15.class);
                    startActivity(c);
                    finish();
                }
            }
        });
        lvl[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lvl[15].getVisibility() == View.VISIBLE) {
                    Intent c = new Intent(started.this, A_lvl16.class);
                    startActivity(c);
                    finish();
                }
            }
        });

      //      }
        iloloading();
    }

    public void iloloading(){
        if(level <=16){
        while(level != levelOrig) {
            lvl[levelOrig].setVisibility(View.VISIBLE);
            lvl[levelOrig].setText(String.valueOf(levelOrig+1));
            lvl[levelOrig].setEnabled(true);
            levelOrig++;
        }
        }
    }
    @Override
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
    @Override
    public void onPause(){
        try {

            Intent  svc = new Intent(this, musicService.class);
            stopService(svc);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        super.onPause();
    }
    @Override
    public void onBackPressed() {
        Intent c = new Intent(started.this, mainMenu.class);
        startActivity(c);
        finish();
    }
}
