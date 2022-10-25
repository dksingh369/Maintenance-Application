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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class SurvADSBComsoftDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray;//Copy
    private String thisActivityName = "SurvADSBComsoftDailyActivity";

    // Data given from Prev Page is
    // For Name, Designation, BitMap Image, Latlong, emp ID access the following variables resp.
    //PersonalDetailsActivity.naam, PersonalDetailsActivity.design, PersonalDetailsActivity.photo, MainActivity.latLong1, PersonalDetailsActivity.EmpID


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv_adsbcomsoft_daily);
        //----------------------------------Change Here------------------------------
        // Define all Edit Texts here
        EditText editTextRoomTemp;
        EditText editTextAC, editTextESMSAlarm, editTextDiskUsage, editTextATemp, editTextACPULoad, editTextBTemp, editTextBCPULoad, editTextRemarks;
        EditText editTextHumidity;

        //Put all edit texts in Array serially
        editTextArray = new EditText[]{
                editTextRoomTemp = (EditText) findViewById(R.id.editTextRoomTemp),
                editTextHumidity = (EditText) findViewById(R.id.editTextHumidity),
                editTextAC = (EditText) findViewById(R.id.editTextAC),
                editTextESMSAlarm = (EditText) findViewById(R.id.editTextESMSAlarm),
                editTextDiskUsage = (EditText) findViewById(R.id.editTextDiskUsage),
                editTextATemp = (EditText) findViewById(R.id.editTextATemp),
                editTextACPULoad = (EditText) findViewById(R.id.editTextACPULoad),
                editTextBTemp = (EditText) findViewById(R.id.editTextBTemp),
                editTextBCPULoad = (EditText) findViewById(R.id.editTextBCPULoad),
                editTextRemarks = (EditText) findViewById(R.id.editTextRemarks)};

        Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11;
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
                switch11 = (Switch) findViewById(R.id.switch11)};

        Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10;
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
                spinner10 = (Spinner) findViewById(R.id.spinner10)};

        //------------------------------End Change Here ---------------------------------

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
            String[] seperatedSpinnerData = myFunctions.seperateSwitchData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
        }

        Button submitSchedule = (Button) findViewById(R.id.submitADSBComsoftDaily);
        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });
    }

    private void generatePDF(){
        //Copy This function in your Activity
        //------------------Change Here as per Requirement------------------
        // Data for Printing in PDF
        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);
        //Log.i("output Edit Text", outputEditText);
        // Seperated Data for printing in PDF------------------------
        String[] dataForPDF = myFunctions.seperateEditText(outputEditText);
        Log.i("output Edit Text", Arrays.toString(dataForPDF));

        // create a new document
        PdfDocument myPdfdocument = new PdfDocument();
        Bitmap bmp, scaledbmp;

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        //----------------Page 1 ------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(725, 1023, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);

        Canvas canvas = myPage1.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.surv_adsb_comsoft_daily);
        scaledbmp = Bitmap.createScaledBitmap(bmp,725,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(30);
        paint.setTextAlign(Paint.Align.LEFT);

        //canvas.drawBitmap(R.drawable.gfgimage, 1630, 128, paint);
        titlePaint.setTextSize(30);
        String name = "Deepak";
        canvas.drawText( name,500,500,titlePaint);

        canvas.drawText( "name",500,600,titlePaint);

        canvas.drawText( "Singh",500,700,titlePaint);
        canvas.drawText( "Nagpur",500,800,titlePaint);
        myPdfdocument.finishPage(myPage1);

        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(725, 1023, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.surv_adsb_comsoft_daily_1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,725,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        Date dateObj = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Equipment Room/ADSB/Daily/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily ADSB " + strData + ".pdf";
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
        //This function saves all the data to parse Server
        //saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"ADSB","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");
        //if (uploadedToServer) Toast.makeText(this, "Data uploaded to Server.", Toast.LENGTH_SHORT).show();
        //else Toast.makeText(this, "Server is not available.", Toast.LENGTH_SHORT).show();
        //Log.i("target Path", targetPdf);
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero", "Daily Maintenance of Comsoft ADSB done.", "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //Log.i("Mail", PersonalDetailsActivity.emailTo + "@aai.aero");
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
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName,thisActivityName );
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