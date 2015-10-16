package com.example.gleb.physics;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gleb.physicsmodel.PhysicsModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Physics extends Activity {
    public static final String TAG = "Tag";
    private EditText speedEditText;
    private EditText angleEditText;
    private CheckBox radCheckBox;
    private CheckBox degreeCheckBox;
    private Button calcButton;
    private PhysicsModel physics;
    private double heigth;
    private double distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        //initialize widgets
        speedEditText = (EditText) findViewById(R.id.speedEditText);
        angleEditText = (EditText) findViewById(R.id.angleEditText);
        calcButton = (Button) findViewById(R.id.calcButton);
        radCheckBox = (CheckBox) findViewById(R.id.radCheckBox);
        degreeCheckBox = (CheckBox) findViewById(R.id.angleCheckBox);
        physics = new PhysicsModel();

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //value of speed of angle is empty
                if (speedEditText.getText().toString().equals("") && angleEditText.getText().toString().equals("")) {
                    Toast.makeText(Physics.this, "Значение скорости или угла не заданы", Toast.LENGTH_LONG).show();
                } else {
                    if ((degreeCheckBox.isChecked() && radCheckBox.isChecked()) || (!degreeCheckBox.isChecked() && !radCheckBox.isChecked())) {
                        Toast.makeText(Physics.this, "Одновременно  нельзя ", Toast.LENGTH_LONG).show();
                    } else {
                        if (radCheckBox.isChecked()) {
                            heigth = physics.calcHeigthRad(Double.parseDouble(speedEditText.getText().toString()),
                                    Double.parseDouble(angleEditText.getText().toString()));
                            distance = physics.calcDistanceRad(Double.parseDouble(speedEditText.getText().toString()),
                                    Double.parseDouble(angleEditText.getText().toString()));
                        }

                        if (degreeCheckBox.isChecked()) {
                            heigth = physics.calcHeigthDegree(Double.parseDouble(speedEditText.getText().toString()),
                                    Double.parseDouble(angleEditText.getText().toString()));
                            distance = physics.calcDistanceDegree(Double.parseDouble(speedEditText.getText().toString()),
                                    Double.parseDouble(angleEditText.getText().toString()));
                        }
                        Log.d(TAG, "Heigth " + String.valueOf(heigth));
                        Log.d(TAG, "Distance " + String.valueOf(distance));
                        Toast.makeText(Physics.this, "Height: " + heigth + " Distance: " + distance, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
