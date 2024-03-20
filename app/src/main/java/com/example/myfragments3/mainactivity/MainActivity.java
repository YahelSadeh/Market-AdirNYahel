package com.example.myfragments3.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myfragments3.R;
import com.example.myfragments3.fragments.Fragment_cart;
import com.example.myfragments3.fragments.Fragment_market;
import com.example.myfragments3.fragments.Fragment_signin;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment_market fragment3 = new Fragment_market();
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.fragment3, fragment3);
        //fragmentTransaction.commit();

        // Instantiate the initial fragment
        Fragment_market fragmentMarket = new Fragment_market();
        Fragment_cart fragmentCart = new Fragment_cart();
        Fragment_signin fragmentSignin = new Fragment_signin();

        // Begin a fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Replace the fragment container with the initial fragment
        transaction.replace(R.id.fragmentContainer, fragmentSignin);

        // Commit the transaction
        transaction.commit();
    }


}