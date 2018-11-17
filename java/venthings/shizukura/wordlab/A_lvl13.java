package venthings.shizukura.wordlab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static java.lang.Math.random;

public class A_lvl13 extends AppCompatActivity {
    public Button clear,lagy,umbit,hint,imageButton;
    public Button[] buttons;
    public String[] word;
    public int q,w,e1,r,t,y,u,i,o,level,substance,hintlvl;
    public TextView substances;
    public SharedPreferences.Editor dbEdit;
    public SharedPreferences db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.eight);
        //basahin maigi
        db = getSharedPreferences("DB",0);
        substance = db.getInt("substance",400);
        level = db.getInt("level",1);
        word = new String[]{"I","N","O","R","G","A","N","I","C"};
        imageButton = (Button)findViewById(R.id.imageButton);
        imageButton.setText("The central fundamental science.");
        hint = (Button)findViewById(R.id.hint);
        substances = (TextView)findViewById(R.id.textView4);
        substances.setText(String.valueOf(substance));
        buttons = new Button[]{
                (Button)findViewById(R.id.letter1),
                (Button)findViewById(R.id.letter2),
                (Button)findViewById(R.id.letter3),
                (Button)findViewById(R.id.letter4),
                (Button)findViewById(R.id.letter5),
                (Button)findViewById(R.id.letter6),
                (Button)findViewById(R.id.letter7),
                (Button)findViewById(R.id.letter8),
                (Button)findViewById(R.id.letter9),
                (Button)findViewById(R.id.letter10)
        };
        buttons[9].setVisibility(View.GONE);
        clear = (Button)findViewById(R.id.ear);
        lagy = (Button)findViewById(R.id.lagy);
        umbit = (Button)findViewById(R.id.umbit);
        hintlvl = 0;
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (substance < 25) {
                    Toast.makeText(A_lvl13.this, "Not enough substance to make a compound and form into a letter.", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(A_lvl13.this);
                    builder.setMessage("Use hint? Cost 25 Substances")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    hintlvl++;
                                    substance -= 25;
                                    dbEdit = getSharedPreferences("DB", 0).edit();
                                    dbEdit.putInt("substance", substance);
                                    substances.setText(String.valueOf(substance));
                                    dbEdit.apply();
                                    dialog.cancel();
                                    scramble();
                                    int lad = 0;
                                    switch (hintlvl) {
                                        case 1:
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("I");

                                            break;
                                        case 2:
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");

                                            lagy.setText("IN");
                                            break;
                                        case 3:
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INO");
                                            break;
                                        case 4:
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INOR");
                                            break;
                                        case 5:

                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "G"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INORG");
                                            break;
                                        case 6:

                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "G"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "A"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INORGA");
                                            break;
                                        case 7:
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "G"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "A"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INORGAN");
                                            break;
                                        case 8:

                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "G"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "A"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INORGANI");
                                            break;
                                        case 9:

                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "O"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "R"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "G"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "A"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "N"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "I"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lad = 0;
                                            while(buttons[lad].getText() != "C"){
                                                lad++;
                                            }
                                            buttons[lad].setText("");
                                            lagy.setText("INORGANIC");
                                            break;
                                        default:
                                            scramble();
                                            Toast.makeText(A_lvl13.this, "All hints are used!", Toast.LENGTH_SHORT).show();
                                    }
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

        scramble();
        lagy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lagy.getText() != "") {
                    int numWhile = 0;
                    while(buttons[numWhile].getText() != ""){
                        numWhile += 1;
                    }
                    String string = lagy.getText().toString();
                    buttons[numWhile].setText(string.substring(string.length()-1, string.length()));
                    lagy.setText(string.substring(0, string.length() - 1));
                }
            }
        });
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[0].getText().toString();
                lagy.setText(nam);
                buttons[0].setText("");
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[1].getText().toString();
                lagy.setText(nam);
                buttons[1].setText("");
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[2].getText().toString();
                lagy.setText(nam);
                buttons[2].setText("");
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[3].getText().toString();
                lagy.setText(nam);
                buttons[3].setText("");
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[4].getText().toString();
                lagy.setText(nam);
                buttons[4].setText("");
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[5].getText().toString();
                lagy.setText(nam);
                buttons[5].setText("");
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[6].getText().toString();
                lagy.setText(nam);
                buttons[6].setText("");
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[7].getText().toString();
                lagy.setText(nam);
                buttons[7].setText("");
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = lagy.getText().toString() + buttons[8].getText().toString();
                lagy.setText(nam);
                buttons[8].setText("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scramble();
            }
        });

        umbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(lagy.getText().toString(), "INORGANIC")){
                    Toast.makeText(A_lvl13.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                    scramble();
                    try {
                        dbEdit = getSharedPreferences("DB",0).edit();
                        if(level ==13){
                            dbEdit.putInt("level",14);
                            dbEdit.putInt("substance",substance+25);
                            dbEdit.putInt("reward",25);
                        }
                        else{
                            dbEdit.putInt("substance",substance+5);

                            dbEdit.putInt("reward",5);
                        }
                        dbEdit.putInt("current",13);
                        dbEdit.apply();
                        Intent intent = new Intent(A_lvl13.this,dialog.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }   else{
                    Toast.makeText(A_lvl13.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    scramble();
                }
            }
        });
    }
    public void scramble(){
        try {
            q = (int) (10 * random());
            while (q >= 9)
            {
                q = (int) (10 * random());
            }
            w = (int) (10 * random());
            while (w >= 9 || w == q)
            {
                w = (int) (10 * random());
            }

            e1 = (int) (10 * random());
            while (e1 >= 9 || e1 == q || e1 == w)
            {
                e1 = (int) (10 * random());
            }

            r = (int) (10 * random());
            while (r >= 9 || r == q || r == w || r == e1)
            {
                r = (int) (10 * random());
            }

            t = (int) (10 * random());
            while (t >= 9 || t == q || t == w || t == r || t == e1){
                t = (int) (10 * random());
            }

            y = (int) (10 * random());
            while (y >= 9 || y == q || y == w || y == r || y == e1 || y == t){
                y = (int) (10 * random());
            }
            u = (int) (10 * random());
            while (u >= 9 || u == q || u == w || u == r || u == e1 || u == t || u == y){
                u = (int) (10 * random());
            }

            i = (int) (10 * random());
            while (i >= 9 || i == q || i == w || i == r || i == e1 || i == t || i == y || i == u){
                i = (int) (10 * random());
            }
            o = (int) (10 * random());
            while (o >= 9 || o == q || o == w || o == r || o == e1 || o == t || o == y || o == u || o == i){
                o = (int) (10 * random());
            }
            lagy.setText("");
            buttons[0].setText(word[q]);
            buttons[1].setText(word[w]);
            buttons[2].setText(word[e1]);
            buttons[3].setText(word[r]);
            buttons[4].setText(word[t]);
            buttons[5].setText(word[y]);
            buttons[6].setText(word[u]);
            buttons[7].setText(word[i]);
            buttons[8].setText(word[o]);
        }catch (Exception e2){
            e2.printStackTrace();
            //scramble();
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
        if(hintlvl != 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(A_lvl13.this);
            builder.setMessage("If you quit now, the hint/s you've used will be discarded. Continue?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent c = new Intent(A_lvl13.this, started.class);
                            startActivity(c);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("WordLab");
            alert.show();
        }
        else {
            Intent c = new Intent(A_lvl13.this, started.class);
            startActivity(c);
            finish();
        }
    }
}
