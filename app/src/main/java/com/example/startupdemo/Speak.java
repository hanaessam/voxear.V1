package com.example.startupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

public class Speak extends AppCompatActivity {
    private TextToSpeech mTTS;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);
        mButtonSpeak = findViewById(R.id.speak_btn);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int res = mTTS.setLanguage(Locale.ENGLISH);
                    if(res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                    } else {
                       mButtonSpeak.setEnabled(true);
                    }
                }else{
                    Log.e("TTS", "Initialization failed");

                }
            }
        });

        mEditText = findViewById(R.id.textToSpeech);
        mSeekBarPitch = findViewById(R.id.seekbar_pitch);
        mSeekBarSpeed = findViewById(R.id.seekbar_speed);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
    }

    private void speak(){
        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress()/50;
        if(pitch < 0.1 )
            pitch = 0.1f;

        float speed = (float) mSeekBarSpeed.getProgress()/50;
        if(speed < 0.1 )
            speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {
        if(mTTS!= null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
}