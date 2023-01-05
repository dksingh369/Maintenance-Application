package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class AmssActivity extends AppCompatActivity {

    Button ecil, others, IpAmssInhouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amss);

        setTitle("AMSS Components");

        ecil = (Button) findViewById(R.id.ecil);
        others = (Button) findViewById(R.id.others1);

        IpAmssInhouse = (Button) findViewById(R.id.IpAmssInhouse);

        Intent intent = getIntent();

            }

    public void ecilClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AmssEcilActivity.class);
        startActivity(intent);

    }


    public void othersClicked (View view){
        // Launch the Others Equipment Room Activity

    }
    public void IpAmssInhouseClicked (View view) {

        Intent intent = new Intent(getApplicationContext(), AmssIpInhouseActivity.class);
        startActivity(intent);
    }

}