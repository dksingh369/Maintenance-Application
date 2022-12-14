package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DmeThalesActivity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_thales);

        setTitle("THALES DME  Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);
        fortnightly = (Button) findViewById(R.id.fortnightly);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        halfYearly = (Button) findViewById(R.id.halfYearly);
        yearly = (Button) findViewById(R.id.yearly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435WeeklyActivity.class);
        startActivity(intent);


    }

    public void fortnightlyClicked (View view){
        // Launch the DATISEquipment Room Activity



    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435MonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){




    }

    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435SixMonthlyActivity.class);
        startActivity(intent);

    }

    public void yearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435AnnualActivity.class);
        startActivity(intent);



    }

    public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}