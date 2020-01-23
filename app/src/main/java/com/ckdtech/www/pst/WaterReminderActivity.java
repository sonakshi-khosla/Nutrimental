package com.ckdtech.www.pst;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class WaterReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private int notificationId =1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_reminder_activity);

        // To Set On Click Listener.
        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);

        //To set notification Id & Text

        Intent intent = new Intent(WaterReminderActivity.this,AlarmReceiverActivity.class);
        intent.putExtra("Notification Id",notificationId);
        intent.putExtra("todo",editText.getText().toString());

        //Get Broadcast

        PendingIntent alarmIntent = PendingIntent.getBroadcast(WaterReminderActivity.this,0,intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm =(AlarmManager) getSystemService(ALARM_SERVICE);

       switch (v.getId()){
           case R.id.setBtn:
               int hour = timePicker.getCurrentHour();
               int minute = timePicker.getCurrentMinute();

               //Create Time

               Calendar startTime = Calendar.getInstance();
               startTime.setTimeZone(TimeZone.getTimeZone("IST"));
               startTime.set(Calendar.HOUR_OF_DAY,hour);
               startTime.set(Calendar.MINUTE,minute);
               startTime.set(Calendar.SECOND,0);
               long alarmStartTime = startTime.getTimeInMillis();

               //Set Alarm
               alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
               Toast.makeText(this,"Done!!",Toast.LENGTH_SHORT).show();
               break;

           case R.id.cancelBtn:
               alarm.cancel(alarmIntent);
               Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
               break;

       }


        }
    }

