package com.ecn.amap;


import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PackageManagerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectItem extends AppCompatActivity {
    private CommandeViewModel commandeViewModel;
    private String commande_id;
    private static final int TEXT_REQUEST = 1;
    private static final int REQUEST_CODE_DATE_PICKER = 2;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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
