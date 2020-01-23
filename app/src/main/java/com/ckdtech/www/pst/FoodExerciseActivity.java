package com.ckdtech.www.pst;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class FoodExerciseActivity extends AppCompatActivity implements View.OnClickListener {

        CardView cv1;
        CardView cv2;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_exercise_activity);

        cv1=(CardView) findViewById(R.id.cardView1);
        cv1.setOnClickListener(this);

        cv2=(CardView) findViewById(R.id.cardView2);
        cv2.setOnClickListener(this);

        }


@Override
public void onClick(View v){

        if (v.getId() == R.id.cardView1){
        Toast.makeText(this, "Food Pressed", Toast.LENGTH_SHORT).show();
        Intent a = new Intent(FoodExerciseActivity.this,FoodActivity.class);
        startActivity(a);

        }

        if (v.getId() == R.id.cardView2){
        Toast.makeText(this, "Exercises Pressed", Toast.LENGTH_SHORT).show();
        Intent a = new Intent(FoodExerciseActivity.this,ExerciseActivity.class);
        startActivity(a);
        }


        }

        }

