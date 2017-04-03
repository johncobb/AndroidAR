package com.example.jcobb.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//https://github.com/cplain/augmented-reality-tutorial

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private SensorManager senseSensorManager;
    private Sensor senseSensor;
    private LocationManager locationLocationManager;
    private LocationProvider locationLocationProvider;

    Button buttonClickMe;
    TextView textViewHelloWorld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tell it to use activity_main as the layout
        setContentView(R.layout.activity_main);

        senseSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senseSensor = (Sensor) senseSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        locationLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationLocationProvider = locationLocationManager.getProvider(locationLocationManager.getBestProvider(Criteria.ACCURACY_FINE, true));



        buttonClickMe = (Button) findViewById(R.id.buttonClickMe);
        textViewHelloWorld = (TextView) findViewById(R.id.textViewHelloWorld);

        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHelloWorld.setText(R.string.change_text_to);

                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final SensorEventListener mListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            Log.d(TAG, "sensorChanged (" + event.values[0] + ", " + event.values[1] );

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        senseSensorManager.registerlistener(null, senseSensor, SensorManager.SENSOR_DELAY_GAME);



    }


}
