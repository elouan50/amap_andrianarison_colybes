package com.ecn.amap;


import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectItem extends AppCompatActivity {
    private static final int TEXT_REQUEST = 1;
    private static final int REQUEST_CODE_DATE_PICKER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Date livraison = new Date();
        Date today = new Date();

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_DATE_PICKER) {
            String selectedDate = data.getStringExtra("selected_date");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                livraison = dateFormat.parse(selectedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Commande commande = new Commande(today, livraison, 1);
        int commande_id = commande.getCommmande_id();
        System.out.println(commande_id);
    }

    @SuppressLint("RestrictedApi")
    public void launchFruits(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SelectFruit.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}
