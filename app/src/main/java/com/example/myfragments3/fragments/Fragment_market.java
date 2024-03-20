package com.example.myfragments3.fragments;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragments3.R;
import com.example.myfragments3.mainactivity.Adapter;
import com.example.myfragments3.mainactivity.DataModel;
import com.example.myfragments3.mainactivity.MyData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link androidx.fragment.app.Fragment} subclass.
 * Use the {@link Fragment_market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_market extends androidx.fragment.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_market newInstance(String param1, String param2) {
        Fragment_market fragment = new Fragment_market();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public ArrayList<DataModel> dataModels = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button moveToCart;
        RecyclerView recyclerView;
        SearchView searchView;
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        //textViewAmount = view.findViewById(R.id.textAmount);
        // Find views within the inflated layout
        recyclerView = view.findViewById(R.id.resViewMarket);
        //searchView = view.findViewById(R.id.searchBar);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setDataModels();

        Adapter adapter = new Adapter(getContext(), dataModels);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        //adapter = new Adapter(getContext(), dataModels);
        //recyclerView.setAdapter(adapter);

        moveToCart = view.findViewById(R.id.moveToCart);

        // Set OnClickListener to the button
        moveToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the fragment you want to navigate to
                Fragment_cart fragmentCart = new Fragment_cart();

                // Replace the current fragment with the new fragment
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragmentCart);
                transaction.addToBackStack(null); // Optional: Add to back stack if needed
                transaction.commit();
            }
        });

        return view;
    }

    Adapter adapter;

    private void setDataModels() {
        for (int i = 0; i < MyData.drawableArray.length; i++) {
            dataModels.add(new DataModel(MyData.nameArray[i], MyData.drawableArray[i], MyData.amount[i]));
        }
    }

    private void filteredList(String text) {
        List<DataModel> filteredList= new ArrayList<>();
        for( DataModel item: dataModels ){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(getContext(),"No Data found", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }
}