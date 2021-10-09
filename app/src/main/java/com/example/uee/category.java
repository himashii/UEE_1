package com.example.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class category extends AppCompatActivity {

    Button btn, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btn = findViewById(R.id.snacks);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AllItems.class);
                startActivity(i);
            }
        });

        btn2 = findViewById(R.id.chilled);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AllChilled.class);
                startActivity(i);
            }
        });

        btn3 = findViewById(R.id.health);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AllHealth.class);
                startActivity(i);
            }
        });

        btn4 = findViewById(R.id.pooja);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AllPooja.class);
                startActivity(i);
            }
        });
    }
}