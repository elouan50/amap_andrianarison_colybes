package com.ecn.amap;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.text.BreakIterator;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private CommandeViewModel commandeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commandeViewModel = new ViewModelProvider(this).get(CommandeViewModel.class);

        View selectDateButton = findViewById(R.id.button_new);
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Date livraison = new Date(dayOfMonth, monthOfYear, year);
                        Date today = new Date();
                        Commande commande = new Commande(today, livraison, 1);
                        int commande_id = commande.getCommmande_id();
                        commandeViewModel.insert(commande);
                        Toast.makeText(getApplicationContext(), "Nouvelle commande créée", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, SelectItem.class);
                        intent.putExtra("commande_id", commande_id);
                        startActivity(intent);
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }

}
