package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOperatorButton(View view) {

        int pressID = view.getId();
        TextView curText = (TextView)findViewById(R.id.resultText);
        data1 = Double.parseDouble(curText.getText().toString());
        curText.setText("");

        if (pressID == R.id.btnAdd) {
            optr = Operator.add;
        } else if (pressID == R.id.btnMinus) {
            optr = Operator.minus;
        } else if (pressID == R.id.btnMultiply) {
            optr = Operator.multiply;
        } else if (pressID == R.id.btnDivide) {
            optr = Operator.divide;
        }

    }

    public void onClickNumericalButton(View view) {

        int pressID = view.getId();
        TextView curText = (TextView)findViewById(R.id.resultText);

        if (pressID == R.id.btn0) {
            curText.setText(curText.getText() + "0");
        } else if (pressID == R.id.btn01){
            curText.setText(curText.getText() + "1");
        } else if (pressID == R.id.btn02){
            curText.setText(curText.getText() + "2");
        } else if (pressID == R.id.btn03){
            curText.setText(curText.getText() + "3");
        } else if (pressID == R.id.btn04){
            curText.setText(curText.getText() + "4");
        } else if (pressID == R.id.btn05){
            curText.setText(curText.getText() + "5");
        } else if (pressID == R.id.btn06){
            curText.setText(curText.getText() + "6");
        } else if (pressID == R.id.btn07){
            curText.setText(curText.getText() + "7");
        } else if (pressID == R.id.btn08){
            curText.setText(curText.getText() + "8");
        } else if (pressID == R.id.btn09){
            curText.setText(curText.getText() + "9");
        } else if (pressID == R.id.btnDot){
            curText.setText(curText.getText() + ".");
        } else {
            curText.setText("ERROR");
            Log.d("Error", "Error: Unknown button pressed!");
        }

    }

    public void clearClick(View view) {
        TextView curText = (TextView)findViewById(R.id.resultText);
        curText.setText("");
        data1 = data2 = 0;
        optr = Operator.none;
    }

    public void btnResultClick(View view){

        if (optr == Operator.none){
            return;
        }

        TextView curText = (TextView)findViewById(R.id.resultText);
        data2 =  Double.parseDouble(curText.getText().toString());
        double result = 0;
        if (optr == Operator.add) {
            result = data1 + data2;
        } else if (optr == Operator.minus){
            result = data1 - data2;
        } else if (optr == Operator.minus){
            result = data1 - data2;
        } else if (optr == Operator.multiply){
            result = data1 * data2;
        } else if (optr == Operator.divide){
            result = data1 / data2;
        }

        optr = Operator.none;
        data1 = result;
        if(result - (int)result != 0)
            curText.setText( String.valueOf(result) );
        else
            curText.setText( String.valueOf((int)result));
    }
}