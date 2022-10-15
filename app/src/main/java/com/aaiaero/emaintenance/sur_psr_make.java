package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sur_psr_make extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_psr_make);
        Button ngosco, raytheon, selex, indra, eldis;

        ngosco = (Button) findViewById(R.id.ngosco);
        raytheon = (Button) findViewById(R.id.raytheon);
        selex = (Button) findViewById(R.id.selex);
        indra = (Button) findViewById(R.id.indra);
        eldis = (Button) findViewById(R.id.eldis);

        ngosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SurMssrNgoscoActivity.class);
                startActivity(intent);
            }
        });

        raytheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        selex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sur_psr_selex.class);
                startActivity(intent);

            }
        });

        indra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        eldis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
