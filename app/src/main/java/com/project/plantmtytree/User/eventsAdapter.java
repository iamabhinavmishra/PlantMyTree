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

public class eventsAdapter extends FirebaseRecyclerAdapter<
        events, eventsAdapter.eventsViewholder> {



    public eventsAdapter(@NonNull FirebaseRecyclerOptions<events> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull eventsViewholder holder, int position, @NonNull events model) {
        holder.eventName.setText(model.getEventName());


        holder.eventId.setText(model.getEventId());


        holder.eventHandler.setText(model.getEventHandler());
    }

    @NonNull
    @Override
    public eventsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events, parent, false);
        return new eventsAdapter.eventsViewholder(view);
    }

    public class eventsViewholder extends RecyclerView.ViewHolder {
        TextView eventName,eventId,eventHandler;
        public eventsViewholder(@NonNull View itemView)
        {
            super(itemView);

            eventName = itemView.findViewById(R.id.get_eventname);
            eventId = itemView.findViewById(R.id.get_eventid);
            eventHandler = itemView.findViewById(R.id.get_eventhandler);
        }
    }




}
