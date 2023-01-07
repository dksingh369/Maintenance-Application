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

public class psr_eldis_4_rl200_daily extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy

    private String thisActivityName = "psr_eldis_4_rl200_daily"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psr_eldis4_rl200_daily);

          /* All are serially numbered from 1. Total No.of, Edit texts = 146 (first 145 single line, 1 multiline), switches =7,
            spinners = 1., Buttons = 2
         */

        //Define and Initialize all EditTexts serially here
         EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9,editText10,
                editText11,editText12,editText13,editText14,editText15,editText16,editText17,editText18,editText19,editText20,
                editText21,editText22,editText23,editText24,editText25,editText26,editText27,editText28,editText29,editText30,
                editText31,editText32,editText33,editText34,editText35,editText36,editText37,editText38,editText39,editText40,
                editText41,editText42,editText43,editText44,editText45,editText46,editText47,editText48,editText49,editText50,
                editText51,editText52,editText53,editText54,editText55,editText56,editText57,editText58,editText59,editText60,
                editText61,editText62,editText63,editText64,editText65,editText66,editText67,editText68,editText69,editText70,
                editText71,editText72,editText73,editText74,editText75,editText76,editText77,editText78,editText79,editText80,
                editText81,editText82,editText83,editText84,editText85,editText86,editText87,editText88,editText89,editText90,
                editText91,editText92,editText93,editText94,editText95,editText96,editText97,editText98,editText99,editText100,
                editText101,editText102,editText103,editText104,editText105,editText106,editText107,editText108,editText109,editText110,
                editText111,editText112,editText113,editText114,editText115,editText116,editText117,editText118,editText119,editText120,
                editText121,editText122,editText123,editText124,editText125,editText126,editText127,editText128,editText129,editText130,
                editText131,editText132,editText133,editText134,editText135,editText136,editText137,editText138,editText139,editText140,
                editText141;

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
                editText76 = (EditText) findViewById(R.id.editText76),
                editText77 = (EditText) findViewById(R.id.editText77),
                editText78 = (EditText) findViewById(R.id.editText78),
                editText79 = (EditText) findViewById(R.id.editText79),
                editText80 = (EditText) findViewById(R.id.editText80),
                editText81 = (EditText) findViewById(R.id.editText81),
                editText82 = (EditText) findViewById(R.id.editText82),
                editText83 = (EditText) findViewById(R.id.editText83),
                editText84 = (EditText) findViewById(R.id.editText84),
                editText85 = (EditText) findViewById(R.id.editText85),
                editText86 = (EditText) findViewById(R.id.editText86),
                editText87 = (EditText) findViewById(R.id.editText87),
                editText88 = (EditText) findViewById(R.id.editText88),
                editText89 = (EditText) findViewById(R.id.editText89),
                editText90 = (EditText) findViewById(R.id.editText90),
                editText91 = (EditText) findViewById(R.id.editText91),
                editText92 = (EditText) findViewById(R.id.editText92),
                editText93 = (EditText) findViewById(R.id.editText93),
                editText94 = (EditText) findViewById(R.id.editText94),
                editText95 = (EditText) findViewById(R.id.editText95),
                editText96 = (EditText) findViewById(R.id.editText96),
                editText97 = (EditText) findViewById(R.id.editText97),
                editText98 = (EditText) findViewById(R.id.editText98),
                editText99 = (EditText) findViewById(R.id.editText99),
                editText100 = (EditText) findViewById(R.id.editText100),
                editText101 = (EditText) findViewById(R.id.editText101),
                editText102 = (EditText) findViewById(R.id.editText102),
                editText103 = (EditText) findViewById(R.id.editText103),
                editText104 = (EditText) findViewById(R.id.editText104),
                editText105 = (EditText) findViewById(R.id.editText105),
                editText106 = (EditText) findViewById(R.id.editText106),
                editText107 = (EditText) findViewById(R.id.editText107),
                editText108 = (EditText) findViewById(R.id.editText108),
                editText109 = (EditText) findViewById(R.id.editText109),
                editText110 = (EditText) findViewById(R.id.editText110),
                editText111 = (EditText) findViewById(R.id.editText111),
                editText112 = (EditText) findViewById(R.id.editText112),
                editText113 = (EditText) findViewById(R.id.editText113),
                editText114 = (EditText) findViewById(R.id.editText114),
                editText115 = (EditText) findViewById(R.id.editText115),
                editText116 = (EditText) findViewById(R.id.editText116),
                editText117 = (EditText) findViewById(R.id.editText117),
                editText118 = (EditText) findViewById(R.id.editText118),
                editText119 = (EditText) findViewById(R.id.editText119),
                editText120 = (EditText) findViewById(R.id.editText120),
                editText121 = (EditText) findViewById(R.id.editText121),
                editText122 = (EditText) findViewById(R.id.editText122),
                editText123 = (EditText) findViewById(R.id.editText123),
                editText124 = (EditText) findViewById(R.id.editText124),
                editText125 = (EditText) findViewById(R.id.editText125),
                editText126 = (EditText) findViewById(R.id.editText126),
                editText127 = (EditText) findViewById(R.id.editText127),
                editText128 = (EditText) findViewById(R.id.editText128),
                editText129 = (EditText) findViewById(R.id.editText129),
                editText130 = (EditText) findViewById(R.id.editText130),
                editText131 = (EditText) findViewById(R.id.editText131),
                editText132 = (EditText) findViewById(R.id.editText132),
                editText133 = (EditText) findViewById(R.id.editText133),
                editText134 = (EditText) findViewById(R.id.editText134),
                editText135 = (EditText) findViewById(R.id.editText135),
                editText136 = (EditText) findViewById(R.id.editText136),
                editText137 = (EditText) findViewById(R.id.editText137),
                editText138 = (EditText) findViewById(R.id.editText138),
                editText139 = (EditText) findViewById(R.id.editText139),
                editText140 = (EditText) findViewById(R.id.editText140),
                editText141 = (EditText) findViewById(R.id.editText141)};

        //Define and Initialize all Switches serially here
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7;

        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switch1),
                switch2 = (Switch) findViewById(R.id.switch2),
                switch3 = (Switch) findViewById(R.id.switch3),
                switch4 = (Switch) findViewById(R.id.switch4),
                switch5 = (Switch) findViewById(R.id.switch5),
                switch6 = (Switch) findViewById(R.id.switch6),
                switch7 = (Switch) findViewById(R.id.switch7)};



        //---------------------To Set View in Current Activity------------------

        TextView Name = (TextView) findViewById(R.id.textView3);
        Name.setText("Name: " + PersonalDetailsActivity.naam);
        TextView Desig = (TextView) findViewById(R.id.textView4);
        Desig.setText("Designation: " + PersonalDetailsActivity.design);
        TextView EmpNo = (TextView) findViewById(R.id.textView5);
        EmpNo.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView Location = (TextView) findViewById(R.id.textView6);
        Location.setText("Location: " + MainActivity.latLong1);

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

    }// End of OnCreate

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
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();

        // initialising canvas & bitmap and start of page 1
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage01);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change as per your requirement------------------------------------------------------
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,210, false), 1325, 2720, paint);
        titlePaint.setTextSize(13);

        int[] editTextXPixel1 = {104,601,340,340,340,340,340,340,340};
        int[] editTextYPixel1 = {247,247,478,513,624,670,703,740,774};

        int[] switchXPixel1 = {340,340,340};
        int[] switchYPixel1 = {445,550,580};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel1.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel1[i],switchYPixel1[i],titlePaint);
        }




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);

        canvas.drawText(strData,340,382,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1----------------


        // ******************Code for Page 2****************
        // create a page description
        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();
        // initialising canvas & bitmap and start of page 2
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);
        canvas = myPage2.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage02);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/

        int[] editTextXPixel2 = {326,326,326,326,326,326,326,326,326,326,326};

        int[] editTextYPixel2 = {201,260,348,391,445,495,619,662,701,742,785};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage03);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/

        int[] editTextXPixel3 = {340,340,340,340,340,340,340,340,340,340,340,340};

        int[] editTextYPixel3 = {200,245,290,335,375,420,465,540,640,710,767,818};




        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage3);


        //---------------------End of Page 3---------------



        // ******************Code for Page 4****************
        // create a page description
        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1023, 4).create();
        // initialising canvas & bitmap and start of page 4
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);
        canvas = myPage4.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage04);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/

        int[] editTextXPixel4 = {340,340,340,340,340,340,340,340,340,340,340,340};

        int[] editTextYPixel4 = {200,245,290,335,375,420,465,540,640,710,767,818};

        int[] switchXPixel4 = {335,335};
        int[] switchYPixel4 = {260,695};



        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel4.length; i++){
            canvas.drawText( switchDataForPDF[i + switchXPixel1.length],switchXPixel4[i],switchYPixel4[i],titlePaint);
        }


        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage4);


        //---------------------End of Page 4---------------


        // ******************Code for Page 5****************
        // create a page description
        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(723, 1023,5 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);
        canvas = myPage5.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage05);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel5 = {340,340,340,340,340,340,340,340,340,340,340,340};

        int[] editTextYPixel5 = {201,333,396,435,521,565,606,650,692,734,776,816};

        int[] switchXPixel5 = {340};
        int[] switchYPixel5 = {243};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel5.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length],editTextXPixel5[i],editTextYPixel5[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel5.length; i++){
            canvas.drawText( switchDataForPDF[i + switchXPixel1.length+switchXPixel4.length],switchXPixel5[i],switchYPixel5[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage5);


        //---------------------End of Page 5 ---------------


        // ******************Code for Page 6****************
        // create a page description
        PdfDocument.PageInfo myPageInfo6 = new PdfDocument.PageInfo.Builder(723, 1023,6 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage6 = myPdfdocument.startPage(myPageInfo6);
        canvas = myPage6.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage06);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel6 = {335,335,335,335,335,335,335,335,335,335,335,335};

        int[] editTextYPixel6 = {214,290,362,400,490,534,579,618,707,751,791,836};

        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel6.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length],editTextXPixel6[i],editTextYPixel6[i],titlePaint);
        }





        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage6);


        //---------------------End of Page 6 ---------------


        // ******************Code for Page 7****************
        // create a page description
        PdfDocument.PageInfo myPageInfo7 = new PdfDocument.PageInfo.Builder(723, 1023,7 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage7 = myPdfdocument.startPage(myPageInfo7);
        canvas = myPage7.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage07);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel7 = {335,335,335,335,335,335,335,335,335,335,335,335};

        int[] editTextYPixel7 = {201,242,289,330,400,482,544,589,689,734,780,823};

        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel7.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length],editTextXPixel7[i],editTextYPixel7[i],titlePaint);
        }





        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage6);


        //---------------------End of Page 7 ---------------

        // ******************Code for Page 8****************
        // create a page description
        PdfDocument.PageInfo myPageInfo8 = new PdfDocument.PageInfo.Builder(723, 1023,8 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage8 = myPdfdocument.startPage(myPageInfo8);
        canvas = myPage8.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage08);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel8 = {336,336,336,336,336,336,336};

        int[] editTextYPixel8 = {259,310,386,455,565,686,803};
        int[] switchXPixel8 = {336};
        int[] switchYPixel8 = {355};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel8.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length],editTextXPixel8[i],editTextYPixel8[i],titlePaint);
        }


        for(int i = 0; i < switchXPixel8.length; i++){
            canvas.drawText( switchDataForPDF[i + switchXPixel1.length+ switchXPixel8.length],switchXPixel8[i],switchYPixel8[i],titlePaint);
        }




        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage8);


        //---------------------End of Page 8 ---------------

        // ******************Code for Page 9****************
        // create a page description
        PdfDocument.PageInfo myPageInfo9 = new PdfDocument.PageInfo.Builder(723, 1023,9 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage9 = myPdfdocument.startPage(myPageInfo9);
        canvas = myPage9.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage09);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel9 = {333,333,333,333,333,333};

        int[] editTextYPixel9 = {280,360,450,587,682,795};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel9.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length],editTextXPixel9[i],editTextYPixel9[i],titlePaint);
        }






        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage9);


        //---------------------End of Page 9 ---------------

        // ******************Code for Page 10****************
        // create a page description
        PdfDocument.PageInfo myPageInfo10 = new PdfDocument.PageInfo.Builder(723, 1023,10 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage10 = myPdfdocument.startPage(myPageInfo10);
        canvas = myPage10.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage10);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel10 = {336,336,336,336,336,336,336,336,336};

        int[] editTextYPixel10 = {270,351,441,553,605,650,750,799,840};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel10.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length],editTextXPixel10[i],editTextYPixel10[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage10);


        //---------------------End of Page 10 ---------------
        // ******************Code for Page 11****************
        // create a page description
        PdfDocument.PageInfo myPageInfo11 = new PdfDocument.PageInfo.Builder(723, 1023,11 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage11 = myPdfdocument.startPage(myPageInfo11);
        canvas = myPage11.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage11);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel11 = {336,336,336,336,336,336,336,336,336};

        int[] editTextYPixel11 = {276,360,436,524,577,623,715,753,811};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel11.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length+editTextXPixel10.length],editTextXPixel11[i],editTextYPixel11[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage11);


        //---------------------End of Page 11 ---------------

        // ******************Code for Page 12****************
        // create a page description
        PdfDocument.PageInfo myPageInfo12 = new PdfDocument.PageInfo.Builder(723, 1023,12 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage12 = myPdfdocument.startPage(myPageInfo12);
        canvas = myPage12.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage12);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel12 = {331,331,331,331,331,331,331,331,331,331,331};

        int[] editTextYPixel12 = {212,312,358,404,447,494,538,638,697,764,831};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel12.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length+editTextXPixel10.length+editTextXPixel11.length],editTextXPixel12[i],editTextYPixel12[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage12);


        //---------------------End of Page 12 ---------------


        // ******************Code for Page 13****************
        // create a page description
        PdfDocument.PageInfo myPageInfo13 = new PdfDocument.PageInfo.Builder(723, 1023,13 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage13 = myPdfdocument.startPage(myPageInfo13);
        canvas = myPage13.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage13);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        /*canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 373, 658, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);*/


        int[] editTextXPixel13 = {337,337,337,337,337,337,337,337,337,337,337,337};

        int[] editTextYPixel13 = {246,292,336,381,424,518,562,606,650,695,785,832};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel13.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length+editTextXPixel10.length+editTextXPixel11.length+editTextXPixel12.length],editTextXPixel13[i],editTextYPixel13[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage13);


        //---------------------End of Page 13 ---------------

        // ******************Code for Page 14****************
        // create a page description
        PdfDocument.PageInfo myPageInfo14 = new PdfDocument.PageInfo.Builder(723, 1023,14 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage14 = myPdfdocument.startPage(myPageInfo14);
        canvas = myPage14.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage14);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 292, 776, paint);  //  For signature printing used in the last page usually
        titlePaint.setTextSize(13);


        int[] editTextXPixel14 = {330,330,330,330,330,330,330,330,330,330};

        int[] editTextYPixel14 = {193,238,330,374,470,515,560,626,656,680};


        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------

        for(int i = 0; i < editTextXPixel14.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length+editTextXPixel10.length+editTextXPixel11.length+editTextXPixel12.length+editTextXPixel13.length],editTextXPixel14[i],editTextYPixel14[i],titlePaint);
        }



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage14);


        //---------------------End of Page 14 ---------------

        // ******************Code for Page 15****************
        // create a page description
        PdfDocument.PageInfo myPageInfo15 = new PdfDocument.PageInfo.Builder(723, 1023,15 ).create();
        // initialising canvas & bitmap and start of page
        PdfDocument.Page myPage15 = myPdfdocument.startPage(myPageInfo15);
        canvas = myPage15.getCanvas();

        //-------------------------change here and put correct image name as per drawable--------------------------------
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.eldis4psrdailypage15);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        //--------------------------------------------------------------------------------------------


        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change below as per your requirement------------------------------------------------------




        // Change till here as per requirements ----------------------------------------------------

        //***Fixed for all activity-------***But change the index passing in data arrays, required in other than page 1-------------------------------------------------------------
        canvas.drawText( editTextDataForPDF[ editTextXPixel1.length + editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length+editTextXPixel5.length+editTextXPixel6.length+editTextXPixel7.length+editTextXPixel8.length+editTextXPixel9.length+editTextXPixel10.length+editTextXPixel11.length+editTextXPixel12.length+editTextXPixel13.length+editTextXPixel14.length],158,253,titlePaint);



        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage15);


        //---------------------End of Page 15 ---------------
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
        String fileName = "Daily_PSR_ELDIS4_RL-200 " + strData + ".pdf"; // Change Here--------------------------
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
                "Daily Maintenance of ELDIS4 RL-2000 PSR done.",//Change Here-----------------------------
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