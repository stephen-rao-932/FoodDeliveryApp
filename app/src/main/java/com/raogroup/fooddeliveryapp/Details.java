package com.raogroup.fooddeliveryapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView textView, price, item, incriminate, discriminant,total_price;
    int count = 1;
    int newPrice;
    LinearLayout layout;
    Bitmap bitmap;
    String encodeImage;
    String api = "";

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

        String pd_name = getIntent().getExtras().getString("title");
        String pd_price = getIntent().getExtras().getString("price");

        item.setText("" + count);
        price.setText("$ " +pd_price);
        textView.setText(pd_name);

        int image = getIntent().getIntExtra("img",0);
        bitmap = BitmapFactory.decodeResource(getResources(),image);//1st solution
        imageView.setImageBitmap(bitmap);

        //imageView.setImageResource(getIntent().getIntExtra("img", 0)); //2nd solution

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

                ProgressDialog dialog = new ProgressDialog(Details.this);
                dialog.setTitle("Loading..");
                dialog.setMessage("Added to card");
                dialog.show();
                String totalPrice = Integer.toString(newPrice);
                covertImage(bitmap);

                StringRequest request = new StringRequest(Request.Method.POST, api, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    dialog.hide();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.hide();
                        Toast.makeText(Details.this, ""+error, Toast.LENGTH_SHORT).show();

                    }
                }){

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> myParams = new HashMap<>();

                        myParams.put("image",encodeImage);
                        myParams.put("name",pd_name);
                        myParams.put("price",pd_price);
                        myParams.put("total",totalPrice);

                        return myParams;
                    }
                };

                RequestQueue queue = Volley.newRequestQueue(Details.this);
                queue.add(request);

                startActivity(new Intent(Details.this,Checkout.class));

            }
        });


    }

    private void covertImage(Bitmap img){

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] imgByte = stream.toByteArray();
        encodeImage = android.util.Base64.encodeToString(imgByte, Base64.DEFAULT);

    }
}