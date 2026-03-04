package com.example.frame_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout page1, page2;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ACTIVITY", "onCreate called");

        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        btnNext.setOnClickListener(v -> {
            page1.setVisibility(View.GONE);
            page2.setVisibility(View.VISIBLE);
        });

        btnBack.setOnClickListener(v -> {
            page2.setVisibility(View.GONE);
            page1.setVisibility(View.VISIBLE);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ACTIVITY", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ACTIVITY", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ACTIVITY", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ACTIVITY", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ACTIVITY", "onDestroy");
    }
}
