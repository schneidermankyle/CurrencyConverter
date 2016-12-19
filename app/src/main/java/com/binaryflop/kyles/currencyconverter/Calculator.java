package com.binaryflop.kyles.currencyconverter;

import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kylei on 12/18/2016.
 */

public class Calculator {

    private TextView active;
    private Map<String, String> map = new HashMap<String, String>();
    private TextView fromValue;
    private TextView toValue;
    private String fromCurrency;
    private String toCurrency;

    private void updateValue(){

    }

    Calculator(TextView from, TextView to){
        this.active =  from;
        map.put(Integer.toString(from.getId()), "0");
        map.put(Integer.toString(to.getId()), "0");
    }

    public void Alert(){
        Log.i("Info", "Hello World");
    }

    public void setActive(TextView activate){
        this.active = activate;
        this.active.setTypeface(null, Typeface.BOLD);
        Log.i("Setting Active to", Integer.toString(this.active.getId()));
    }

    public void AddDecimal() {
        String value = (String) this.active.getText();
        if(value.indexOf('.') != -1)
            return;

        this.active.setText(value + ".");
    }

    public void CalculateValue(int value){
        Log.i("Current Value", (String) this.active.getText());
        this.active.setText(((String) this.active.getText() != "0" && this.active.getText() != (CharSequence) "0") ? this.active.getText() + Integer.toString(value) : Integer.toString(value));
    }

    public void Clear(){
        this.active.setText("0");
        Log.i("Clearing", Integer.toString(this.active.getId()));
    }
}
