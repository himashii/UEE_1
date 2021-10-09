package com.example.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListPooja extends AppCompatActivity {

    TextView name, price;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pooja);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        imageView = findViewById(R.id.images);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        imageView.setImageResource(intent.getIntExtra("images",0));
    }
}