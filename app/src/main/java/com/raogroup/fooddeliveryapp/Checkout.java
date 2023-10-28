package com.raogroup.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.raogroup.fooddeliveryapp.databinding.ActivityCheckoutBinding;

public class Checkout extends AppCompatActivity {

    ActivityCheckoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}