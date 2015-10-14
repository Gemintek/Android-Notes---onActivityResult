package com.example.gemintek_rd1.onactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars);

        Intent EarthIntent = getIntent();
        Bundle bundle = EarthIntent.getExtras();
        String EarthMessage = bundle.getString("FromEarth");

        TextView textView = (TextView) findViewById(R.id.marsTextView);
        textView.setText(EarthMessage);

        Button toEarthButton = (Button) findViewById(R.id.marsToEarthButton);

        toEarthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarsActivity.this, MainActivity.class);
                String marsMessage = "Mars: I am from Mars. Back to the Earth";
                intent.putExtra("FromMars", marsMessage);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
