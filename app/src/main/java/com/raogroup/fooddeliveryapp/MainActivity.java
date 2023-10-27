package com.raogroup.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;

import com.raogroup.fooddeliveryapp.Adapters.Cg_Item_adapter;
import com.raogroup.fooddeliveryapp.Adapters.Rc_Item_Adapter;
import com.raogroup.fooddeliveryapp.Models.Cg_Item_Model;
import com.raogroup.fooddeliveryapp.Models.Rc_Item_Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,rc_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.categories_recycler);
        rc_recyclerView = findViewById(R.id.rc_recyclerView);

        ArrayList<Cg_Item_Model>list = new ArrayList<>();
        ArrayList<Rc_Item_Model>rc_list = new ArrayList<>();

        list.add(new Cg_Item_Model(R.drawable.burger,"Burger"));
        list.add(new Cg_Item_Model(R.drawable.cat_1,"Burger"));
        list.add(new Cg_Item_Model(R.drawable.cat_2,"Burger"));
        list.add(new Cg_Item_Model(R.drawable.cat_3,"Burger"));
        list.add(new Cg_Item_Model(R.drawable.cat_4,"Burger"));
        list.add(new Cg_Item_Model(R.drawable.cat_5,"Burger"));

        Cg_Item_adapter adapter = new Cg_Item_adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);

        rc_list.add(new Rc_Item_Model(R.drawable.pizza1,"Pizza","23"));
        rc_list.add(new Rc_Item_Model(R.drawable.pizza3,"Pizza","24"));
        rc_list.add(new Rc_Item_Model(R.drawable.burger,"Burger","20"));
        rc_list.add(new Rc_Item_Model(R.drawable.cat_3,"pizza","13"));
        rc_list.add(new Rc_Item_Model(R.drawable.cat_1,"pizza","25"));
        rc_list.add(new Rc_Item_Model(R.drawable.cat_5,"pizza","30"));

        Rc_Item_Adapter rc_adapter = new Rc_Item_Adapter(rc_list,this);
        rc_recyclerView.setAdapter(rc_adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rc_recyclerView.setLayoutManager(layoutManager);
    }
}