package com.kagu.warehousecocoba.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kagu.warehousecocoba.R;
import com.kagu.warehousecocoba.model.Warehouse;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    List<Warehouse> warehouses;
    ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<Warehouse> warehouses, ItemClickListener itemClickListener) {
        this.context = context;
        this.warehouses = warehouses;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_warehouse,
                parent,false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        Warehouse warehouse = warehouses.get(position);
        holder.tv_codeWarehouse.setText(warehouse.getCodeWarehouse());
        holder.tv_nameItem.setText(warehouse.getNameItem());
    }

    @Override
    public int getItemCount() {
        return warehouses.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_codeWarehouse, tv_nameItem;
        CardView card_item;
        ItemClickListener itemClickListener;

        RecyclerViewAdapter(View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            tv_codeWarehouse = itemView.findViewById(R.id.tv_codeWarehouse);
            tv_nameItem = itemView.findViewById(R.id.tv_nameItem);
            card_item = itemView.findViewById(R.id.card_item);

            this.itemClickListener = itemClickListener;
            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
