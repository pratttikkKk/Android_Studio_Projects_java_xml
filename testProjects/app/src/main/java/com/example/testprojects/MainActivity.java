package com.example.testprojects;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
ListView lv;
String fruits[] = {"Apple", "Mango", "Banana", "Grapes", "Orange","Apple", "Mango", "Banana", "Grapes", "Orange","Apple", "Mango", "Banana", "Grapes", "Orange","Apple", "Mango", "Banana", "Grapes", "Orange","Apple", "Mango", "Banana", "Grapes", "Orange"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listview1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fruits);

        lv.setAdapter(adapter);
//        lv.setOnItemClickListener()
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Toast.makeText(MainActivity.this,
                        fruits[position],
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}