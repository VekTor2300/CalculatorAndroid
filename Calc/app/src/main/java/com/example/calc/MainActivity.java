package com.example.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Ch;
    TextView De;
    double chislo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ch = findViewById(R.id.Chisla);
        getSupportActionBar().hide();
        De = findViewById(R.id.Deystvia);
    }

    public void Chislo(View view) {
        Button button = findViewById(view.getId());
        Ch.append(button.getText());
        if(Ch.getText().toString().contains(".")) Ch.setText(button.getText());
    }

    public void ClearAll(View view) {
        Ch.setText("");
        De.setText("");
    }

    public void Doing(View view) {
        try {
            Button button = findViewById(view.getId());
            if (button.getText().toString().contains("x")) {
                De.setText("В степень");
            } else De.setText(button.getText());
            if (Ch.getText() != "") chislo1 = Double.parseDouble(Ch.getText().toString());

            Ch.setText("");
        }
        catch (Exception ex){

        }
    }

    public void Ravnoe(View view) {
        Button button = findViewById(view.getId());
        try {
            if (Ch.getText().toString() != "" && De.getText().toString() != "" && Double.toString(chislo1) != "") {
                switch (De.getText().toString()) {
                    case "+":
                        chislo1 = chislo1 + Double.parseDouble(Ch.getText().toString());
                        break;
                    case "-":
                        chislo1 = chislo1 - Double.parseDouble(Ch.getText().toString());
                        break;
                    case "*":
                        chislo1 = chislo1 * Double.parseDouble(Ch.getText().toString());
                        break;
                    case "÷":
                        chislo1 = chislo1 / Double.parseDouble(Ch.getText().toString());
                        break;
                    case "В степень":
                        chislo1 = Math.pow(chislo1, Double.parseDouble(Ch.getText().toString()));
                        break;
                }
                Ch.setText(Double.toString(chislo1));
                De.setText("");

            }
        }
        catch (Exception ex){
        }
    }

    public void Modely(View view) {
        try {
            if(De.getText().toString()!="") De.setText("");
            if (Ch.getText().toString() != "") {
                chislo1 = Double.parseDouble(Ch.getText().toString());
                if (chislo1 < -1) chislo1 = chislo1 * -1;
                Ch.setText(Double.toString(chislo1));
            }
        }
        catch (Exception ex){ }
    }

    public void Korny(View view) {
        try {
            if(De.getText().toString()!="") De.setText("");
            if (Ch.getText().toString() != "") {
                chislo1 = Math.sqrt(Double.parseDouble(Ch.getText().toString()));
                Ch.setText(Double.toString(chislo1));
            }
        }
        catch (Exception ex){ }
    }

    public void Fackty(View view) {
        try {
            if(De.getText().toString()!="") De.setText("");
            if (Ch.getText().toString() != "") {
                chislo1 = Double.parseDouble(Ch.getText().toString());
                double ch = 1;
                for (double i = chislo1; i > 1; i--) {
                    ch *= i;
                }
                Ch.setText(Double.toString(ch));
            }
        }
        catch (Exception ex){ }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", Ch.getText().toString());
        outState.putString("value2", De.getText().toString());
        outState.putDouble("value3", chislo1);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Ch.setText(savedInstanceState.getString("value"));
        De.setText(savedInstanceState.getString("value2"));
        chislo1 = savedInstanceState.getDouble("value3");
    }
}