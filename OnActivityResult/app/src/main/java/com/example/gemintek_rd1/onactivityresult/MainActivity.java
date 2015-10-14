package com.example.gemintek_rd1.onactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button flyToMarsButton = null;
    private Button flyToMoonButton = null;

    private static final int MarsRequestCode = 0;
    private static final int MoonRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flyToMarsButton = (Button) findViewById(R.id.toMarsButton);
        flyToMoonButton = (Button) findViewById(R.id.toMoonButton);

        flyToMarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MarsActivity.class);
                String content = "Earth: Hi, I am from Earth.  Going to Mars";
                Bundle bundle = new Bundle();
                bundle.putString("FromEarth", content);
                intent.putExtras(bundle);
                startActivityForResult(intent, MarsRequestCode);
            }
        });

        flyToMoonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MoonActivity.class);
                String content = "Earth: Hi, I am from Earth.  Going to Moon";
                Bundle bundle = new Bundle();
                bundle.putString("FromEarth", content);
                intent.putExtras(bundle);
                startActivityForResult(intent, MoonRequestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView text = (TextView) findViewById(R.id.earthTextView);

        switch(requestCode)
        {
            case MarsRequestCode:

                Bundle bundle = data.getExtras();
                String marsMessage = bundle.getString("FromMars");
                text.setText(marsMessage);

                break;

            case MoonRequestCode:

                Bundle moonBundle = data.getExtras();
                String moonMessage = moonBundle.getString("FromMoon");
                text.setText(moonMessage);

                break;
        }
    }
}
