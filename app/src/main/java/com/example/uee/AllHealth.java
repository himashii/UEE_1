package com.example.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllHealth extends AppCompatActivity {

    ListView view;
    Button btn;
    String[] fruitNames = {"Masala Banana","Banana Chips","Potato Chips","Cressant Chips","Banana Chips","Kachori"};
    String[] fruitPrices = {"Rs.750/=","Rs.480/=","Rs.500/=","Rs.600/=","Rs.300/=","Rs.3500/="};
    int[] fruitImages = {R.drawable.snack,R.drawable.snack2,R.drawable.po,R.drawable.po1,R.drawable.po2,R.drawable.po3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_health);

        view = findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter();
        view.setAdapter(customAdapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListHealth.class);
                intent.putExtra("name",fruitNames[i]);
                intent.putExtra("price",fruitPrices[i]);
                intent.putExtra("images",fruitImages[i]);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data3,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.name);
            TextView price = view1.findViewById(R.id.price);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            price.setText(fruitPrices[i]);
            image.setImageResource(fruitImages[i]);
            return view1;
        }
    }
}