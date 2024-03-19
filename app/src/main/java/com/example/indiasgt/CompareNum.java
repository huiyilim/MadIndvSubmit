package com.example.indiasgt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class CompareNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_num);

        Button btn = findViewById(R.id.generatenum);
        Button btnlarger = findViewById(R.id.btnlarger);
        Button btnsmaller = findViewById(R.id.btnsmaller);
        EditText et1 = findViewById(R.id.num1);
        EditText et2 = findViewById(R.id.num2);
        TextView tv = findViewById(R.id.result);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int val = random.nextInt(100);
                int val2 = random.nextInt(100);
                et1.setText(Integer.toString(val));
                et2.setText(Integer.toString(val2));


                tv.setText("");
            }

        });

        btnlarger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = et1.getText().toString();
                String num2 = et2.getText().toString();

                if(TextUtils.isEmpty(num1) && TextUtils.isEmpty(num2)){
                    tv.setText("Please click the generate number button to get the numbers");
                    return;
                }



                int value1 = Integer.parseInt(num1);
                int value2 = Integer.parseInt(num2);

                if(value1 > value2){
                    tv.setText("CORRECT ANSWER");
                }else {
                    tv.setText("INCORRECT ANSWER" + "\n" + num1+ " is smaller than " + num2 );
                }

            }
        });

        btnsmaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = et1.getText().toString();
                String num2 = et2.getText().toString();

                if(TextUtils.isEmpty(num1) && TextUtils.isEmpty(num2)){
                    tv.setText("Please click the generate number button to get the numbers");
                    return;
                }

                int value1 = Integer.parseInt(num1);
                int value2 = Integer.parseInt(num2);

                if(value1 < value2){
                    tv.setText("CORRECT ANSWER");
                }else {
                    tv.setText("INCORRECT ANSWER" + "\n" + num1+ " is larger than " + num2 );
                }

            }
        });
    }


}