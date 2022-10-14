package com.davtyan.lights;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TestSurfaceView lights;
    static final String TAG = "LIGHTS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lights = new TestSurfaceView(this);
        setContentView(lights);
    }

    @Override
    protected void onPause() {
        super.onPause();
        lights.pause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lights.resume();
        Log.i(TAG, "onPause");
    }


}