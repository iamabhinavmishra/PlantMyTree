package com.project.plantmtytree.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.project.plantmtytree.R;

public class locationsAdapter extends FirebaseRecyclerAdapter<
        locations, locationsAdapter.locationsViewholder> {

    public locationsAdapter(@NonNull FirebaseRecyclerOptions<locations> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull locationsViewholder holder, int position, @NonNull locations model) {
        holder.orderId.setText(model.getOrderId());
        holder.plantId.setText(model.getPlantId());
        holder.address1.setText(model.getAddress1());
        holder.address2.setText(model.getAddress2());
        holder.address3.setText(model.getAddress3());
        holder.pinCode.setText(model.getPinCode());
        holder.updatedBy.setText(model.getUpdatedBy());

    }

    @NonNull
    @Override
    public locationsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.locations, parent, false);
        return new locationsAdapter.locationsViewholder(view);
    }
    public class locationsViewholder extends RecyclerView.ViewHolder {
        TextView orderId,plantId,address1,address2,address3,pinCode,updatedBy;
        public locationsViewholder(@NonNull View itemView)
        {
            super(itemView);

            orderId = itemView.findViewById(R.id.get_orderid);
            plantId = itemView.findViewById(R.id.get_plantid);
            address1 = itemView.findViewById(R.id.get_address1);
            address2 = itemView.findViewById(R.id.get_address2);
            address3 = itemView.findViewById(R.id.get_address3);
            pinCode = itemView.findViewById(R.id.get_pincode);
            updatedBy = itemView.findViewById(R.id.get_updatedBy);

        }
    }
}
