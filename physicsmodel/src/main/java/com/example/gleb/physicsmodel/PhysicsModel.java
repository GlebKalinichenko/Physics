package com.example.gleb.physicsmodel;

/**
 * Created by Gleb on 16.10.2015.
 */
public class PhysicsModel {
    public static final String TAG = "Tag";
    private double G = 9.81;

    /**
     * Calculation max heigth in radians
     * @param double speed    Speed of body
     * @param double rad      Angle in radias
     * @return double         Max heigth
     * */
    public double calcHeigthRad(double speed, double rad){
        //heigth = (speed^2 * sin^2)/2G
        return ((speed * speed) * (Math.sin(rad) * Math.sin(rad))) / (2 * G);//heigth in radians
    }

    /**
     * calculation max heigth in degrees
     * @param double speed    Speed of body
     * @param double rad      Angle in degrees
     * @return double         Max heigth
     * */
    public double calcHeigthDegree(double speed, double angle){
        //heigth = (speed^2 * sin(rad)^2) / 2G rad - fromDegreeToRad
        return ((speed * speed) * (Math.sin(fromDegreeToRad(angle, 1)) * Math.sin(fromDegreeToRad(angle, 1)))) / (2 * G);
    }

    /**
     * calculation max distance in radians
     * @param double speed    Speed of body
     * @param double rad      Angle in radias
     * @return double         Max distance
     * */
    public double calcDistanceRad(double speed, double rad){
        //distance = (speed^2 * sin(2*rad)) / G
        return ((speed * speed) * Math.sin(2 * rad)) / G;
    }

    /**
     * calculation max distance in degrees
     * @param double speed    Speed of body
     * @param double rad      Angle in degrees
     * @return double         Max distance
     * */
    public double calcDistanceDegree(double speed, double angle){
        //distance = (speed^2 * sin(rad)^2) / G, rad - fromDegreeToRad
        return ((speed * speed) * Math.sin(fromDegreeToRad(angle, 2))) / G;
    }

    /**
     * transformation angle from degree to rad
     * @param double angle       Angle in degree
     * @return double            Angle in rad
     * */
    public double fromDegreeToRad(double angle, int coefAngle){
        return Math.toRadians(coefAngle * angle);
    }
}
