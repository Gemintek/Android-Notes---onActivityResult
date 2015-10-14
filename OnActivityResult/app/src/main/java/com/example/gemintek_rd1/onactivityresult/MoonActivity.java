package com.example.gemintek_rd1.onactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon);

        Intent EarthIntent = getIntent();
        String EarthMessage = EarthIntent.getStringExtra("FromEarth");

        TextView textView = (TextView) findViewById(R.id.moonTextView);
        textView.setText(EarthMessage);

        Button toEarthButton = (Button) findViewById(R.id.moonToEarthButton);

        toEarthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MoonActivity.this, MainActivity.class);
                String moonMessage = "Moons: I am from Moon. Back to the Earth";
                intent.putExtra("FromMoon", moonMessage);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
