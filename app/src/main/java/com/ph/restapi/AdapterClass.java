package com.ph.restapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder> {

    List<ModelClass> data;

    public AdapterClass(List<ModelClass> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showing_card,parent,false);


        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        holder.textViewa.setText( ""+ data.get(position).getUserId());
        holder.textViewb.setText( ""+ data.get(position).getId());
        holder.textViewc.setText( ""+ data.get(position).getTitle());
        holder.textViewd.setText( ""+ data.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class CardViewHolder extends RecyclerView.ViewHolder{

        TextView textViewa,textViewb,textViewc,
        textViewd;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewa=itemView.findViewById(R.id.textViewa);
            textViewb=itemView.findViewById(R.id.textViewb);
            textViewc=itemView.findViewById(R.id.textViewc);
            textViewd=itemView.findViewById(R.id.textViewd);


        }



    }



}
