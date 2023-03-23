package com.ecn.amap;


import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class SelectFruit extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private int mCount2 = 0;
    private TextView mShowCount2;
    private ContientFruitViewModel contientFruitViewModel;
    private static final int TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_fruit);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mShowCount2 = (TextView) findViewById(R.id.show_count2);
        contientFruitViewModel = new ViewModelProvider(this).get(ContientFruitViewModel.class);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void countDown(View view) {
        mCount--;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void countUp2(View view) {
        mCount2++;
        if (mShowCount2 != null) {
            mShowCount2.setText(Integer.toString(mCount2));
        }
    }

    public void countDown2(View view) {
        mCount2--;
        if (mShowCount2 != null) {
            mShowCount2.setText(Integer.toString(mCount2));
        }
    }

    @SuppressLint("RestrictedApi")
    public void launchItem(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent data = getIntent();
        String commande_id = data.getStringExtra(SelectItem.EXTRA_ITEM);
        int c_id = Integer.parseInt(commande_id);
        ContientFruit contientFruit = new ContientFruit(c_id, 1, mCount);
        contientFruitViewModel.insert(contientFruit);
        Toast.makeText(getApplicationContext(), "Ajout des paniers de fruits", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, SelectItem.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}