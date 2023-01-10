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

public class AutomationIndraB2cDaily extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray ={};//Copy
    private Spinner[] spinnerArray;//Copy

    private String thisActivityName = "AutomationIndraB2CDaily"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation_indra_b2c_daily);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44,editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54,editText55, editText56, editText57, editText58, editText59, editText60, editText61, editText62, editText63, editText64,
                editText65, editText66, editText67, editText68, editText69, editText70, editText71, editText72, editText73, editText74,editText75, editText76;

        editTextArray =  new EditText[] { editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 =(EditText) findViewById(R.id.editText10),
                editText11 =(EditText)  findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 =(EditText)  findViewById(R.id.editText13),
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
                editText30 = (EditText) findViewById(R.id.editText30),
                editText31 = (EditText) findViewById(R.id.editText31),
                editText32 = (EditText) findViewById(R.id.editText32),
                editText33 = (EditText) findViewById(R.id.editText33),
                editText34 = (EditText) findViewById(R.id.editText34),
                editText35 = (EditText) findViewById(R.id.editText35),
                editText36 = (EditText) findViewById(R.id.editText36),
                editText37 = (EditText) findViewById(R.id.editText37),
                editText38 = (EditText) findViewById(R.id.editText38),
                editText39 = (EditText) findViewById(R.id.editText39),
                editText40 = (EditText) findViewById(R.id.editText40),
                editText41 = (EditText) findViewById(R.id.editText41),
                editText42 = (EditText) findViewById(R.id.editText42),
                editText43 = (EditText) findViewById(R.id.editText43),
                editText44 = (EditText) findViewById(R.id.editText44),
                editText45 = (EditText) findViewById(R.id.editText45),
                editText46 = (EditText) findViewById(R.id.editText46),
                editText47 = (EditText) findViewById(R.id.editText47),
                editText48 = (EditText) findViewById(R.id.editText48),
                editText49 = (EditText) findViewById(R.id.editText49),
                editText50 = (EditText) findViewById(R.id.editText50),
                editText51 = (EditText) findViewById(R.id.editText51),
                editText52 = (EditText) findViewById(R.id.editText52),
                editText53 = (EditText) findViewById(R.id.editText53),
                editText54 = (EditText) findViewById(R.id.editText54),
                editText55 = (EditText) findViewById(R.id.editText55),
                editText56 = (EditText) findViewById(R.id.editText56),
                editText57 = (EditText) findViewById(R.id.editText57),
                editText58 = (EditText) findViewById(R.id.editText58),
                editText59 = (EditText) findViewById(R.id.editText59),
                editText60 = (EditText) findViewById(R.id.editText60),
                editText61 = (EditText) findViewById(R.id.editText61),
                editText62 = (EditText) findViewById(R.id.editText62),
                editText63 = (EditText) findViewById(R.id.editText63),
                editText64 = (EditText) findViewById(R.id.editText64),
                editText65 = (EditText) findViewById(R.id.editText65),
                editText66 = (EditText) findViewById(R.id.editText66),
                editText67 = (EditText) findViewById(R.id.editText67),
                editText68 = (EditText) findViewById(R.id.editText68),
                editText69 = (EditText) findViewById(R.id.editText69),
                editText70 = (EditText) findViewById(R.id.editText70),
                editText71 = (EditText) findViewById(R.id.editText71),
                editText72 = (EditText) findViewById(R.id.editText72),
                editText73 = (EditText) findViewById(R.id.editText73),
                editText74 = (EditText) findViewById(R.id.editText74),
                editText75 = (EditText) findViewById(R.id.editText75),
                editText76 = (EditText) findViewById(R.id.editText76),};

        //Define and Initialize all Spinners serially here
        Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,
                spinner11,spinner12,spinner13,spinner14,spinner15,spinner16,spinner17,spinner18,spinner19,spinner20,
                spinner21,spinner22,spinner23,spinner24,spinner25,spinner26,spinner27,spinner28,spinner29,spinner30,
                spinner31,spinner32,spinner33,spinner34,spinner35,spinner36;
        spinnerArray = new Spinner[]{
                spinner1 = (Spinner) findViewById(R.id.spinner1),
                spinner2 = (Spinner) findViewById(R.id.spinner2),
                spinner3 = (Spinner) findViewById(R.id.spinner3),
                spinner4 = (Spinner) findViewById(R.id.spinner4),
                spinner5 = (Spinner) findViewById(R.id.spinner5),
                spinner6 = (Spinner) findViewById(R.id.spinner6),
                spinner7 = (Spinner) findViewById(R.id.spinner7),
                spinner8 = (Spinner) findViewById(R.id.spinner8),
                spinner9 = (Spinner) findViewById(R.id.spinner9),
                spinner10 = (Spinner) findViewById(R.id.spinner10),
                spinner11 = (Spinner) findViewById(R.id.spinner11),
                spinner12 = (Spinner) findViewById(R.id.spinner12),
                spinner13 = (Spinner) findViewById(R.id.spinner13),
                spinner14 = (Spinner) findViewById(R.id.spinner14),
                spinner15 = (Spinner) findViewById(R.id.spinner15),
                spinner16 = (Spinner) findViewById(R.id.spinner16),
                spinner17 = (Spinner) findViewById(R.id.spinner17),
                spinner18 = (Spinner) findViewById(R.id.spinner18),
                spinner19 = (Spinner) findViewById(R.id.spinner19),
                spinner20 = (Spinner) findViewById(R.id.spinner20),
                spinner21 = (Spinner) findViewById(R.id.spinner21),
                spinner22 = (Spinner) findViewById(R.id.spinner22),
                spinner23 = (Spinner) findViewById(R.id.spinner23),
                spinner24 = (Spinner) findViewById(R.id.spinner24),
                spinner25 = (Spinner) findViewById(R.id.spinner25),
                spinner26 = (Spinner) findViewById(R.id.spinner26),
                spinner27 = (Spinner) findViewById(R.id.spinner27),
                spinner28 = (Spinner) findViewById(R.id.spinner28),
                spinner29 = (Spinner) findViewById(R.id.spinner29),
                spinner30 = (Spinner) findViewById(R.id.spinner30),
                spinner31 = (Spinner) findViewById(R.id.spinner31),
                spinner32 = (Spinner) findViewById(R.id.spinner32),
                spinner23 = (Spinner) findViewById(R.id.spinner33),
                spinner34 = (Spinner) findViewById(R.id.spinner34),
                spinner35 = (Spinner) findViewById(R.id.spinner35),
                spinner36 = (Spinner) findViewById(R.id.spinner36)};

        //---------------------To Set View in Current Activity------------------
        // Fixed for all the activity---------------------------------------------------------------
        //ImageView imageView10 = (ImageView) findViewById(R.id.imageView10);
        //imageView10.setImageBitmap(PersonalDetailsActivity.photo);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setText("Location: " + MainActivity.latLong1);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            //String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            //String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            //myFunctions.putSwitchData(seperatedSwitchData, switchArray);
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
        // Fixed for all activity-------------------------------------------------------------------
    }

    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        //String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        //String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2cdaily1);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(30);
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText("Name: " + PersonalDetailsActivity.naam ,1500,32,titlePaint);
        //canvas.drawText("Desig: " + PersonalDetailsActivity.design ,1500,64,titlePaint);
        //canvas.drawText("Emp No.: " + PersonalDetailsActivity.EmpID ,1500,96,titlePaint);
        //canvas.drawText("Location: " + MainActivity.latLong1,1500,128,titlePaint);
        //canvas.drawBitmap(PersonalDetailsActivity.photo, 1630, 130, paint);
        //--------------------------------Change as per your requirement------------------------------------------------------
        // canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,500,510, false), 1325, 2720, paint);
        titlePaint.setTextSize(30);

        int[] editTextXPixel1 = {120,235,32,132,132,32,132,132,32,132,132,32,132,132,32,132,132,32,132,132,32,132,132,32,132,132,32,132,132};
        int[] editTextYPixel1 = {212,354,445,430,448,482,466,483,527,511,530,565,548,563,597,581,598,633,616,632,667,650,669,702,686,703,737,721,737};

        //int[] switchXPixel = {1400,1400,1400,1400,1400,1400,1400,1400,1400,1400,1400};
        //int[] switchYPixel = {645,768,809,950,1623,2023,2190,2319,2403,2530,2660};

        int[] spinnerXPixel1 = {374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374};
        int[] spinnerYPixel1 = {431,448,466,484,512,530,546,564,581,599,616,633,650,669,686,704,720,738,773,790,824,869,887,904};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        /*for(int i = 0; i < switchDataForPDF.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }*/

        for(int i = 0; i < spinnerXPixel1.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel1[i],spinnerYPixel1[i],titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(40);

        //canvas.drawText(strData,1568,425,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2cdaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(30);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(30);

        int[] editTextXPixel2 = {372,372,372,372,372,372,372,372,372,372,372};
        int[] editTextYPixel2 = {328,418,543,471,505,540,557,589,608,640,679};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        int[] spinnerXPixel2 = {374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374,374};
        int[] spinnerYPixel2 = {431,448,466,484,512,530,546,564,581,599,616,633,650,669,686,704,720,738,773,790,824,869,887,904};

        for(int i = 0; i < spinnerXPixel2.length; i++){
            canvas.drawText( spinnerDataForPDF[i+spinnerXPixel1.length],spinnerXPixel2[i],spinnerYPixel2[i],titlePaint);
        }

        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo, 210, 270, false), 93, 480, paint);
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 290, 270, false), 22, 296, paint);
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1023, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2cdaily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(30);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(30);

        canvas.drawText( editTextDataForPDF[1],412,140,titlePaint);

        int[] editTextXPixel3 = {412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412,412};
        int[] editTextYPixel3 = {193,211,229,246,264,315,333,350,367,385,402,419,467,522,549,607,635,693,743,760,779,822,872};

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo, 210, 270, false), 93, 480, paint);
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 290, 270, false), 22, 296, paint);
        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1023, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.adpindrab2cdaily4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);



        titlePaint.setTextSize(30);

        int[] editTextXPixel4 = {407,407,407,407,407,407,407,407,407,407,407,407,407};
        int[] editTextYPixel4 = {140,183,225,259,300,345,380,408,444,485,547,580,632};

        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length+editTextXPixel2.length+editTextXPixel3.length],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }

        titlePaint.setTextSize(30);
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo, 210, 270, false), 93, 480, paint);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 290, 270, false), 33, 690, paint);
        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Automation/Indra/B2c/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Automation B2C Daily " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"Automation_Indra_B2c","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", outputSpinner);// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of Automation Indra B2c done.",//Change Here-----------------------------
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
}