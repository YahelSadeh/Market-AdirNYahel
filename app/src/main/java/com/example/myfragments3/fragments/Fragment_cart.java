package com.example.myfragments3.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfragments3.R;
import com.example.myfragments3.mainactivity.Adapter_Cart;
import com.example.myfragments3.mainactivity.DataModel;
import com.example.myfragments3.mainactivity.MyData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_cart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_cart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_cart.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_cart newInstance(String param1, String param2) {
        Fragment_cart fragment = new Fragment_cart();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerViewCart;
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerViewCart = view.findViewById(R.id.resViewCart);
        recyclerViewCart.setItemAnimator(new DefaultItemAnimator());

        setDataModels();

        Adapter_Cart adapterCart = new Adapter_Cart(getContext(), dataModels);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        recyclerViewCart.setAdapter(adapterCart);

        //adapterCart = new Adapter_Cart(getContext(), dataModels);
        //recyclerViewCart.setAdapter(adapterCart);

        return view;
    }
    private void setDataModels() {
        for (int i = 0; i < MyData.drawableArray.length; i++) {
            if (!MyData.amount[i].equals("0"))
                dataModels.add(new DataModel(MyData.nameArray[i], MyData.drawableArray[i], MyData.amount[i], MyData.price[i]));
        }
        if (dataModels.isEmpty())
        {
            Toast.makeText(getContext(), "No Data ", Toast.LENGTH_SHORT).show();
        }
    }
}