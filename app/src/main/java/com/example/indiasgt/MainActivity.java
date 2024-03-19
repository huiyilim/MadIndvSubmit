package com.example.indiasgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button comparenum = findViewById(R.id.comparenum);
        Button orderingnum = findViewById(R.id.orderingnum);
        Button composingnum = findViewById(R.id.composingnum);

        comparenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CompareNum.class);
                startActivity(intent);
            }
        });

        orderingnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderingNum.class);
                startActivity(intent);
            }
        });

        composingnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ComposingNum.class);
                startActivity(intent);
            }
        });
    }


}