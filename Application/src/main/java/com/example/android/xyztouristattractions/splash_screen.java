package com.example.android.xyztouristattractions;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.xyztouristattractions.ui.AttractionListActivity;

import java.util.List;
import java.util.Locale;

public class splash_screen extends AppCompatActivity {

    private TextToSpeech tts;
    private SpeechRecognizer speechRecognizer;
    private static final int MY_PERMISSIONS_REQUEST_GET_ACCOUNTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getPermissions();
        initialtextToSpeech();
        initialspeechRecognizer();
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                speechRecognizer.startListening(intent);

            }
        });



    }

    private void initialspeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this))
        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                List<String> result=results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                progressResult(result.get(0));
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }

    private void progressResult(String username) {


            speak("Hi"+ username +  "please tell me, your location ");
            Intent i=new Intent(splash_screen.this,AttractionListActivity.class);
            startActivity(i);
            finish();

    }

    private void initialtextToSpeech() {
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {


            @Override
            public void onInit(int status) {
                if(tts.getEngines().size()==0)
                {
                    Toast.makeText(splash_screen.this,"No Engine",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    tts.setLanguage(new Locale("en", "IN"));
                    speak("Hello,Friends I am Your Tourist Guide ,Can You Tell Me your Name?");

                }
            }
        });
    }

    private void speak(String s) {
        if(Build.VERSION.SDK_INT>=21)
        {
            tts.speak(s,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else {
            tts.speak(s,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
    public void getPermissions() {
        /* Check and Request permission */
        if (ContextCompat.checkSelfPermission(splash_screen.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(splash_screen.this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    MY_PERMISSIONS_REQUEST_GET_ACCOUNTS);
        }
    }
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_GET_ACCOUNTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission..
                    Toast.makeText(splash_screen.this, "Permission denied to get Account", Toast.LENGTH_SHORT).show();

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}


