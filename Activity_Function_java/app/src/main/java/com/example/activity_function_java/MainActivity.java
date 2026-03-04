package com.example.activity_function_java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LIFECYCLE", "onCreate called");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        btnClick = findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();                                //Called when Activity becomes visible.
        Log.d("LIFECYCLE", "onStart called");
    }

    @Override
    protected void onResume() {                    //Called when Activity becomes interactive.
        super.onResume();
        Log.d("LIFECYCLE", "onResume called");
    }

    @Override
    protected void onPause() {                 //Called when:  Another app opens  You press home button


        super.onPause();
        Log.d("LIFECYCLE", "onPause called");
    }

    @Override
    protected void onStop() {                            //Activity is no longer visible.
        super.onStop();
        Log.d("LIFECYCLE", "onStop called");
    }

    @Override
    protected void onRestart() {                                   //Called when returning to app after stop.
        super.onRestart();
        Log.d("LIFECYCLE", "onRestart called");
    }

    @Override
    protected void onDestroy() {                                         //Called when returning to app after stop.
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy called");
    }
}
