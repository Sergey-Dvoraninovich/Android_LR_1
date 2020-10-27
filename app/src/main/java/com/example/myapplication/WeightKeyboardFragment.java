package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Button;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeightKeyboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeightKeyboardFragment extends android.app.Fragment {

    private OnFragmentInteractionListener mListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeightKeyboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeightKeyboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeightKeyboardFragment newInstance(String param1, String param2) {
        WeightKeyboardFragment fragment = new WeightKeyboardFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight_keyboard, container, false);
        Button button0 = (Button) view.findViewById(R.id.button_num_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("0");
            }
        });
        Button button1 = (Button) view.findViewById(R.id.button_num_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("1");
            }
        });
        Button button2 = (Button) view.findViewById(R.id.button_num_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("2");
            }
        });
        Button button3 = (Button) view.findViewById(R.id.button_num_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("3");
            }
        });
        Button button4 = (Button) view.findViewById(R.id.button_num_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("4");
            }
        });
        Button button5 = (Button) view.findViewById(R.id.button_num_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("5");
            }
        });
        Button button6 = (Button) view.findViewById(R.id.button_num_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("6");
            }
        });
        Button button7 = (Button) view.findViewById(R.id.button_num_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("7");
            }
        });
        Button button8 = (Button) view.findViewById(R.id.button_num_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("8");
            }
        });
        Button button9 = (Button) view.findViewById(R.id.button_num_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("9");
            }
        });
        Button dot_button = (Button) view.findViewById(R.id.button_dot);
        dot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(".");
            }
        });
        Button button_delete = (Button) view.findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("|");
            }
        });


        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_weight_keyboard, container, false);
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public void updateDetail(String data) {
        // генерируем некоторые данные
        String curDate = data;
        // Посылаем данные Activity
        mListener.onFragmentInteraction(curDate);
    }
}