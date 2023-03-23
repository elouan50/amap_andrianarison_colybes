package com.ecn.amap;


import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SelectItem extends AppCompatActivity {
    private static final int TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);
    }

    @SuppressLint("RestrictedApi")
    public void launchFruits(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SelectFruit.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @SuppressLint("RestrictedApi")
    public void launchMainActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}
