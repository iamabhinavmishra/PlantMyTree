package com.project.plantmtytree.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.plantmtytree.R;

import java.text.BreakIterator;



public class ViewEvent extends AppCompatActivity {

    private RecyclerView recyclerView;
    eventsAdapter  adapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Events");
        recyclerView = findViewById(R.id.event_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<events> options
                = new FirebaseRecyclerOptions.Builder<events>()
                .setQuery(reference, events.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new eventsAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

        adapter = new eventsAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

       
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

    public class events{
        private String eventname;
        private String eventid;
        private String eventprice;
        private String eventhandler;
        private String eventphone;

        public events() {}

        public String getEventname() {
            return eventname;
        }

        public void setEventname(String eventname) {
            this.eventname = eventname;
        }

        public String getEventid() {
            return eventid;
        }

        public void setEventid(String eventid) {
            this.eventid = eventid;
        }

        public String getEventprice() {
            return eventprice;
        }

        public void setEventprice(String eventprice) {
            this.eventprice = eventprice;
        }

        public String getEventhandler() {
            return eventhandler;
        }

        public void setEventhandler(String eventhandler) {
            this.eventhandler = eventhandler;
        }

        public String getEventphone() {
            return eventphone;
        }

        public void setEventphone(String eventphone) {
            this.eventphone = eventphone;
        }
    }

    public class eventsAdapter extends FirebaseRecyclerAdapter<
                events, eventsAdapter.eventsViewholder> {

        /**
         * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
         * {@link FirebaseRecyclerOptions} for configuration options.
         *
         * @param options
         */
        public eventsAdapter(@NonNull FirebaseRecyclerOptions<events> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(@NonNull eventsViewholder holder, int position, @NonNull events model) {
            holder.eventname.setText(model.getEventname());
            holder.eventid.setText(model.getEventid());
            holder.eventhandler.setText(model.getEventhandler());
            holder.eventphone.setText(model.getEventphone());
        }

        @NonNull
        @Override
        public eventsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view
                    = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.categories_card_design, parent, false);
            return new eventsAdapter.eventsViewholder(view);
        }

        public class eventsViewholder extends RecyclerView.ViewHolder {
            TextView eventname, eventid, eventhandler,eventphone;

            public eventsViewholder(@NonNull View itemView) {
                super(itemView);
                eventname = itemView.findViewById(R.id.event_fetch_title);
                eventid = itemView.findViewById(R.id.event_fetch_id);
                eventhandler = itemView.findViewById(R.id.event_fetch_handler);
                eventphone = itemView.findViewById(R.id.event_fetch_phone);
            }
        }
    }


}