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
    private Map<String, TextView> map = new HashMap<String, TextView>();
    private float conversionFactor = 1;


    Calculator(TextView from, TextView to){
        this.active =  from;
        this.active.setTypeface(null, Typeface.BOLD);
        map.put(Integer.toString(from.getId()), from);
        map.put(Integer.toString(to.getId()), to);
    }

    public void setActive(TextView activate){
        this.active.setTypeface(null, Typeface.NORMAL);
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

    public void SetMultiplier(float multiplier){
        this.conversionFactor = multiplier;
        this.CalculateValue();
    }

    public void AddToValue(int value) {
        this.active.setText(( !this.active.getText().toString().equals("0") ) ? this.active.getText() + Integer.toString(value) : Integer.toString(value));
        this.CalculateValue();
    }

    public void CalculateValue(){
        for(Map.Entry<String, TextView> entry : map.entrySet()) {
           if ( !entry.getKey().equals(Integer.toString(active.getId())) ) {
             entry.getValue().setText( Float.toString(Float.parseFloat((String) active.getText()) * this.conversionFactor) );
           }
        }
    }

    public void Clear(){

        for(Map.Entry<String, TextView> entry : this.map.entrySet()) {
            entry.getValue().setText("0");
            Log.i("Clearing", Integer.toString(entry.getValue().getId()));
        }


    }
}
