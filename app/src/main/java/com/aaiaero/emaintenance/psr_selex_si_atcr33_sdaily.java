package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
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

public class psr_selex_si_atcr33_sdaily extends AppCompatActivity {



        private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
        private MySignature mySignature = new MySignature(this);
        private int selectedID;//Copy
        private String selectedName;//Copy
        private EditText[] editTextArray;//Copy
        private Switch[] switchArray;//Copy
        private Spinner[] spinnerArray={};//Copy

        private String thisActivityName = "psr_selex_si_atcr33_sdaily"; //Change Here as per your class name
         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_psr_selex_si_atcr33_sdaily);


      /* All are serially numbered from 1. Total No.of, Edit texts = 49 (first 48 single line, 1 multiline), switches =10,
            spinners = 7. ,  textviews = 71, Buttons = 2
         */
                    //Define and Initialize all EditTexts serially here
                    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9,editText10,
                    editText11,editText12,editText13,editText14,editText15,editText16,editText17,editText18,editText19,editText20,
                    editText21,editText22,editText23,editText24,editText25,editText26,editText27,editText28,editText29,editText30;


            editTextArray = new EditText[]{
                    editText1 = (EditText) findViewById(R.id.editText1),
                    editText2 = (EditText) findViewById(R.id.editText2),
                    editText3 = (EditText) findViewById(R.id.editText3),
                    editText4 = (EditText) findViewById(R.id.editText4),
                    editText5 = (EditText) findViewById(R.id.editText5),
                    editText6 = (EditText) findViewById(R.id.editText6),
                    editText7 = (EditText) findViewById(R.id.editText7),
                    editText8 = (EditText) findViewById(R.id.editText8),
                    editText9 = (EditText) findViewById(R.id.editText9),
                    editText10 = (EditText) findViewById(R.id.editText10),
                    editText11 = (EditText) findViewById(R.id.editText11),
                    editText12 = (EditText) findViewById(R.id.editText12),
                    editText13 = (EditText) findViewById(R.id.editText13),
                    editText14 = (EditText) findViewById(R.id.editText14),
                    editText15 = (EditText) findViewById(R.id.editText15),
                    editText16 = (EditText) findViewById(R.id.editText16),
                    editText17 = (EditText) findViewById(R.id.editText17),
                    editText18 = (EditText) findViewById(R.id.editText18),
                    editText19 = (EditText) findViewById(R.id.editText19),
                    editText20 = (EditText) findViewById(R.id.editText20),
                    editText21 = (EditText) findViewById(R.id.editText21),
                    editText22 = (EditText) findViewById(R.id.editText22),
                    editText23 = (EditText) findViewById(R.id.editText23),
                    editText24 = (EditText) findViewById(R.id.editText24),
                    editText25 = (EditText) findViewById(R.id.editText25),
                    editText26 = (EditText) findViewById(R.id.editText26),
                    editText27 = (EditText) findViewById(R.id.editText27),
                    editText28 = (EditText) findViewById(R.id.editText28),
                    editText29 = (EditText) findViewById(R.id.editText29),
                    editText30 = (EditText) findViewById(R.id.editText30)};


            //Define and Initialize all Switches serially here
            @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,
                    switch11,switch12,switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,
                    switch21,switch22,switch23,switch24,switch25,switch26,switch27,switch28,switch29,switch30,
                    switch31,switch32,switch33,switch34,switch35,switch36,switch37,switch38,switch39,switch40,
                    switch41,switch42,switch43,switch44,switch45,switch46,switch47,switch48,switch49,switch50,switch51,switch52,switch53,switch54;


            switchArray = new Switch[]{
                    switch1 = (Switch) findViewById(R.id.switch1),
                    switch2 = (Switch) findViewById(R.id.switch2),
                    switch3 = (Switch) findViewById(R.id.switch3),
                    switch4 = (Switch) findViewById(R.id.switch4),
                    switch5 = (Switch) findViewById(R.id.switch5),
                    switch6 = (Switch) findViewById(R.id.switch6),
                    switch7 = (Switch) findViewById(R.id.switch7),
                    switch8 = (Switch) findViewById(R.id.switch8),
                    switch9 = (Switch) findViewById(R.id.switch9),
                    switch10 = (Switch) findViewById(R.id.switch10),
                    switch11 = (Switch) findViewById(R.id.switch11),
                    switch12 = (Switch) findViewById(R.id.switch12),
                    switch13 = (Switch) findViewById(R.id.switch13),
                    switch14 = (Switch) findViewById(R.id.switch14),
                    switch15 = (Switch) findViewById(R.id.switch15),
                    switch16 = (Switch) findViewById(R.id.switch16),
                    switch17 = (Switch) findViewById(R.id.switch17),
                    switch18 = (Switch) findViewById(R.id.switch18),
                    switch19 = (Switch) findViewById(R.id.switch19),
                    switch20 = (Switch) findViewById(R.id.switch20),
                    switch21 = (Switch) findViewById(R.id.switch21),
                    switch22 = (Switch) findViewById(R.id.switch22),
                    switch23 = (Switch) findViewById(R.id.switch23),
                    switch24 = (Switch) findViewById(R.id.switch24),
                    switch25 = (Switch) findViewById(R.id.switch25),
                    switch26 = (Switch) findViewById(R.id.switch26),
                    switch27 = (Switch) findViewById(R.id.switch27),
                    switch28 = (Switch) findViewById(R.id.switch28),
                    switch29 = (Switch) findViewById(R.id.switch29),
                    switch30 = (Switch) findViewById(R.id.switch30),
                    switch31 = (Switch) findViewById(R.id.switch31),
                    switch32 = (Switch) findViewById(R.id.switch32),
                    switch33 = (Switch) findViewById(R.id.switch33),
                    switch34 = (Switch) findViewById(R.id.switch34),
                    switch35 = (Switch) findViewById(R.id.switch35),
                    switch36 = (Switch) findViewById(R.id.switch36),
                    switch37 = (Switch) findViewById(R.id.switch37),
                    switch38 = (Switch) findViewById(R.id.switch38),
                    switch39 = (Switch) findViewById(R.id.switch39),
                    switch40 = (Switch) findViewById(R.id.switch40),
                    switch41 = (Switch) findViewById(R.id.switch41),
                    switch42 = (Switch) findViewById(R.id.switch42),
                    switch43 = (Switch) findViewById(R.id.switch43),
                    switch44 = (Switch) findViewById(R.id.switch44),
                    switch45 = (Switch) findViewById(R.id.switch45),
                    switch46 = (Switch) findViewById(R.id.switch46),
                    switch47 = (Switch) findViewById(R.id.switch47),
                    switch48 = (Switch) findViewById(R.id.switch48),
                    switch49 = (Switch) findViewById(R.id.switch49),
                    switch50 = (Switch) findViewById(R.id.switch50),
                    switch51 = (Switch) findViewById(R.id.switch51),
                    switch52 = (Switch) findViewById(R.id.switch52),
                    switch53 = (Switch) findViewById(R.id.switch53),
                    switch54 = (Switch) findViewById(R.id.switch54)};



            //---------------------To Set View in Current Activity------------------

            TextView Name = (TextView) findViewById(R.id.textViewName);
            Name.setText("Name: " + PersonalDetailsActivity.naam);
            TextView Desig = (TextView) findViewById(R.id.textViewDesig);
            Desig.setText("Designation: " + PersonalDetailsActivity.design);
            TextView EmpNo = (TextView) findViewById(R.id.textViewEmpid);
            EmpNo.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
            TextView Location = (TextView) findViewById(R.id.textViewLocation);
            Location.setText("Location: " + MainActivity.latLong1);


             Calendar calendar = Calendar.getInstance();
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
             String date = sdf.format(calendar.getTime());

             TextView Date = (TextView) findViewById(R.id.textViewDateTime);
             Date.setText("Date and Time:  " + date);

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

            Button signDocument = (Button) findViewById(R.id.button2) ;
            Button submitSchedule = (Button) findViewById(R.id.button1);

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
        }// End of On create

    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // ******************Code for Page 1****************
        // create a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();

        // initialising canvas & bitmap and start of page 1
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp; //only exists(i.e declaration) in page 1.
//-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.selexpsrdailypage1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
//--------------------------------------------------------------------------------------------
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------

        //---------------select the type of data types used omit rest of them --------------------------------
        int[] editTextXPixel1 = {130,296,433,433,433,425};
        int[] editTextYPixel1 = {148,148,289,310,333,884};

        int[] switchXPixel1 = {433,430,496,564,438,536,433,433,491,491,491,491,491,491,491,491,491,491,491,491};
        int[] switchYPixel1 = {245,265,265,265,356,356,381,401,472,491,509,543,582,600,639,658,693,730,752,790};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------
        //---------------select the for loops of declared data types only, omit rest of them --------------------------------
        for(int i = 0; i < editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel1.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel1[i],switchYPixel1[i],titlePaint);
        }



        // ******************not required other than page 1****************
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);

        canvas.drawText(strData,517,148,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1----------------
            // Change below as per requirement-----------------------------------------------------------
        // ******************Code for Page 2****************
        // create a page description
        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();
        // initialising canvas & bitmap and start of page 2
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);
        canvas = myPage2.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.selexpsrdailypage2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/

        int[] editTextXPixel2 = {425,425,425,570,570,570};

        int[] editTextYPixel2 = {135,158,181,795,818,850};

        int[] switchXPixel2 = {416,416,416,416,416,416,416,416,416,416,416,416,416,474,474,474,474,474,474,474,474,474,474,474,474,474,572,572,572,572,572,572,572};
        int[] switchYPixel2 = {281,303,327,349,371,393,416,440,461,485,507,529,550,281,303,327,349,371,393,416,440,461,485,507,529,550,660,682,703,726,749,771,876};



        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel2.length; i++){
            canvas.drawText( switchDataForPDF[i+ switchXPixel1.length],switchXPixel2[i],switchYPixel2[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage2);


        //---------------------End of Page 2---------------


        // ******************Code for Page 3****************
        // create a page description
        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1023, 3).create();

        // initialising canvas & bitmap and start of page 3
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);
        canvas = myPage3.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.selexpsrdailypage3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 418, 715, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);

        int[] editTextXPixel3 = {400,400,400,400,400,400,400,400,400,400,400,400,445,445,445,445,445,80};

        int[] editTextYPixel3 = {135,159,181,204,226,248,271,293,317,407,451,475,563,584,606,625,660,699};

        int[] switchXPixel3 = {400};
        int[] switchYPixel3 = {383};



        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length  + editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel3.length; i++){
            canvas.drawText( switchDataForPDF[i+ switchXPixel1.length + switchXPixel2.length],switchXPixel3[i],switchYPixel3[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage3);//finishing page 3 addition in pdf


        //---------------------End of Page 3---------------

        // ******************after writing all pages****************

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Surveillance/PSR/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily_PSR_Selex_ATCR33S " + strData + ".pdf"; // Change Here--------------------------
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
        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        // Change below Here----------------------------

        //This function saves all the data to parse Server
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"PSR","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch,"outputSpinner");// Change Here------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of SELEX ATCR33S DPC PSR done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------


        myFunctions.toLogoutActivity();
    } //-------------End of generatePDF-----------



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

        switch (item.getItemId()) {

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText desiredFormName = (EditText) mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button) mView.findViewById(R.id.btn_okay);
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
                        myFunctions.addToDB(view, editTextArray, switchArray, spinnerArray, formName, thisActivityName);
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
                                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
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
