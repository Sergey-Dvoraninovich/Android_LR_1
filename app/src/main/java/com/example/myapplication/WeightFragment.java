package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.icu.number.Precision;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.R.layout;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

//import static android.R.layout.*;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeightFragment extends android.app.Fragment {

    private WeightFragment.OnFragmentSellListener mListenerData;
    private double kf = 1;
    private String position = "top";
    public Conversion conv = new Conversion("Null", "Null", "Null", 1.0, 1.0, 1.0);

    private ClipboardManager clipboardManager;
    private ClipData clipData;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeightFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeightFragment newInstance(String param1, String param2) {
        WeightFragment fragment = new WeightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
        //Button button_change = (Button) findViewById(R.id.button_change);
        //button_change.setOnClickListener(this);
    }

    public String[] values = {"Val1", "Val2", "Val3"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        updateData();

        final EditText line_top = (EditText) view.findViewById(R.id.textView_top);
        line_top.setInputType(InputType.TYPE_NULL);
        final EditText line_down = (EditText) view.findViewById(R.id.textView_down);
        line_down.setInputType(InputType.TYPE_NULL);

        Spinner spinner_top = (Spinner) view.findViewById(R.id.spinner_top);
        ArrayAdapter<String> adapter_top = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, conv.getValues());
        adapter_top.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_top.setAdapter(adapter_top);

        Spinner spinner_down = (Spinner) view.findViewById(R.id.spinner_down);
        ArrayAdapter<String> adapter_down = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, conv.getValues());
        adapter_down.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_down.setAdapter(adapter_down);
        spinner_down.setSelection(1);

        spinner_top.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                setConv();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinner_down.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                setConv();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ImageButton button_change = (ImageButton) view.findViewById(R.id.button_change);
        button_change.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text_top = (EditText) getView().findViewById(R.id.textView_top);
                EditText text_down = (EditText) getView().findViewById(R.id.textView_down);
                Spinner spinner_top = (Spinner) getView().findViewById(R.id.spinner_top);
                Spinner spinner_down = (Spinner) getView().findViewById(R.id.spinner_down);
                int id = (int) spinner_top.getSelectedItemId();
                spinner_top.setSelection((int) spinner_down.getSelectedItemId());
                spinner_down.setSelection(id);
                text_top.setText(text_down.getText());
                setConv();
            }
        });

        Button button_copy_top = (Button) view.findViewById(R.id.button_copy_top);
        button_copy_top.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "nothing";
                if (line_top.getText().toString() != "") {
                    clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    text = line_top.getText().toString();
                    clipData = ClipData.newPlainText("text", text);
                    clipboardManager.setPrimaryClip(clipData);
                }
                text += " was copied";
                Toast toast = Toast.makeText(getActivity().getBaseContext(), text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button button_copy_down = (Button) view.findViewById(R.id.button_copy_down);
        button_copy_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "nothing";
                if (line_down.getText().toString() != "") {
                    clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    text = line_down.getText().toString();
                    clipData = ClipData.newPlainText("text", text);
                    clipboardManager.setPrimaryClip(clipData);
                }
                text += " was copied";
                Toast toast = Toast.makeText(getActivity().getBaseContext(), text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setText(String item) {
        EditText view = (EditText) getView().findViewById(R.id.textView_top);
        if (item != "|")
            view.append(item);
        else
        {
            String text = view.getText().toString();
            String ans = "";
            if (text.length() != 0)
                ans = text.substring(0, text.length() - 1);
            view.setText(ans);
        }
        setConv();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setData(Conversion conv) {
        this.conv = conv;
    }

    interface OnFragmentSellListener {
        void onFragmentSell();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListenerData = (WeightFragment.OnFragmentSellListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentSellListener");
        }
    }

    public void updateData() {
        mListenerData.onFragmentSell();
    }

    public void setConv()
    {
        EditText text_top = (EditText) getView().findViewById(R.id.textView_top);
        EditText text_down = (EditText) getView().findViewById(R.id.textView_down);
        Spinner spinner_top = (Spinner) getView().findViewById(R.id.spinner_top);
        Spinner spinner_down = (Spinner) getView().findViewById(R.id.spinner_down);
        double num;
        String ans_text = "";
        if (text_top.getText().toString() != "") {
            try {
                num = Double.parseDouble(text_top.getText().toString());
                double ans = conv.Convert(spinner_top.getSelectedItem().toString(), spinner_down.getSelectedItem().toString(), num);
                double ans_double = (double)Math.round(ans * 1000000);
                ans_double /= 1000000;
                ans_text = Double.toString(ans_double);

            } catch (Exception e) {
                ans_text = "";
            }
        }
        text_down.setText(ans_text);
    }
}