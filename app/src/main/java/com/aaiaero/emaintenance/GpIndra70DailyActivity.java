package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GpIndra70DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "GpIndra70DailyActivity"; //Change Here as per your class name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_indra70_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35,
                editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextGpIndra70DailyStation),
                editText2 = (EditText) findViewById(R.id.editTextGpIndra70DailyModel),
                editText3 = (EditText) findViewById(R.id.editTextGpIndra70DailyRWY),
                editText4 = (EditText) findViewById(R.id.editTextGpIndra70DailyCat),
                editText5 = (EditText) findViewById(R.id.editTextGpIndra70DailyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextGpIndra70DailyRoomTemp),
                editText7 = (EditText) findViewById(R.id.editTextGpIndra70DailyHumidity),
                editText8 = (EditText) findViewById(R.id.editTextGpIndra70DailyMainsVoltage),
                editText9 = (EditText) findViewById(R.id.editTextGpIndra70DailyMainsFreq),
                editText10 = (EditText) findViewById(R.id.editTextGpIndra70DailyTxOnAir),
                editText11 = (EditText) findViewById(R.id.editTextGpIndra70DailyStatusMonStb),
                editText12 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLDDMMainMon1),
                editText13 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLDDMMainMon2),
                editText14 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLDDMStbMon),
                editText15 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLSDMMainMon1),
                editText16 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLSDMMainMon2),
                editText17 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLSDMStbMon),
                editText18 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRFMainMon1),
                editText19 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRFMainMon2),
                editText20 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRFStbMon),
                editText21 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSDDMMainMon1),
                editText22 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSDDMMainMon2),
                editText23 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSDDMStbMon),
                editText24 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSSDMMainMon1),
                editText25 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSSDMMainMon2),
                editText26 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSSDMStbMon),
                editText27 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSRFMainMon1),
                editText28 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSRFMainMon2),
                editText29 = (EditText) findViewById(R.id.editTextGpIndra70DailyDSRFStbMon),
                editText30 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFDDMMainMon1),
                editText31 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFDDMMainMon2),
                editText32 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFDDMStbMon),
                editText33 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFSDMMainMon1),
                editText34 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFSDMMainMon2),
                editText35 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFSDMStbMon),
                editText36 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFRFMainMon1),
                editText37 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFRFMainMon2),
                editText38 = (EditText) findViewById(R.id.editTextGpIndra70DailyNFRFStbMon),
                editText39 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRDDMMainMon1),
                editText40 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRDDMMainMon2),
                editText41 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRDDMStbMon),
                editText42 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRSDMMainMon1),
                editText43 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRSDMMainMon2),
                editText44 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRSDMStbMon),
                editText45 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRRFMainMon1),
                editText46 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRRFMainMon2),
                editText47 = (EditText) findViewById(R.id.editTextGpIndra70DailyCLRRFStbMon),
                editText48 = (EditText) findViewById(R.id.editTextGpIndra70DailyDfMon1),
                editText49 = (EditText) findViewById(R.id.editTextGpIndra70DailyDfMon2),
                editText50 = (EditText) findViewById(R.id.editTextGpIndra70DailyBatt1),
                editText51 = (EditText) findViewById(R.id.editTextGpIndra70DailyBatt2),
                editText52 = (EditText) findViewById(R.id.editTextGpIndra70DailyRemarks)};

        //Define and Initialize all Switches serially here
        Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12,
                switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,switch21,switch22,switch23;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpIndra70DailyRoomClean),
                switch2 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusAc),
                switch3 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusMast),
                switch4 = (Switch) findViewById(R.id.switchGpIndra70DailyEquipHoldsOnUps),
                switch5 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusMonitorExe),
                switch6 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusNearField),
                switch7 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusBirdMon),
                switch8 = (Switch) findViewById(R.id.switchGpIndra70DailyStatusCriticalArea),
                switch9 = (Switch) findViewById(R.id.switchGpIndra70DailyRemoteStatusER),
                switch10 = (Switch) findViewById(R.id.switchGpIndra70DailyRemoteStatusAtc),
                switch11 = (Switch) findViewById(R.id.switchGpIndra70DailyParam),
                switch12 = (Switch) findViewById(R.id.switchGpIndra70DailyDisagr),
                switch13= (Switch) findViewById(R.id.switchGpIndra70DailyBatt),
                switch14 = (Switch) findViewById(R.id.switchGpIndra70DailyMaint),
                switch15 = (Switch) findViewById(R.id.switchGpIndra70DailyStandby),
                switch16 = (Switch) findViewById(R.id.switchGpIndra70DailyCourseTx1),
                switch17 = (Switch) findViewById(R.id.switchGpIndra70DailyCourseTx2),
                switch18 = (Switch) findViewById(R.id.switchGpIndra70DailyClearanceTx1),
                switch19 = (Switch) findViewById(R.id.switchGpIndra70DailyClearanceTx2),
                switch20 = (Switch) findViewById(R.id.switchGpIndra70DailyTxtoAirTx1),
                switch21 = (Switch) findViewById(R.id.switchGpIndra70DailyTxtoAirTx2),
                switch22 = (Switch) findViewById(R.id.switchGpIndra70DailyMainTx1),
                switch23 = (Switch) findViewById(R.id.switchGpIndra70DailyMainTx2)};


        //Define and Initialize all Spinners serially here
        //---------------------To Set View in Current Activity------------------
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView10 = (TextView) findViewById(R.id.textView118);
        textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setText("Location: " + MainActivity.latLong1);
        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        String strData = sdf.format(calendar.getTime());
        textViewDate.setText(strData);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11) ;
        Button submitSchedule = (Button) findViewById(R.id.button10);

        submitSchedule.setVisibility(View.INVISIBLE);
        signDocument.setVisibility(View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);


            }
        });

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });
        // Fixed for all activity-------------------------------------------------------------------
    }
    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

