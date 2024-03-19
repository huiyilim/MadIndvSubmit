package com.example.indiasgt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ComposingNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composing_num);

        Button btngenerated = findViewById(R.id.generatenumbers);
        Button btnsubmit = findViewById(R.id.btnsub);

        EditText Comq1 = findViewById(R.id.q1);

        TextView tv = findViewById(R.id.warningmessage);
        TextView tv2 = findViewById(R.id.display2);

        EditText q1a = findViewById(R.id.q1a);
        EditText q1b = findViewById(R.id.q1b);
        EditText q1 = findViewById(R.id.q1);
        TextView q1ans = findViewById(R.id.q1ans);

        btngenerated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //clear the textview content
                tv.setText("");


                Random random = new Random();

                int value = random.nextInt(50);
                q1.setText(Integer.toString(value));

                //clear all the input edit boxes
                q1a.setText("");
                q1b.setText("");

                tv.setText("");

                q1ans.setText("");
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "";

                String q1aText = q1a.getText().toString();
                String q1bText = q1b.getText().toString();
                String q1Text = q1.getText().toString();

                EditText[] editTexts = {Comq1};

                //check the empty field
                if (TextUtils.isEmpty(q1.getText().toString())) {
                    // Display a message if any field is empty
                    tv.setText("Please click the generate number button to get the numbers");
                    return;
                }



                // Parse the values to integers
                int q1aValue = Integer.parseInt(q1aText);
                int q1bValue = Integer.parseInt(q1bText);
                int q1Value = Integer.parseInt(q1Text);

                // Calculate the sum of q1a and q1b
                int sum = q1aValue + q1bValue;

                // Check if the sum is equal to q1
                if (sum == q1Value) {
                    // Display "TRUE" if the sum is equal to q1
                    q1ans.setText("TRUE");
                } else {
                    // Display "FALSE" if the sum is not equal to q1
                    q1ans.setText("FALSE");
                }


            }
        });



    }

}