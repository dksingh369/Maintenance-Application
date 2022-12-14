package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    private DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
                int itemID = -1;
                //String a = "a", b="b", c="c";
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    //Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    //Cursor data1 = mDatabaseHelper.getCompleteItem(itemID);
                    String[] receivedData = mDatabaseHelper.getCompleteItem(itemID);
                    //String completeItem = mDatabaseHelper.getCompleteItem(itemID);
                    //Log.d(TAG, "onItemClick: The ID is: " + a);

                    //int day = 4;
                    Intent editScreenIntent;
                    switch (receivedData[1]) {


                        case "NavAidsDMESELEX1118Aand1119ADailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMESELEX1118Aand1119ADailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VHFDVRRETIADailyRecordingActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, VHFDVRRETIADailyRecordingActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORSELEX1150HalfYearlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORSELEX1150HalfYearlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORSELEX1150YearlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORSELEX1150YearlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORSELEX1150QuarterlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this,NavAidsDVORSELEX1150QuarterlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORSELEX1150WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this,NavAidsDVORSELEX1150WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORSELEX1150DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this,NavAidsDVORSELEX1150DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORThales432AnnualActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432AnnualActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORThales432MonthlyAnnex1Activity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432MonthlyAnnex1Activity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORThales432WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORGcel755MonthlyGroundChecksActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755MonthlyGroundChecksActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VHFDVRRETIADailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, VHFDVRRETIADailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORASII1150DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORASII1150DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORThales432MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORThales432SixMonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORThales432QuarterlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432QuarterlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORThales432DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORThales432DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEASII1118and1119QuarterlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEASII1118and1119QuarterlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEASII1118and1119MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEASII1118and1119MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEASII1118and1119WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEASII1118and1119WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEASII1118and1119DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEASII1118and1119DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORASII1150SixMonthlyVSWRActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORASII1150SixMonthlyVSWRActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORASII1150SixMonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORASII1150SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "SurvADSBComsoftDailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, SurvADSBComsoftDailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORASII1150WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORASII1150WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsNDBSAC100QuarterlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsNDBSAC100QuarterlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsNDBSAC100MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsNDBSAC100MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;




                       case "NavAidsNDBSAC100WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsNDBSAC100WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsNDBSAC100DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsNDBSAC100DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEMaru310and320AnnualActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEMaru310and320AnnualActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEMaru310and320SixMonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEMaru310and320SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;





                        case "NavAidsDMEMaru310and320DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEMaru310and320DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;






                        case "ADSBComsoftDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, ADSBComsoftDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "ADSBDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, ADSBDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzNormarc7000DailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzNormarc7000DailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DVORMopiensDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "AmssEcilWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, AmssEcilWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEGcel752WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEGcel752WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEGcel752DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEGcel752DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VccsSittiDailyIPTBB":
                            editScreenIntent = new Intent(ListDataActivity.this, VcsSittiM800ipActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "activity_mssrngosco_daily":
                            editScreenIntent = new Intent(ListDataActivity.this, SurMssrNgoscoDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxOteDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxOteDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxOteMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxOteMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxOteSixActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxOteSixActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxOteDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxOteDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxOteMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxOteMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxOteSixActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxOteSixActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxPaeDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxPaeDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxPaeMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxPaeMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "GpThalesDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, GpThalesDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "GpThalesWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, GpThalesWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DVORMopiensWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DVORMopiensMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DVORMopiensSixMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensSixMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DVORMopiensAnnuallyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensAnnuallyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzThalesDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzThalesDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzThalesWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzThalesWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzThalesMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzThalesMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzThalesQuarterlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzThalesQuarterlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzThalesAnnualActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzThalesAnnualActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                        case "NavAidsDMEGcelHalfYearlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEGcel752SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEGcel752MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEGcel752MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEThales415and435MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEThales415and435MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORGcel755SixMonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORGcel755QuarterlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755QuarterlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDVORGcel755MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORGcelWeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDVORGcel755DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDVORGcel755DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "NavAidsDMEMaru310and320MonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEMaru310and320MonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEMaru310and320WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEMaru310and320WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;




                        case "NavAidsDMEThales415and435AnnualActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEThales415and435AnnualActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEThales415and435SixMonthlyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEThales415and435SixMonthlyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEThales415and435WeeklyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEThales415and435WeeklyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;


                        case "NavAidsDMEThales415and435DailyActivity": //Add all activities here in the case
                            editScreenIntent = new Intent(ListDataActivity.this, NavAidsDMEThales415and435DailyActivity.class);
                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", receivedData[0]);
                            editScreenIntent.putExtra("editTextData", receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxPaeYearlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxPaeYearlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxPaeDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxPaeDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxPaeMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxPaeMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfTxPaeYearlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfTxPaeYearlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxJotDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxJotDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxJotWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxJotWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "VhfRxJotMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VhfRxJotMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "GpThalesMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, GpThalesMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "GpThalesQuarterlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, GpThalesQuarterlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "GpThalesAnnualActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, GpThalesAnnualActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzIndra70DailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzIndra70DailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzIndra70WeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzIndra70WeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "LlzIndra70MonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, LlzIndra70MonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "AutomationIndraB2cQuarterlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, AutomationIndraB2cQuarterlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                            
                        case "AutomationIndraB2cUPS15KVA":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "AutomationIndraB2cMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, AutomationIndraB2cMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                            
                        case "AutomationUPS5kvaDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, AutomationUPS5kvaDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                        case "AutomationDrfNeptunoRecordingCheck":
                            editScreenIntent = new Intent(ListDataActivity.this, AutomationDrfNeptunoRecordingCheck.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                            
                        case "DatisAcamsMonthlyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DatisAcamsMonthlyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "AutomationIndraB2cDaily":
                            editScreenIntent = new Intent(ListDataActivity.this, DVORMopiensWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                        case "DatisAcamsDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, DatisAcamsDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                            
                        case "VccsDrakeDailyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VccsDrakeDailyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;
                            
                        case "VccsDrakeWeeklyActivity":
                            editScreenIntent = new Intent(ListDataActivity.this, VccsDrakeWeeklyActivity.class);
                            editScreenIntent.putExtra("id",itemID);
                            editScreenIntent.putExtra("name",receivedData[0]);
                            editScreenIntent.putExtra("editTextData",receivedData[2]);
                            editScreenIntent.putExtra("switchData", receivedData[3]);
                            editScreenIntent.putExtra("spinnerData", receivedData[4]);
                            startActivity(editScreenIntent);
                            break;

                    }
                }
                else{
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}