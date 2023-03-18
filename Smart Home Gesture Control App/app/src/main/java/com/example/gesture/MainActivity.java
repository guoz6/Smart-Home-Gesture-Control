package com.example.gesture;
import android.Manifest;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.database.FirebaseDatabase;





public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//    private String requestPermissionArray[] = {
//        Manifest.permission.CAMERA,
//        Manifest.permission.MANAGE_EXTERNAL_STORAGE
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        String[] gestures = {"Please select ","Turn on lights", "Turn off lights", "Turn on fan", "Turn off fan", "Increase fan speed",
                "Decrease fan speed", "Set Thermostat to specified temperature", "0","1","2","3","4","5","6","7","8","9"};
        // Create an adapter for the spinner using the string array as options
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gestures);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the adapter for the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
//        ActivityCompat.requestPermissions(this, requestPermissionArray,0);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true); // if using Firebase Database
        FirebaseStorage.getInstance(); // if using Firebase Storage

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Start a new activity based on the selected item
        if(parent.getItemAtPosition(position).equals("Please select")){

        }
        else{
            String item = parent.getItemAtPosition(position).toString();
            if(parent.getItemAtPosition(position).equals("Turn on lights")){
                Intent intent = new Intent(MainActivity.this, TurnOnLightsActivity.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Turn off lights")){
                Intent intent = new Intent(MainActivity.this, TurnOffLightsActivity.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Turn on fan")){
                Intent intent = new Intent(MainActivity.this, TurnOnFan.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Turn off fan")){
                Intent intent = new Intent(MainActivity.this, TurnOffFan.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Increase fan speed" )){
                Intent intent = new Intent(MainActivity.this, IncreaseFanSpeed.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Decrease fan speed")){
                Intent intent = new Intent(MainActivity.this, DecreaseFanSpeed.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("Set Thermostat to specified temperature")){
                Intent intent = new Intent(MainActivity.this, Thermo.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("0")){
                Intent intent = new Intent(MainActivity.this, Zero.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("1")){
                Intent intent = new Intent(MainActivity.this, One.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("2")){
                Intent intent = new Intent(MainActivity.this, Two.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("3")){
                Intent intent = new Intent(MainActivity.this, Three.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("4")){
                Intent intent = new Intent(MainActivity.this, Four.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("5")){
                Intent intent = new Intent(MainActivity.this, Five.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("6")){
                Intent intent = new Intent(MainActivity.this, Six.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("7")){
                Intent intent = new Intent(MainActivity.this, Seven.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("8")){
                Intent intent = new Intent(MainActivity.this, Eight.class);
                startActivity(intent);
            }
            if(parent.getItemAtPosition(position).equals("9")){
                Intent intent = new Intent(MainActivity.this, Nine.class);
                startActivity(intent);
            }
                // Add cases for each of the other gestures

            }
        }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }


}