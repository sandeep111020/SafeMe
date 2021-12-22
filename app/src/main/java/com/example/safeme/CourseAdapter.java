package com.example.safeme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CourseAdapter extends FirebaseRecyclerAdapter<CourseModel, com.example.safeme.CourseAdapter.myviewholder> {


    Context context;
    private DatabaseReference databaseReference;
    String totalprice;
    int i=1;
    int total=0;
    int itemcount=0;
    String itemkey;
    private DatabaseReference databaseRef5;


    public CourseAdapter(@NonNull FirebaseRecyclerOptions<CourseModel> options, Context context) {
        super(options);
        this.context = context;


    }




    @NonNull
    @Override
    public com.example.safeme.CourseAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_layout, parent, false);

        return new com.example.safeme.CourseAdapter.myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull CourseModel model) {
        //holder.image.setText("Link: "+model.getItemimage());


        holder.name.setText(" "+model.getTitle());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CourseActivity.class);
              ;
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });











    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView name, desc,price,delete,minus,plus,count;

        ImageView image;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.coursetitle);



        }
    }



}