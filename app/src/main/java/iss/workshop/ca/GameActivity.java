package iss.workshop.ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    ArrayList<String> imgSelectedUrl;
    private static final int imgForGame = 6;

//    TextView timerText;
//    boolean timerStarted = false;
//    long startTime = 0;
//    static long millis;
//    static long finalTime;
//    static int seconds;
//    static int minutes;
//    Handler timerHandler = new Handler();
//    Runnable timerRunnable = new Runnable() {
//        @Override
//        public void run() {
//            millis = 0;
//            finalTime = 0;
//            seconds = 0;
//            minutes = 0;
//
//            millis = System.currentTimeMillis() - startTime;
//            seconds = (int) (millis / 1000);
//            minutes = seconds / 60;
//            seconds = seconds % 60;
//
//            timerText.setText(String.format("Time taken %d:%02d", minutes, seconds));
//            timerHandler.postDelayed(this, 500);
//        }
//    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //get the selected 6 pics
        Intent intent = getIntent();
        imgSelectedUrl = intent.getStringArrayListExtra("imgSelectedUrl");
        setContentView(R.layout.activity_game);

//        for (String imgurl : imgSelectedUrl) {
//            try {
//                URL url = new URL(imgurl);
//                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        Chronometer timerChronometer;
        timerChronometer = (Chronometer)findViewById(R.id.chronometer);
        timerChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                cArg.setText(hh+":"+mm+":"+ss);
            }
        });
        timerChronometer.setBase(SystemClock.elapsedRealtime());
        timerChronometer.start();

    }

    @Override
    protected void onStart() {
        super.onStart();

//        timerText = findViewById(R.id.txt_timing);
//        startTime = System.currentTimeMillis();
//        timerHandler.postDelayed(timerRunnable, 0);


    }

}