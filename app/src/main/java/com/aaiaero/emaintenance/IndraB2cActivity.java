package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class IndraB2cActivity extends AppCompatActivity {

    Button daily, ups15kva, ups5kva, monthly, quarterly, drfneptunorecordingcheck, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indra_b2c);

        setTitle("Automation INDRA B2/C Maintenance");

        daily = (Button) findViewById(R.id.daily);
        ups15kva = (Button) findViewById(R.id.ups15kva);
        ups5kva = (Button) findViewById(R.id.ups5kva);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        drfneptunorecordingcheck = (Button) findViewById(R.id.drfneptunorecordingcheck);
        yearly = (Button) findViewById(R.id.yearly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){
        // Launch the VHF Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),AutomationIndraB2cDaily.class);
        startActivity(intent);


    }

    public void ups15kvaClicked (View view){
        // Launch the DVR Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),AutomationIndraB2cUPS15KVA.class);
        startActivity(intent);


    }

    public void ups5kvaClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AutomationUPS5kvaDailyActivity.class);
        startActivity(intent);

    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AutomationIndraB2cMonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AutomationIndraB2cQuarterlyActivity.class);
        startActivity(intent);


    }

    public void drfneptunorecordingcheckClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AutomationDrfNeptunoRecordingCheck.class);
        startActivity(intent);

    }

    public void yearlyClicked (View view){
        // Launch the ADSB Equipment Room Activity
        //Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
        //startActivity(intent);



    }

    public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}