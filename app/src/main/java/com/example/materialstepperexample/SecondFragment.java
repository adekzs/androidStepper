package com.example.materialstepperexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ikhiloyaimokhai.nigeriastatesandlgas.Nigeria;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SecondFragment extends Fragment implements BlockingStep {

    private CardView informationtech, estate;
    public static String mservice;
    private  String category;
    private int checker;
    private TextView serviceSelected;
    ListView listView;
    TextView textView, count;
    TextView heading;;
    String[] listItem;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_second, container, false);





        informationtech = (CardView) v.findViewById(R.id.informationtech);
        estate = (CardView) v.findViewById(R.id.real_estate);
        serviceSelected = (TextView) v.findViewById(R.id.Vocation_holder);

        informationtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Information Technology";
                checker = 1;
                showBottom();
            }
        });

        estate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Real Estate";
                checker = 2;
                showBottom();
            }
        });


        return  v;
    }




    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.goToNextStep();
            }
        }, 1000L);
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        Toast.makeText(this.getContext(), "Your custom back action. Here you should cancel currently running operations", Toast.LENGTH_SHORT).show();
        callback.goToPrevStep();
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
    private  void showBottom(){
        // to popup the bottom dialog page to select a particular service
        View view = getLayoutInflater().inflate(R.layout.specific_services, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(view);

        heading = (TextView) dialog.findViewById(R.id.categoryHeading);
        heading.setText(category);

        listView=(ListView)dialog.findViewById(R.id.listView);
        textView=(TextView)dialog.findViewById(R.id.Vocation_holder);
        if (checker == 1){
            listItem = getResources().getStringArray(R.array.array_technology);
        }else {
            listItem = getResources().getStringArray(R.array.real_estate);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stubb
                String value=adapter.getItem(position);
                Toast.makeText(getContext(),value,Toast.LENGTH_SHORT).show();
                serviceSelected.setText(value);
                dialog.dismiss();

            }
        });


        dialog.setCancelable(true);
        dialog.show();

    }


}
