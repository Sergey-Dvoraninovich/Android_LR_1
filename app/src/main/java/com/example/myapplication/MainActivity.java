package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Conversion conv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_weight = (Button)findViewById(R.id.button_weignt);
        Button button_distance = (Button)findViewById(R.id.button_distance);
        Button button_currency = (Button)findViewById(R.id.button_currency);
        button_weight.setOnClickListener(this);
        button_distance.setOnClickListener(this);
        button_currency.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view){
        Intent i;
        i = new Intent(this, activity_weight.class);
        this.conv = new Conversion("Null", "Null", "Null", 1.0, 1.0, 1.0);

        switch (view.getId()){
            case R.id.button_weignt:
                this.conv = new Conversion("Килограммы", "Фунты", "Унции", 2.2046226218, 35.2739619496, 16);
                break;
            case R.id.button_distance:
                this.conv = new Conversion("Километры", "Мили", "Футы", 0.6213711922, 3280.8398950131, 5280);
                break;
            case R.id.button_currency:
                this.conv = new Conversion("BYN", "USD", "EUR", 0.3901829958, 0.331279401, 0.8490078511);
                break;
        }
        i.putExtra(Conversion.class.getSimpleName(), this.conv);
        startActivity(i);
    }
}

