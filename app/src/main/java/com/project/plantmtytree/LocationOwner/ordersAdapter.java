package com.project.plantmtytree.LocationOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.project.plantmtytree.R;
import com.project.plantmtytree.User.eventsAdapter;

public class ordersAdapter extends FirebaseRecyclerAdapter<
        orders, ordersAdapter.ordersViewholder> {

    public ordersAdapter(@NonNull FirebaseRecyclerOptions<orders> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ordersViewholder holder, int position, @NonNull orders model) {
        holder.orderId.setText(model.getOrderId());


        holder.name.setText(model.getName());


        holder.plantName.setText(model.getPlantName());
    }

    @NonNull
    @Override
    public ordersViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orders, parent, false);
        return new ordersAdapter.ordersViewholder(view);
    }

    public class ordersViewholder extends RecyclerView.ViewHolder {
        TextView orderId,name,plantName;
        public ordersViewholder(@NonNull View itemView)
        {
            super(itemView);

            orderId = itemView.findViewById(R.id.get_orderid);
            name = itemView.findViewById(R.id.get_username);
            plantName = itemView.findViewById(R.id.get_plantname);
        }
    }
}
