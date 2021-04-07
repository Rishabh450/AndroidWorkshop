package com.pcon.androidworkshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cli = findViewById(R.id.open_browser);
        String ids = String.valueOf(R.id.open_browser);
        Log.d("TEXT", ids  );
        String x = null;
      // Log.d("TEXT",x);
        Log.d("TEXT","worked");




        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //explicit intent
                Intent intent = new Intent(MainActivity.this, WebViewer.class);
                startActivity(intent);

            }
        });
    }
}