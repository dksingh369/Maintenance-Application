package com.aaiaero.emaintenance;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button3;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    LocationManager locationManager;

    LocationListener locationListener;
    EditText usernameEditText, passwordEditText;

    String address = "";
    private Boolean locationFound;

    int firstTimeLocation = 1;

    TextView locationTextView;

    final String[] latLong = {""};

    Button scanButton;
    TextView textViewReply;

    public static String a_log = "";
    public static String latLong1;
    public static String userName;
    private LocationRequest locationRequest;

    private TextView textView;
    private final String TAG = "TextEditor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationFound = false;
        textViewReply = (TextView) findViewById(R.id.textViewReply);
        textViewReply.setVisibility(View.INVISIBLE);

        ParseUser.logOut();


        setTitle("AAI CNS Maintenance App");


        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);


        button3 = (Button) findViewById(R.id.button3);
        locationTextView = (TextView) findViewById(R.id.locationTextView);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        relativeLayout.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView.setOnClickListener(this);
        locationTextView.setOnClickListener(this);

        checkAndRequestPermissions();

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);

        getCurrentLocation();

        scanButton = findViewById(R.id.scanBtn);

        textView = (TextView) findViewById(R.id.textView);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                isKeyboardShown(textView.getRootView());
            }
        });


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void signUpButtonClicked(View view){
        Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(intent);
    }

    public void forgotButtonClicked(View view){
        Intent intent = new Intent(getApplicationContext(),ForgotPasswordActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.webGoogle:
                Intent intent = new Intent(getApplicationContext(),CheckSchedules.class);
                intent.putExtra("siteName", "https://www.google.com/");
                startActivity(intent);
                return true;
            case R.id.checkSchedules:
                Intent intent1 = new Intent(getApplicationContext(),CheckSchedules.class);
                intent1.putExtra("siteName", "http://emaintenance.epizy.com/public_html/parse_login/?i=1");
                startActivity(intent1);
                return true;
            case R.id.settings:
                Log.i("Menu item Selected","Settings");
                return true;
            case R.id.help:
                Log.i("Menu item Selected","Help");
                return true;
            default:
                return false;
        }
    }

    public void scanButtonClicked(View view){


        getCurrentLocation();

        if (locationFound){
            scanCode();
        } else Toast.makeText(this, "Wait for Location.", Toast.LENGTH_SHORT).show();



    }

    private void scanCode(){

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Searching for Logging Details.");
        integrator.initiateScan();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //a_log = "VEAT-Others";
                a_log = result.getContents();

                builder.setMessage("Log in as " + usernameEditText.getText().toString());

                //a_log = (result.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("Log In", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if( (usernameEditText.getText().toString() + "-Others").matches(a_log) ){

                            toNextIntent();

                        } else {

                            Toast.makeText(MainActivity.this, "Code & Station didn't match. Rescan your QR Code!", Toast.LENGTH_SHORT).show();

                        }

                    }
                }).setNegativeButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        scanCode();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
            else {
                Toast.makeText(this, "No Results", Toast.LENGTH_SHORT).show();
            }
        }else {


            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View view) {

        if ((view.getId() == R.id.relativeLayout || view.getId() == R.id.imageView2 ||
                view.getId() == R.id.imageView || view.getId() == R.id.locationTextView || view.getId() == R.id.imageView3 ) && isKeyboardShown(textView.getRootView())) {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

    }

    private void toNextIntent() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Verifying Username and Password"); // Setting Message
        progressDialog.setTitle("Logging You In Please Wait..."); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);

                    latLong1 = latLong[0];
                    Intent intent = new Intent(getApplicationContext(),PersonalDetailsActivity.class);
                    //intent.putExtra("latLong", latLong[0]);
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();


    }

    public void button3Pressed(View view) { //Login Button Pressed

        getCurrentLocation();

        if (locationFound) {

            if (checkAndRequestPermissions()) {

                userName = usernameEditText.getText().toString();

           /* if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {


                Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();

            } else {

                if (usernameEditText.getText().toString().matches("VEAT") && passwordEditText.getText().toString().matches("aai")) {

                    Log.i("Signup", "Login successful");

                    toNextIntent();

                } else {

                    Toast.makeText(MainActivity.this, "Username/Password Incorrect", Toast.LENGTH_SHORT).show();

                }


            }*/

                ParseUser.logInInBackground(usernameEditText.getText().toString() + "@aai.aero", passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null) {

                            Log.i("Signup", "Login successful");

                            toNextIntent();

                        } else {

                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            textViewReply.setVisibility(View.VISIBLE);
                            textViewReply.setText(e.getMessage());

                        }


                    }
                });
        /*Intent intent = new Intent(getApplicationContext(), PersonalDetailsActivity.class);

        startActivity(intent);*/

            }

        } else Toast.makeText(this, "Wait for Location.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                getCurrentLocation();
            }


        }




    }



    public boolean checkAndRequestPermissions() {
        int permissionCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int externalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readexternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (locationPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (externalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (readexternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }


        return true;
    }
/*
    public void userLocationStamped() {


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                if (true) {

                    latLong[0] = String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude());


                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                    try {

                        List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        if (listAddresses != null && listAddresses.size() > 0) {

                            //Log.i("PlaceInfo", listAddresses.get(0).toString());


                            if (listAddresses.get(0).getSubThoroughfare() != null) {

                                address += listAddresses.get(0).getSubThoroughfare() + " ";

                            }

                            if (listAddresses.get(0).getThoroughfare() != null) {

                                address += listAddresses.get(0).getThoroughfare() + ", ";

                            }

                            if (listAddresses.get(0).getLocality() != null) {

                                address += listAddresses.get(0).getLocality() + ", ";

                            }

                            if (listAddresses.get(0).getPostalCode() != null) {

                                address += listAddresses.get(0).getPostalCode() + ", ";

                            }

                            if (listAddresses.get(0).getCountryName() != null) {

                                address += listAddresses.get(0).getCountryName();

                            }

                            if (firstTimeLocation == 1) {
                                //Toast.makeText(MainActivity.this, "You appears to be at- " + address, Toast.LENGTH_LONG).show();
                                locationTextView.setText("You appears to be at- " + address);

                                firstTimeLocation = 0;
                            }

                        }

                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if (Build.VERSION.SDK_INT < 23) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        } else {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            } else {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            }

        }



    }
*/
    private boolean isKeyboardShown(View rootView) {
        /* 128dp = 32dp * 4, minimum button height 32dp and generic 4 rows soft keyboard */
        final int SOFT_KEYBOARD_HEIGHT_DP_THRESHOLD = 128;

        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        /* heightDiff = rootView height - status bar height (r.top) - visible frame height (r.bottom - r.top) */
        int heightDiff = rootView.getBottom() - r.bottom;
        /* Threshold size: dp to pixels, multiply with display density */
        boolean isKeyboardShown = heightDiff > SOFT_KEYBOARD_HEIGHT_DP_THRESHOLD * dm.density;

        Log.d(TAG, "isKeyboardShown ? " + isKeyboardShown + ", heightDiff:" + heightDiff + ", density:" + dm.density
                + "root view height:" + rootView.getHeight() + ", rect:" + r);

        return isKeyboardShown;
    }

    private void getCurrentLocation() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                if (isGPSEnabled()) {

                    LocationServices.getFusedLocationProviderClient(MainActivity.this)
                            .requestLocationUpdates(locationRequest, new LocationCallback() {
                                @Override
                                public void onLocationResult(@NonNull LocationResult locationResult) {
                                    super.onLocationResult(locationResult);

                                    LocationServices.getFusedLocationProviderClient(MainActivity.this)
                                            .removeLocationUpdates(this);

                                    if (locationResult != null && locationResult.getLocations().size() >0){

                                        int index = locationResult.getLocations().size() - 1;
                                        latLong[0] = String.valueOf(locationResult.getLocations().get(index).getLatitude()) + "," + String.valueOf(locationResult.getLocations().get(index).getLongitude());
                                        double latitude = locationResult.getLocations().get(index).getLatitude();
                                        double longitude = locationResult.getLocations().get(index).getLongitude();
                                        locationTextView.setText("Location:-" + latLong[0]);
                                        locationFound = true;


                                        //AddressText.setText("Latitude: "+ latitude + "\n" + "Longitude: "+ longitude);
                                    }
                                }
                            }, Looper.getMainLooper());

                } else {
                    turnOnGPS();
                }

            } else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    private void turnOnGPS() {



        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
                .checkLocationSettings(builder.build());

        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {

                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    Toast.makeText(MainActivity.this, "GPS is already tured on", Toast.LENGTH_SHORT).show();

                } catch (ApiException e) {

                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:

                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(MainActivity.this, 2);
                            } catch (IntentSender.SendIntentException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            //Device does not have location
                            break;
                    }
                }
            }
        });

    }

    private boolean isGPSEnabled() {
        LocationManager locationManager = null;
        boolean isEnabled = false;

        if (locationManager == null) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }

        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isEnabled;

    }

}
