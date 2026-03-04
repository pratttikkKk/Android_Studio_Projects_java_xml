package com.example.adesh.tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Todo: Main Page UI
// Todo: Game UI
//Todo: Add Restart button
//Todo: Add score in Multiplayer

public class MainActivity extends Activity {
    private Button Singleplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singleplayer = (Button)findViewById(R.id.Singleplayer);
        Singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleplayerClick();
            }
        });
    }
    public void singleplayerClick()
    {
        Intent intent = new Intent(this, Singleplayer.class);
        startActivity(intent);
    }
    public void multiplayerClick(View view)
    {
        Intent intent = new Intent(this, Multiplayer.class);
        startActivity(intent);
    }

}