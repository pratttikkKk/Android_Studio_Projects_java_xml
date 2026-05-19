package com.example.implicitintentexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b= findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                 Toast.makeText(MainActivity.this,"Opening Browser......",Toast.LENGTH_SHORT).show();
                 Intent i = new Intent(Intent.ACTION_DIAL);
                 i.setData(Uri.parse("tel:9356121442"));
                 startActivity(i);
             }
        });
    }
}