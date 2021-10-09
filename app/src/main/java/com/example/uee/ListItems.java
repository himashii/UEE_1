package com.example.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListItems extends AppCompatActivity {

    TextView name, price;
    Button btn;
    ImageView imageView;
    DatabaseReference ref;
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        imageView = findViewById(R.id.images);
        btn = findViewById(R.id.buy);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        imageView.setImageResource(intent.getIntExtra("images",0));

        items = new Items();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref = FirebaseDatabase.getInstance().getReference().child("Snacka");

                items.setName(name.getText().toString().trim());
                items.setPrice(price.getText().toString().trim());

                ref.push().setValue(items);

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Successfully added!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}