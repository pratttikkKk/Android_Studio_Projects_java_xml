package com.example.social_media_calljava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnWhatsApp, btnInstagram, btnFacebook, btnTwitter, btnYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWhatsApp = findViewById(R.id.btnWhatsApp);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnTwitter = findViewById(R.id.btnTwitter);
        btnYouTube = findViewById(R.id.btnYouTube);

        btnWhatsApp.setOnClickListener(v ->
                openApp("com.whatsapp"));

        btnInstagram.setOnClickListener(v ->
                openApp("com.instagram.android"));

        btnFacebook.setOnClickListener(v ->
                openApp("com.facebook.katana"));

        btnTwitter.setOnClickListener(v ->
                openApp("com.twitter.android"));

        btnYouTube.setOnClickListener(v ->
                openApp("com.google.android.youtube"));
    }

    private void openApp(String packageName) {

        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);

        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this,
                    "App not installed. Opening Play Store...",
                    Toast.LENGTH_SHORT).show();

            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + packageName)));
            } catch (Exception e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
            }
        }
    }
}
