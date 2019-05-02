package com.example.mehmet.cafemmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread mSplashThread;//tahread classdan obje olustrduk uygulmann 4 saniye uyutulmasi icin
        mSplashThread = new Thread(){
            @Override public void run(){
                try {

                    synchronized(this){
                        wait(2500);
                    }
                }catch(InterruptedException ex){

                }
                finally{

                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };//thread objesini olustrduk ve istedmz sekilde sekillendrdik
        mSplashThread.start();// thread objesini calistriyoruz

    }
}
