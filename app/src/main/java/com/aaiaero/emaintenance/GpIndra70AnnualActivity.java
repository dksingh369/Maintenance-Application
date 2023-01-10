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

public class GpIndra70AnnualActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "GpIndra70AnnualActivity"; //Change Here as per your class name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_indra70_annual);

        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39;
        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextGpIndra70AnnualStation),
                editText2 = (EditText) findViewById(R.id.editTextGpIndra70AnnualModel),
                editText3 = (EditText) findViewById(R.id.editTextGpIndra70AnnualRWY),
                editText4 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCat),
                editText5 = (EditText) findViewById(R.id.editTextGpIndra70AnnualFrequency),
                editText6 = (EditText) findViewById(R.id.editTextGpIndra70AnnualFreqTx1),
                editText7 = (EditText) findViewById(R.id.editTextGpIndra70AnnualFreqTx2),
                editText8 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCarrFreqTx1),
                editText9 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCarrFreqTx2),
                editText10 = (EditText) findViewById(R.id.editTextGpIndra70AnnualPhaseTx1),
                editText11 = (EditText) findViewById(R.id.editTextGpIndra70AnnualPhaseTx2),
                editText12 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS1CSB),
                editText13 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS2CSB),
                editText14 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR1CSB),
                editText15 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR2CSB),
                editText16 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS1SBO),
                editText17 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS2SBO),
                editText18 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR1SBO),
                editText19 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR2SBO),
                editText20 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS1LF),
                editText21 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS2LF),
                editText22 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR1LF),
                editText23 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR2LF),
                editText24 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS1DDM),
                editText25 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS2DDM),
                editText26 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR1DDM),
                editText27 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR2DDM),
                editText28 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS1SDM),
                editText29 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCRS2SDM),
                editText30 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR1SDM),
                editText31 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLR2SDM),
                editText32 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCOUPower1),
                editText33 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCOUPower2),
                editText34 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLRPower1),
                editText35 = (EditText) findViewById(R.id.editTextGpIndra70AnnualCLRPower2),
                editText36 = (EditText) findViewById(R.id.editTextGpIndra70AnnualMonDelay),
                editText37 = (EditText) findViewById(R.id.editTextGpIndra70AnnualNFSet),
                editText38 = (EditText) findViewById(R.id.editTextGpIndra70AnnualInhibitSet),
                editText39 = (EditText) findViewById(R.id.editTextGpIndra70AnnualRemarks)};

//Define and Initialize all Switches serially here
        Switch  switch1,switch2;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpIndra70AnnualNF),
                switch2 = (Switch) findViewById(R.id.switchGpIndra70AnnualInhibit)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70annual1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {152,585,127,209,335,480,567,480,567,480,567,400,470,540,615,400,470,540,615,400,470,540,615,400,470,540,615,400,470,540,615};
        int[] editTextYPixel = {149,149,167,167,167,330,330,418,418,500,500,705,705,705,705,730,730,730,730,757,757,757,757,850,850,850,850,885,885,885,885};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,538,167,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70annual2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {430,540,430,540,465,375,375,90};
        int[] editTextYPixel2 = {180,180,230,230,324,415,442,495};

        int[] switchXPixel = {515,515};
        int[] switchYPixel = {415,442};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+31],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 90, 555, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPIndra70/Annual/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Annual GP Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"GP Indra70","Annual",outputEditText,MyFunctions.specificCode("y"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Annual Maintenance of Indra70 GP done.",//Change Here-----------------------------
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