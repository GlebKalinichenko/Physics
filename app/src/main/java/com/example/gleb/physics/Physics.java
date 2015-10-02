package com.example.gleb.physics;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Physics extends Activity {
    public static final String TAG = "Tag";
    public EditText speedEditText;
    public EditText angleEditText;
    public CheckBox radCheckBox;
    public CheckBox angleCheckBox;
    public Button calcButton;
    private PhysicsModel physics;
    private double heigth;
    private double distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        speedEditText = (EditText) findViewById(R.id.speedEditText);
        angleEditText = (EditText) findViewById(R.id.angleEditText);
        calcButton = (Button) findViewById(R.id.calcButton);
        radCheckBox = (CheckBox) findViewById(R.id.radCheckBox);
        angleCheckBox = (CheckBox) findViewById(R.id.angleCheckBox);

//        double value = Math.sin(Math.toRadians(30.0));
//        double values = Math.sin(Math.toRadians(45.0));
//        Log.d(TAG, String.valueOf(value));
//        Log.d(TAG, String.valueOf(values));

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (angleCheckBox.isChecked() && radCheckBox.isChecked()) {
                    Toast.makeText(Physics.this, "Одновременно  нельзя ", Toast.LENGTH_LONG).show();
                } else {
                    if (radCheckBox.isChecked() && !speedEditText.getText().toString().equals("") && !angleEditText.getText().toString().equals("")) {
                        physics = new PhysicsModel();
                        heigth = physics.calcHeigthRad(Double.parseDouble(speedEditText.getText().toString()), Double.parseDouble(angleEditText.getText().toString()));
                        distance = physics.calcDistanceRad(Double.parseDouble(speedEditText.getText().toString()), Double.parseDouble(angleEditText.getText().toString()));
                        Log.d(TAG, "Heigth " + String.valueOf(heigth));
                        Log.d(TAG, "Distance " + String.valueOf(distance));
                        Toast.makeText(Physics.this, "Height: " + heigth + " Distance: " + distance, Toast.LENGTH_LONG).show();
                    }

                    if (angleCheckBox.isChecked() && !speedEditText.getText().toString().equals("") && !angleEditText.getText().toString().equals("")) {
                        physics = new PhysicsModel();
                        heigth = physics.calcHeigthAngle(Double.parseDouble(speedEditText.getText().toString()), Double.parseDouble(angleEditText.getText().toString()));
                        distance = physics.calcDistanceAngle(Double.parseDouble(speedEditText.getText().toString()), Double.parseDouble(angleEditText.getText().toString()));
                        Log.d(TAG, "Heigth " + String.valueOf(heigth));
                        Log.d(TAG, "Distance " + String.valueOf(distance));
                        Toast.makeText(Physics.this, "Height: " + heigth + " Distance: " + distance, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_physics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
