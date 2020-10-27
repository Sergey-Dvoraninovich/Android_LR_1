package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class activity_weight extends AppCompatActivity implements WeightKeyboardFragment.OnFragmentInteractionListener, WeightFragment.OnFragmentSellListener{

    private Conversion conv =  conv = new Conversion("Килограммы", "Фунты", "Унции", 2.2046226218, 35.2739619496, 16);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getIntent().getExtras();
        if(arguments != null){
            this.conv = (Conversion) arguments.getSerializable(Conversion.class.getSimpleName());
        }
        setContentView(R.layout.activity_weight);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onFragmentInteraction(String link) {
        WeightFragment fragment = (WeightFragment) getFragmentManager()
                .findFragmentById(R.id.fragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onFragmentSell() {
        WeightFragment fragment = (WeightFragment) getFragmentManager()
                .findFragmentById(R.id.fragment);
        if (fragment != null) {
            fragment.setData(this.conv);
        }
    }
}