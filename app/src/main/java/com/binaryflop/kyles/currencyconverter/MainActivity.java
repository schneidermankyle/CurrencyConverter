package com.binaryflop.kyles.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    protected Spinner fromCurreny;
    protected Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator((TextView) findViewById(R.id.fromValue), (TextView) findViewById(R.id.toValue));

        fromCurreny = (Spinner) findViewById(R.id.fromCurrency);
        fromCurreny.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing
            }
        });
    }

    public void Activate(View view) {

        calculator.setActive((TextView) view);

    }

    public void Calculate(View view) {
        Button clickedButton = (Button) view;

        calculator.CalculateValue(Integer.parseInt((String) clickedButton.getText()));
    }

    public void Clear(View view) {
        calculator.Clear();
    }

    public void Decimal(View view) {
        calculator.AddDecimal();
    }
//
//    public void Backspace(View view) {
//        calculator.Backspace();
//    }
}
