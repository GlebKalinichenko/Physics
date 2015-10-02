package com.example.gleb.physics;

import android.util.Log;

/**
 * Created by Gleb on 08.09.2015.
 */
public class PhysicsModel {
    public static final String TAG = "Tag";
    public static final double g = 9.81;
    private double heigth;
    private double distance;
    private int angleGrad;
    private int speed;

    public double calcHeigthRad(double speed, double rad){
        double powerSin = Math.sin(rad) * Math.sin(rad);
        Log.d(TAG, String.valueOf(powerSin));
        double powerSpeed = speed * speed;
        double heigth = (powerSpeed * powerSin) / (2 * g);

        return heigth;
    }

    public double calcHeigthAngle(double speed, double angle){
        double rad = Math.toRadians(angle);
        Log.d(TAG, "Angle in rad " + String.valueOf(rad));
        double powerSin = Math.sin(rad) * Math.sin(rad);
        Log.d(TAG, "Sin angle " + String.valueOf(powerSin));
        double powerSpeed = speed * speed;
        Log.d(TAG, "Power speed " + String.valueOf(powerSpeed));
        double heigth = (powerSpeed * powerSin) / (2 * g);

        return heigth;
    }

    public double calcDistanceRad(double speed, double rad){
        double powerSin = Math.sin(2 * rad);
        Log.d(TAG, String.valueOf(powerSin));
        double powerSpeed = speed * speed;
        double heigth = (powerSpeed * powerSin) / g;

        return heigth;
    }

    public double calcDistanceAngle(double speed, double angle){
        double rad = Math.toRadians(2 * angle);
        Log.d(TAG, "Angle in rad in distance " + String.valueOf(rad));
        double powerSin = Math.sin(rad);
        Log.d(TAG, "Power sin angle in rad in distance " + powerSin);
        double powerSpeed = speed * speed;
        Log.d(TAG, "Power speed " + powerSpeed);
        double heigth = (powerSpeed * powerSin) / g;

        return heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getAngleGrad() {
        return angleGrad;
    }

    public void setAngleGrad(int angleGrad) {
        this.angleGrad = angleGrad;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
