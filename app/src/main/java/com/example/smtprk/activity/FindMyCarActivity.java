package com.example.smtprk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.smtprk.R;

public class FindMyCarActivity extends Activity {
    private ImageView slot1;
    private ImageView slot2;
    private ImageView logoSlot1;
    private ImageView logoSlot2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_my_car);

        slot1 = (ImageView) findViewById(R.id.KKMSlot1);
        slot2 = (ImageView) findViewById(R.id.KKMSlot2);
        logoSlot1 = (ImageView) findViewById(R.id.ivLogoSlot1);
        logoSlot2 = (ImageView) findViewById(R.id.ivLogoSlot2);


        slot1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        NMap.class);
                startActivity(i);
                finish();
            }
        });


        slot2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        NMap.class);
                startActivity(i);
                finish();
            }
        });
    }
}