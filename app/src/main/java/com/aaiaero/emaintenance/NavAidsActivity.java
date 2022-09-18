package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import java.io.ByteArrayOutputStream;

public class NavAidsActivity extends AppCompatActivity {

    Button dvor, dme, llz, gp, ndb, locator, marker, others1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_aids);

        setTitle("Nav-Aids Components");

        dvor = (Button) findViewById(R.id.dvor);
        dme = (Button) findViewById(R.id.dme);
        llz = (Button) findViewById(R.id.llz);
        gp = (Button) findViewById(R.id.gp);
        ndb = (Button) findViewById(R.id.ndb);
        locator = (Button) findViewById(R.id.locator);
        marker = (Button) findViewById(R.id.marker);
        others1 = (Button) findViewById(R.id.others1);

        Intent intent = getIntent();

    }

    public void dvorClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DvorMakeModelActivity.class);
        startActivity(intent);

    }

    public void dmeClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DmeMakeModelActivity.class);
        startActivity(intent);



    }

    public void llzClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzMakeModelActivity.class);
        startActivity(intent);

    }

    public void gpClicked (View view){
        // Launch the VCS Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),GpMakeModelActivity.class);
        startActivity(intent);



    }

    public void ndbClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NDBSAC100.class);
        startActivity(intent);



    }

    public void locatorClicked (View view){
        // Launch the UAH Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),NDBSAC100.class);
        startActivity(intent);

    }

    public void markerClicked (View view){
        // Launch the ADSB Equipment Room Activity
        //Intent intent = new Intent(getApplicationContext(),ADSBMakeModelActivity.class);
       // startActivity(intent);



    }

    public void others1Clicked (View view){
        // Launch the Others Equipment Room Activity



    }
}