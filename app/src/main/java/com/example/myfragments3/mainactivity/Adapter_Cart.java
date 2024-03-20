package com.example.myfragments3.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfragments3.R;

import java.util.ArrayList;


public class Adapter_Cart extends RecyclerView.Adapter<Adapter_Cart.MyViewHolder> {

    private static final int VIEW_TYPE_ONE = 1;
    private static final int VIEW_TYPE_TWO = 2;

    // Other necessary fields and methods

    @Override
    public int getItemViewType(int position) {
        // Return the view type based on position
        if (position == 0) {
            return VIEW_TYPE_ONE;
        } else {
            return VIEW_TYPE_TWO;
        }
    }

    Context context;
    ArrayList<DataModel> dataModels;

    public Adapter_Cart(Context context, ArrayList<DataModel> dataModels){
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_cart, parent, false);

        return new Adapter_Cart.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageViewCart.setImageResource(dataModels.get(position).getImage());
        holder.textNameCart.setText("Product: "+dataModels.get(position).getName());
        holder.textAmountCart.setText("Amount: "+dataModels.get(position).getAmount());
        Integer p1 = (MyData.price[position])*Integer.parseInt(dataModels.get(position).getAmount());

        holder.textPriceCart.setText("Price: "+String.valueOf(p1));
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewCart;
        public TextView textNameCart;
        public TextView textAmountCart;
        public TextView textPriceCart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCart = itemView.findViewById(R.id.imageViewCart);
            textNameCart = itemView.findViewById(R.id.textViewNameCart);
            textAmountCart = itemView.findViewById(R.id.textViewAmountCart);
            textPriceCart = itemView.findViewById(R.id.textViewPriceCart);
        }
    }
}
/*

//holder.imageViewCart.setImageResource(dataModels.get(position).getImage());
        //holder.textNameCart.setText(dataModels.get(position).getName());
        //holder.textAmountCart.setText(dataModels.get(position).getAmount());
        //holder.textPriceCart.setText(dataModels.get(position).updatedAmount(position));

        public ImageView imageViewCart;
        public TextView textNameCart;
        public TextView textAmountCart;
        public TextView textPriceCart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCart = itemView.findViewById(R.id.imageViewCart);
            textNameCart = itemView.findViewById(R.id.textViewNameCart);
            textAmountCart = itemView.findViewById(R.id.textViewAmountCart);
            textPriceCart = itemView.findViewById(R.id.textViewPriceCart);
* */