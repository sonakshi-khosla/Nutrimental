package com.ckdtech.www.pst;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class StepsCalculatorActivity extends AppCompatActivity implements SensorEventListener {

    TextView tv_steps;

    SensorManager sensorManager;

    boolean running  = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steps_calculator_activity);
        tv_steps = (TextView) findViewById(R.id.tv_steps);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
    Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    if (countSensor != null) {
        sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
    }else{
        Toast.makeText(this, "Sensor Not Found", Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running=false;

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running){
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
