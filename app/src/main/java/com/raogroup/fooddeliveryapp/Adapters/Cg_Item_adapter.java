package com.raogroup.fooddeliveryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raogroup.fooddeliveryapp.Models.Cg_Item_Model;
import com.raogroup.fooddeliveryapp.R;

import java.util.ArrayList;

public class Cg_Item_adapter extends RecyclerView.Adapter<Cg_Item_adapter.myViewHolder> {

    ArrayList<Cg_Item_Model> list;
    Context context;

    public Cg_Item_adapter(ArrayList<Cg_Item_Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cg_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Cg_Item_Model model = list.get(position);

        holder.cg_img.setImageResource(model.getPic());
        holder.cg_title.setText(model.getItem_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView cg_img;
        TextView cg_title;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            cg_img = itemView.findViewById(R.id.cg_image);
            cg_title = itemView.findViewById(R.id.cg_item_name);

        }
    }

}
