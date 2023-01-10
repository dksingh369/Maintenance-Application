package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GpMakeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_make_model);

        Button normarc70, normarc35, asii, thales, indra70;

        normarc70 = (Button) findViewById(R.id.normarc70);
        normarc35 = (Button) findViewById(R.id.normarc35);
        asii = (Button) findViewById(R.id.asii);
        thales = (Button) findViewById(R.id.thales);
        indra70 = (Button) findViewById(R.id.indra70);

        normarc70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Intent intent = new Intent(getApplicationContext(), NavigationLlzNormarc7000Activity.class);
                // startActivity(intent);
            }
        });

        normarc35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        asii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
                //startActivity(intent);
            }
        });

        thales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavigationGpThales420Activity.class);
                startActivity(intent);

            }
        });
        indra70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavigationGpIndra70Activity.class);
                startActivity(intent);

            }
        });
    }
}