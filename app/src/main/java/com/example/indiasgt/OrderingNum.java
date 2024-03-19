package com.example.indiasgt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderingNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_num);

        Button btnordering = findViewById(R.id.generateordernum);
        Button btnsubmit = findViewById(R.id.submit);

        EditText etasc = findViewById(R.id.asclist);
        EditText etdes = findViewById(R.id.deslist);

        TextView tvasc = findViewById(R.id.answerasc);
        TextView tvdes = findViewById(R.id.answerdes);
        TextView display = findViewById(R.id.display);




        btnordering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generateRandomNumber(etasc,etdes);

                display.setText("");
                tvasc.setText("");
                tvdes.setText("");
            }

        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ascList = etasc.getText().toString();
                String desList = etdes.getText().toString();

                if(TextUtils.isEmpty(ascList) && TextUtils.isEmpty(desList)){
                    display.setText("Please click the generate number button to get the numbers");
                    return;
                }
                display.setText("");

                String ascText = tvasc.getText().toString();
                String desText = tvdes.getText().toString();

                if(TextUtils.isEmpty(ascText) && TextUtils.isEmpty(desText))
                {
                    display.setText("Please key in the ascending order and descending order answer");
                    return;
                }
                else if(TextUtils.isEmpty(ascText)){
                    display.setText("Please key in the ascending order answer");
                    return;
                }else if (TextUtils.isEmpty(desText)){
                    display.setText("Please key in the descending order answer");
                    return;
                }else{
                    checkAnswers(etasc, etdes, tvasc, tvdes, display);
                }

            }
        });

    }

    private void generateRandomNumber(EditText etasc, EditText etdes){

        final Random randomnum = new Random();

        int[] asclist = new int[5];
        int[] deslist = new int[5];
        int asctemp;
        int destemp;

        Arrays.fill(asclist,0);
        for(int i = 0; i<5 ; i++){
            do{
                asctemp = 1 + randomnum.nextInt(50);
            }while(contains(asclist,asctemp));

            asclist[i] = asctemp;
        }

        String ascques = "";
        for (int i = 0; i < 5; i++) {
            ascques += asclist[i];
            if (i < 4) {
                ascques += " , ";
            }
        }
        etasc.setText(ascques);

        for (int i = 0; i < 5; i++) {

            do {
                destemp = 1 + randomnum.nextInt(50);
            } while (contains(deslist, destemp));
            deslist[i] = destemp;
        }
        String desques = "";
        for (int i = 0; i < 5; i++) {
            desques += deslist[i];
            if (i < 4) {
                desques += " , ";
            }
        }
        etdes.setText(desques);

    }
    //boolean ascResult = true;
    private void checkAnswers(EditText etasc, EditText etdes, TextView tvasc, TextView tvdes, TextView display){


        String ascText = tvasc.getText().toString();
        String desText = tvdes.getText().toString();

        String[] ascArray = ascText.split(",");
        String[] desArray = desText.split(",");

        int[] ascInt = new int[ascArray.length];
        int[] desInt = new int[desArray.length];

        //checking answer for ascending order
        for (int i = 0; i < ascArray.length; i++) {
            ascInt[i] = Integer.parseInt(ascArray[i].trim());
        }


        boolean ascResult = isAscending(ascInt);
        if (ascResult) {
            display.setText("Ascending: Correct");
        } else {
            display.setText("Ascending: Wrong");
        }

        //checking answer for descending order
        for (int i = 0; i < desArray.length; i++) {
            desInt[i] = Integer.parseInt(desArray[i].trim());
        }

        boolean desResult = isDescending(desInt);

        String currentDisplayText = display.getText().toString();
        if (desResult) {
            display.setText(currentDisplayText + "\nDescending: Correct");
        } else {
            display.setText(currentDisplayText + "\nDescending: Wrong");
        }

//        if (ascResult || desResult) {
//            display.setText("Both Ascending and Descending: Correct, Congratulation !!!");
//        } else {
//            display.setText("At least one order is Wrong, Please Try Again !!!");
//        }
    }

    private boolean contains(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    private boolean isAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }


}