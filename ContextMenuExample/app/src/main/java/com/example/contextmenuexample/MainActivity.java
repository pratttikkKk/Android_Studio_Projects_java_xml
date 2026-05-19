package com.example.contextmenuexample;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.text1);

        registerForContextMenu(t);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("Press");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Toast.makeText(this,
                "Pressed",
                Toast.LENGTH_SHORT).show();

        return true;
    }
}