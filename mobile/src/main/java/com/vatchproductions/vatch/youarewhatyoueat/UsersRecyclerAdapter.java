package com.vatchproductions.vatch.youarewhatyoueat;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    private List<User> listUsers;

    UsersRecyclerAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textViewName.setText(listUsers.get(position).getName());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText(listUsers.get(position).getPassword());
        holder.textViewFoodName.setText(listUsers.get(position).getFoodName());
        holder.textViewFoodType.setText(listUsers.get(position).getFoodType());
        holder.textViewFoodCalCount.setText(listUsers.get(position).getFoodCalCount());
        holder.textViewFoodWeight.setText(listUsers.get(position).getFoodWeight());
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        public AppCompatTextView textViewFoodName;
        public AppCompatTextView textViewFoodType;
        public AppCompatTextView textViewFoodCalCount;
        public AppCompatTextView textViewFoodWeight;


        UserViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);
            textViewEmail = view.findViewById(R.id.textViewEmail);
            textViewPassword = view.findViewById(R.id.textViewPassword);
            textViewFoodName = view.findViewById(R.id.textViewFoodName);
            textViewFoodType = view.findViewById(R.id.textViewFoodType);
            textViewFoodCalCount = view.findViewById(R.id.textViewCalCount);
            textViewFoodWeight = view.findViewById(R.id.textViewFoodWeight);
        }
    }
}