package com.example.myapplication;

import java.io.Serializable;

public class Conversion implements Serializable {

    private String str_value_1;
    private String str_value_2;
    private String str_value_3;
    private double conv_1_to_2;
    private double conv_1_to_3;
    private double conv_2_to_3;

    public Conversion(String str_value_1, String str_value_2, String str_value_3,
                      double val1, double val2, double val3) {
        this.str_value_1 = str_value_1;
        this.str_value_2 = str_value_2;
        this.str_value_3 = str_value_3;
        this.conv_1_to_2 = val1;
        this.conv_1_to_3 = val2;
        this.conv_2_to_3 = val3;
    }

    public double Convert(String str_val_1, String str_val_2, double value)
    {
        if ((str_val_1 == this.str_value_1) && (str_val_2 == this.str_value_2))
            return value * conv_1_to_2;
        if ((str_val_2 == this.str_value_1) && (str_val_1 == this.str_value_2))
            return value * (1 / conv_1_to_2);

        if ((str_val_1 == this.str_value_1) && (str_val_2 == this.str_value_3))
            return value * conv_1_to_3;
        if ((str_val_2 == this.str_value_1) && (str_val_1 == this.str_value_3))
            return value * (1 / conv_1_to_3);

        if ((str_val_1 == this.str_value_2) && (str_val_2 == this.str_value_3))
            return value * conv_2_to_3;
        if ((str_val_2 == this.str_value_2) && (str_val_1 == this.str_value_3))
            return  value * conv_2_to_3;

        return value;
    }

    public String[] getValues()
    {
        return new String[] {this.str_value_1, this.str_value_2, this.str_value_3};
    }

    public String getStringValues()
    {
        return this.str_value_1 + " " + this.str_value_2 + " " + this.str_value_3;
    }

}
