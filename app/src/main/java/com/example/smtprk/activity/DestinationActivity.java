package com.example.smtprk.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smtprk.R;

public class DestinationActivity extends Activity {

    private ImageButton KKM;
    private ImageButton S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        S = (ImageButton) findViewById(R.id.ImgBtnS);
        KKM = (ImageButton) findViewById(R.id.ImgBtnKKM);

        S.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(DestinationActivity.this, NMap.class);
                startActivity(intent);
                finish();
            }
        });
        KKM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(DestinationActivity.this, NMap.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
