   package venthings.shizukura.wordlab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

   /**
 * Created by Steven Dale Lucero on 03/07/2018.
 */

public class dialog extends AppCompatActivity {
    public Button retry, mainulit,nexting;
    public SharedPreferences.Editor dbEdit;
    public SharedPreferences db;
    public Intent[] intents;
    int current, reward;
    Button reward_text, lvlcomp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.dialog1);
        intents = new Intent[]{
                new Intent(dialog.this, A_lvl1.class),
                new Intent(dialog.this, A_lvl2.class),
                new Intent(dialog.this, A_lvl3.class),
                new Intent(dialog.this, A_lvl4.class),
                new Intent(dialog.this, A_lvl5.class),
                new Intent(dialog.this, A_lvl6.class),
                new Intent(dialog.this, A_lvl7.class),
                new Intent(dialog.this, A_lvl8.class),
                new Intent(dialog.this, A_lvl9.class),
                new Intent(dialog.this, A_lvl10.class),
                new Intent(dialog.this, A_lvl11.class),
                new Intent(dialog.this, A_lvl12.class),
                new Intent(dialog.this, A_lvl13.class),
                new Intent(dialog.this, A_lvl14.class),
                new Intent(dialog.this, A_lvl15.class),
                new Intent(dialog.this, A_lvl16.class)
        };
        reward_text = (Button)findViewById(R.id.pedoy);
        lvlcomp = findViewById(R.id.lvlcomp);
        retry = (Button)findViewById(R.id.retry);
        nexting = (Button)findViewById(R.id.nexting);
        mainulit = (Button)findViewById(R.id.menuulit);

        db = getSharedPreferences("DB",0);
        current = (db.getInt("current",1));
        reward = db.getInt("reward",25);
        reward_text.setText("Coins  +"+String.valueOf(reward));
        lvlcomp.setText("Level "+current+" Completed!");
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intents[current-1]);
                finish();
            }
        });
        mainulit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent dsadsa = new Intent(dialog.this, mainMenu.class);
                    startActivity(dsadsa);
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        nexting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current != 16){
                startActivity(intents[current]);
                finish();            }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
                    builder.setMessage("All levels are completed! more levels to come!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent c = new Intent(dialog.this, mainMenu.class);
                                    startActivity(c);
                                    finish();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle(R.string.app_name);
                    alert.show();
                }
            }
        });
        }
    @Override
    public void onBackPressed() {
        Intent c = new Intent(dialog.this, started.class);
        startActivity(c);
        finish();
    }
       @Override
       public void onPause(){
           Intent  svc = new Intent(this, musicService.class);
           stopService(svc);
           super.onPause();
       }
    }