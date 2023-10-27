package com.raogroup.fooddeliveryapp.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raogroup.fooddeliveryapp.Details;
import com.raogroup.fooddeliveryapp.Models.Rc_Item_Model;
import com.raogroup.fooddeliveryapp.R;

import java.util.ArrayList;

public class Rc_Item_Adapter extends RecyclerView.Adapter<Rc_Item_Adapter.myViewHolder>{

    ArrayList<Rc_Item_Model>list;
    Context context;

    public Rc_Item_Adapter(ArrayList<Rc_Item_Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rc_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        Rc_Item_Model model = list.get(position);

        holder.rc_img.setImageResource(model.getPic());
        holder.price.setText("$"+model.getPrice());
        holder.name.setText(model.getItem_name());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Details.class);
                intent.putExtra("title",model.getItem_name());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("img",model.getPic());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView rc_img,add;
        TextView price,name;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            add = itemView.findViewById(R.id.add_cart);
            rc_img = itemView.findViewById(R.id.rc_item);
            price = itemView.findViewById(R.id.item_price);
            name = itemView.findViewById(R.id.rc_item_name);

        }
    }

}