//        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);
//
//        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1024, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70daily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {124,595,100,193,392,589,589,589,589,589,589,325,413,501,325,413,501,325,413,501,325,413,501,325,413,501,325,413,501};
        int[] editTextYPixel = {179,179,212,212,212,344,367,393,428,484,532,764,764,764,805,805,805,835,835,835,868,868,868,905,905,905,935,935,935};

        int[] switchXPixel = {589,589,589,589,589,589,589,589,589,589};
        int[] switchYPixel = {290,306,324,455,512,555,581,612,632,649};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }

    /*    for(int i = 0; i < spinnerDataForPDF.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
        }
*/

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,560,212,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70daily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {325,413,503,325,413,503,325,413,503,325,413,503,325,413,503,325,413,503,355,580};
        int[] editTextYPixel2 = {165,165,165,202,202,202,232,232,232,260,260,260,290,290,290,319,319,319,535,535};

        int[] switchXPixel2 = {375,375,375,375,375};
        int[] switchYPixel2 = {640,690,740,790,842};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+29],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        for(int i = 0; i < switchXPixel2.length; i++){
            canvas.drawText( switchDataForPDF[i+10],switchXPixel2[i],switchYPixel2[i],titlePaint);
        }
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70daily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {460,460,60};
        int[] editTextYPixel3 = {460,512,587};

        int[] switchXPixel3 = {360,475,360,475,360,475,360,475};
        int[] switchYPixel3 = {220,220,272,272,321,321,371,371};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+49],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        for(int i = 0; i < switchXPixel3.length; i++){
            canvas.drawText( switchDataForPDF[i+15],switchXPixel3[i],switchYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 60, 630, paint);


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPIndra70/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily GP Indra70 " + strData + ".pdf"; // Change Here--------------------------
        String targetPdf = directory_path + fileName;
        File filePath = new File(targetPdf);
        try {
            myPdfdocument.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            //done = true;
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfdocument.close();
        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());// Change Here----------------------------
        //This function saves all the data to parse Server
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"GP Indra70","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of Indra70 GP done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);


        myFunctions.toLogoutActivity();
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final EditText desiredFormName = (EditText)mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = findViewById(R.id.putInDB);
                        String formName = desiredFormName.getText().toString();
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName, thisActivityName);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;

            case R.id.deleteFromDB:
                View view1 = findViewById(R.id.deleteFromDB);
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete Alert")
                        .setMessage("Do you really want to delete this entry permanently from Local DB?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myFunctions.deleteFromDB(view1, selectedID, selectedName);
                                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

    //----At last don't forget to put an entry in Switch Case of ListDataActivity.java------------

}