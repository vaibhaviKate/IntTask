package com.example.vaibhavi.forinternshala;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FirebaseItemAdapter extends RecyclerView.Adapter<FirebaseItemAdapter.ViewHolder>{
    static List<Users> users;
    private Context context;

    public FirebaseItemAdapter(List<Users> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public FirebaseItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userfirebase, parent, false);
        return new FirebaseItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FirebaseItemAdapter.ViewHolder holder,final int position) {

        holder.username.setText("Name : "+users.get(position).getName());
        holder.userage.setText("Age : "+users.get(position).getAge());
        holder.useruid.setText("UniqueID :"+users.get(position).getUid());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public TextView userage;
        public TextView useruid;

        public ViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            userage = itemView.findViewById(R.id.userage);
            useruid = itemView.findViewById(R.id.useruid);

        }
    }
}