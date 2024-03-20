package com.example.myfragments3.mainactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfragments3.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
   // private OnPlusButtonClickListener plusButtonClickListener;
    ArrayList<DataModel> dataModels;
    private ArrayList<DataModel> filteredList;
    public Adapter(Context context, ArrayList<DataModel> dataModels){
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview, parent, false);

        return new Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(dataModels.get(position).getImage());
        holder.textViewName.setText(dataModels.get(position).getName());
        holder.TextViewAmount.setText("Amount : "+dataModels.get(position).getAmount());
        holder.textviewPrice.setText("Price: "+ MyData.price[position]);

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = dataModels.get(position).getName();
                // Handle the plus button click
                Toast.makeText(v.getContext(), "Clicked item: " + itemName, Toast.LENGTH_SHORT).show();
                subItemAmount(position);
                dataModels.get(position).calcPricee(position);
                //calculatPrice(position);
                holder.TextViewAmount.setText("Amount : "+ dataModels.get(position).getAmount());
            }
        });

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = dataModels.get(position).getName();
                // Handle the minus button click
                // You can access 'position' here to know which item's button was clicked
                Toast.makeText(v.getContext(), "Clicked item: " + itemName, Toast.LENGTH_SHORT).show();
                addItemAmount(position);
                dataModels.get(position).calcPricee(position);
                //calculatPrice(position);
                holder.TextViewAmount.setText("Amount : "+dataModels.get(position).getAmount());
            }
        });
    }
    private void calculatPrice(int position){
        dataModels.get(position).calcPricee(position);
    }
    private void subItemAmount(int position){
        dataModels.get(position).subAmount(position);
    }
    private void addItemAmount(int position) {
        dataModels.get(position).addAmount(position);
    }

    public void setFilteredList(List<DataModel> filteredList) {
        this.dataModels = new ArrayList<>(filteredList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textViewName;
        public TextView TextViewAmount;
        public TextView textviewPrice;
        public Button plusButton;
        public Button minusButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            plusButton = itemView.findViewById(R.id.buttonPlus);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textName);
            TextViewAmount=itemView.findViewById(R.id.textAmount);
            plusButton = itemView.findViewById(R.id.buttonPlus);
            minusButton = itemView.findViewById(R.id.buttonMinus);
            textviewPrice = itemView.findViewById(R.id.textPrice);
        }

    }

}
