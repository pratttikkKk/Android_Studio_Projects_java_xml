package com.example.optionmenuexample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.item1) {

            Toast.makeText(this,
                    "About Selected",
                    Toast.LENGTH_SHORT).show();

        }

        else if(item.getItemId() == R.id.item2) {

            Toast.makeText(this,
                    "Logout Selected",
                    Toast.LENGTH_SHORT).show();

        }

        return true;
    }
}