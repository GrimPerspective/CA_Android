package iss.workshop.ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    ArrayList<String> imgSelectedUrl;
    private static final int imgForGame = 6;

    TextView timerText;
    boolean timerStarted = false;
    Double time = 0.0;
    TimerTask timerTask;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        timerText = (TextView)findViewById(R.id.txt_timing);
//
//        timer = new Timer();
//
//        private void startTime(){
//            timer = new TimerTask() {
//                @Override
//                public void run() {
//                    time++;
//                    timerText.setText(getTimerText);
//                }
//            };
//        }
//
//        private String getTimerText(){
//            int rounded = (int) Math.round(time);
//            int seconds = ((rounded % 86400) % 3600 % 60);
//            int minutes = ((rounded % 86400) % 3600 / 60);
//            int hours = ((rounded % 86400) / 3600);
//            return formatTime(seconds, minutes, hours);
//        }
//
//        private String formatTime(int seconds, int minutes, int hours)



        //get the selected 6 pics
        Intent intent = getIntent();
        imgSelectedUrl = intent.getStringArrayListExtra("imgSelectedUrl");

        for(String imgurl : imgSelectedUrl) {
            try {
                URL url= new URL(imgurl);
                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        setContentView(R.layout.activity_game);
    }
}