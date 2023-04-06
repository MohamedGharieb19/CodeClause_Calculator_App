package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

    }

    public void numberEvent(View view) {
        if (isNewOp)
            editText.setText("");
            isNewOp=false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.Btn1:
                number += "1";
                break;
            case R.id.Btn2:
                number += "2";
                break;
            case R.id.Btn3:
                number += "3";
                break;
            case R.id.Btn4:
                number += "4";
                break;
            case R.id.Btn5:
                number += "5";
                break;
            case R.id.Btn6:
                number += "6";
                break;
            case R.id.Btn7:
                number += "7";
                break;
            case R.id.Btn8:
                number += "8";
                break;
            case R.id.Btn9:
                number += "9";
                break;
            case R.id.Btn0:
                number += "0";
                break;
            case R.id.BtnDot:
                number += ".";
                break;
            case R.id.BtnPlusMiuns:
                number = "-"+number;
                break;
        }
        editText.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.BtnDivide:
                op = "/";
                break;
            case R.id.BtnMultiply:
                op = "X";
                break;
            case R.id.Btnplus:
                op = "+";
                break;
            case R.id.Btnsub:
                op = "-";
                break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;
        switch (op){
            case"+":
                result= Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case"-":
                result= Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case"X":
                result= Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case"/":
                result= Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result+"");
    }

    public void acEvent(View view) {
        editText.setText("0");
        isNewOp = true;
    }

    public void percentageEvent(View view) {
        double num = Double.parseDouble(editText.getText().toString())/100;
        editText.setText(num+"");
        isNewOp = true;
    }
}