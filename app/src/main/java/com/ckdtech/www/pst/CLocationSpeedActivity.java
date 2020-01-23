package com.ckdtech.www.pst;

import android.location.Location;

public class CLocationSpeedActivity extends Location {

    private boolean bUseMetricUnits = false;

    public CLocationSpeedActivity(Location location){
        this(location,true);
    }

    public CLocationSpeedActivity(Location location,boolean bUseMetricUnits){
        super(location);
        this.bUseMetricUnits = bUseMetricUnits;
    }

    public boolean getUseMetricUnits(){
        return this.bUseMetricUnits;
    }
    public void setUseMetricUnits(boolean bUseMetricUnits){
        this.bUseMetricUnits = bUseMetricUnits;
    }

    @Override
    public float distanceTo(Location dest) {
        float nDistance = super.distanceTo(dest);

        if (!this.getUseMetricUnits()){
            // Now We Will Convert Metres To Feet
            nDistance = nDistance * 3.28083989501312f;
        }
        return nDistance;
    }

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();

        if (!this.getUseMetricUnits()){
            // Now We Will Convert Metres To Feet
            nAltitude = nAltitude * 3.28083989501312d;
        }
        return nAltitude;
    }

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed() * 3.6f;

        if (!this.getUseMetricUnits()){
            // Convert metres/second to miles/hour
            nSpeed = super.getSpeed() * 2.23693629f;
        }
        return nSpeed;
    }

    @Override
    public float getAccuracy() {
        float nAccuracy = super.getAccuracy();

        if (!this.getUseMetricUnits()){
            // Now We Will Convert Metres To Feet
            nAccuracy = nAccuracy * 3.28083989501312f;
        }
        return nAccuracy;
    }
}
