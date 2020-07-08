package com.example.splashviewdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);


         setContentView(R.layout.activity_splash_screen);

        inOne();

    }
    public void inOne(){
        progressBar = findViewById(R.id.progressbarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    progress();
                    mainActivity();
            }
        });
        thread.start();
    }


    public void progress(){
        for(pro = 1; pro<=500; pro++){
            try {
                Thread.sleep(50);
                progressBar.setProgress(pro);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mainActivity(){

        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();


    }


}
