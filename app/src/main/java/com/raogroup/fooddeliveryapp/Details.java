package com.raogroup.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView textView, price, item, incriminate, discriminant,total_price;
    int count = 1,newPrice;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.item_image);
        textView = findViewById(R.id.item_name);
        price = findViewById(R.id.item_price);
        item = findViewById(R.id.item_count);
        incriminate = findViewById(R.id.item_incriminate);
        discriminant = findViewById(R.id.item_discriminant);
        layout = findViewById(R.id.linearLayout2);
        total_price = findViewById(R.id.total);

        item.setText("" + count);
        price.setText("$ " + getIntent().getExtras().getString("price"));
        textView.setText(getIntent().getExtras().getString("title"));
        imageView.setImageResource(getIntent().getIntExtra("img", 0));
        total_price.setText("$ "+getIntent().getExtras().getString("price"));

        incriminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                item.setText("" + count);
                String Value = getIntent().getExtras().getString("price");
                int priceValue = Integer.parseInt(Value);
                newPrice = priceValue*count;
                price.setText("$ "+newPrice);
                total_price.setText("$ "+newPrice);
            }
        });
        discriminant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count==1){
                    Toast.makeText(Details.this, "minimum 1 item", Toast.LENGTH_SHORT).show();
                    count = 1;
                    item.setText(""+count);
                }else {
                    count--;
                    item.setText("" + count);
                    String Value = getIntent().getExtras().getString("price");
                    int priceValue = Integer.parseInt(Value);
                    int fixPrice = newPrice-priceValue;
                    newPrice = fixPrice;
                    price.setText("$ "+fixPrice);
                    total_price.setText("$ "+newPrice);
                }

            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Details.this,Checkout.class));
            }
        });


    }
}