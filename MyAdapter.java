package com.example.matala2_java_the8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final recyclerViewInterface recyclerVI;

    private ArrayList<DataModel> dataSet;
    //Context context;


    public MyAdapter(ArrayList<DataModel> dataSet,recyclerViewInterface recyclerVI )
    {
        //this.context=context;
        this.dataSet=dataSet;
        this.recyclerVI=recyclerVI;
        }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageViewItem;
        DataModel currentItem;
        View view;

        public MyViewHolder(View itemView,recyclerViewInterface recyclerVI){
            super(itemView);

            cardView=itemView.findViewById(R.id.card_view);
            textViewName=itemView.findViewById(R.id.item_title);
            textViewDescription=itemView.findViewById(R.id.item_description);
            imageViewItem=itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerVI!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerVI.onItemClick(pos);
                        }
                    }

                }
            });
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent ,false);
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.card_layout, parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view,recyclerVI);

        return myViewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TextView textViewName =holder.textViewName;
        TextView textViewDescription=holder.textViewDescription;
        ImageView imageViewItem=holder.imageViewItem;
        //CardView cardView=holder.cardView;

        textViewName.setText(dataSet.get(position).getName());
        textViewDescription.setText(dataSet.get(position).getDescription());
        imageViewItem.setImageResource(dataSet.get(position).getImage());
/*
        DataModel dataModel=dataSet.get(position);
        holder.imageViewItem.setImageResource(dataModel.image);
        holder.textViewDescription.setText(dataModel.description);
        holder.textViewName.setText(dataModel.name);
*/
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}




