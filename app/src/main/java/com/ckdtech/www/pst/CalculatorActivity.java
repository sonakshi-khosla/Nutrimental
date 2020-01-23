package com.ckdtech.www.pst;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class CalculatorActivity  extends AppCompatActivity implements View.OnClickListener {

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        cv1=(CardView) findViewById(R.id.cardView1);
        cv1.setOnClickListener(this);

        cv2=(CardView) findViewById(R.id.cardView2);
        cv2.setOnClickListener(this);

        cv3=(CardView) findViewById(R.id.cardView3);
        cv3.setOnClickListener(this);

        cv4=(CardView) findViewById(R.id.cardView4);
        cv4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){

        if (v.getId() == R.id.cardView1){
            Toast.makeText(this, "Bmi And Calorie Pressed", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(CalculatorActivity.this,BmiCalculatorActivity.class);
            startActivity(a);

        }

        if (v.getId() == R.id.cardView2){
            Toast.makeText(this, "Steps Calculator Pressed", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(CalculatorActivity.this,StepsCalculatorActivity.class);
            startActivity(a);
        }


       if (v.getId() == R.id.cardView3){
            Toast.makeText(this, "Speedometer Pressed", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(CalculatorActivity.this,SpeedometerActivity.class);
            startActivity(a);
        }


        if (v.getId() == R.id.cardView4){
            Toast.makeText(this, "Water Reminder Pressed", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(CalculatorActivity.this,WaterReminderActivity.class);
            startActivity(a);
        }

        }

        }

