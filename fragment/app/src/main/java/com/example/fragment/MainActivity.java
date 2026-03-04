package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button btnSwitch;
    boolean isFirstFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LIFECYCLE", "onCreate");

        btnSwitch = findViewById(R.id.btnSwitch);

        // Load First Fragment Initially
        loadFragment(new FirstFragment());

        btnSwitch.setOnClickListener(v -> {
            if (isFirstFragment) {
                loadFragment(new SecondFragment());
            } else {
                loadFragment(new FirstFragment());
            }
            isFirstFragment = !isFirstFragment;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // ===============================
    // FIRST FRAGMENT
    // ===============================
    public static class FirstFragment extends Fragment {

        @Override
        public View onCreateView(android.view.LayoutInflater inflater,
                                 android.view.ViewGroup container,
                                 Bundle savedInstanceState) {

            Log.d("FRAGMENT", "FirstFragment Created");

            TextView textView = new TextView(getContext());
            textView.setText("This is First Fragment");
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(0xFFE3F2FD);

            return textView;
        }
    }

    // ===============================
    // SECOND FRAGMENT
    // ===============================
    public static class SecondFragment extends Fragment {

        @Override
        public View onCreateView(android.view.LayoutInflater inflater,
                                 android.view.ViewGroup container,
                                 Bundle savedInstanceState) {

            Log.d("FRAGMENT", "SecondFragment Created");

            TextView textView = new TextView(getContext());
            textView.setText("This is Second Fragment");
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(0xFFFFCDD2);

            return textView;
        }
    }

    // Activity Lifecycle Logs
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy");
    }
}
