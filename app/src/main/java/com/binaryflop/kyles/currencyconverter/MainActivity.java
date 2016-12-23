package com.binaryflop.kyles.currencyconverter;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.database.sqlite.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    protected Spinner fromCurreny;
    protected Calculator calculator;
    protected URL url;
    protected HttpURLConnection urlConnection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator((TextView) findViewById(R.id.fromValue), (TextView) findViewById(R.id.toValue));

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        fromCurreny = (Spinner) findViewById(R.id.fromCurrency);
        fromCurreny.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Here we need to construct something that handles our conversion rates
                Toast.makeText(getApplicationContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                try {
                    url = new URL("http://www.binaryflop.com");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line).append('\n');
                        Log.i("Line: ", line);
                    }

                    Log.i("Response: ", response.toString());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    urlConnection.disconnect();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing
            }
        });

        fromCurreny = (Spinner) findViewById(R.id.toCurrency);
        fromCurreny.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Here we need to construct something that handles our conversion rates
                Toast.makeText(getApplicationContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
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

        calculator.AddToValue(Integer.parseInt((String) clickedButton.getText()));
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
