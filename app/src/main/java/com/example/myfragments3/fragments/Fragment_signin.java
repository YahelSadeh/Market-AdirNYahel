package com.example.myfragments3.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragments3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_signin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_signin extends Fragment {

    public static ArrayList<String[]> userCredentials = new ArrayList<>();

    // Add initial data
    static {
        userCredentials.add(new String[]{"user1", "password1"});
        userCredentials.add(new String[]{"user2", "password2"});
        userCredentials.add(new String[]{"user3", "password3"});
    }

    // Add new data dynamically
    public static void addCredentials(String username, String password) {
        userCredentials.add(new String[]{username, password});
    }
    //public static String[][] userCredentials = {
     //       {"user1", "password1"},
     //       {"user2", "password2"},
     //       {"user3", "password3"}
   // };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_signin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_signin newInstance(String param1, String param2) {
        Fragment_signin fragment = new Fragment_signin();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        // Initialize UI elements
        TextView textViewUserName = view.findViewById(R.id.textUserName);
        TextView textViewPassword = view.findViewById(R.id.textPassword);
        Button buttonLogin = view.findViewById(R.id.button_login);
        Button buttonRegister = view.findViewById(R.id.button_register);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, Fragment_register.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textViewUserName.getText().toString().trim();
                String password = textViewPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    // Display an error message indicating that username or password is empty
                    Toast.makeText(getContext(), "Please enter both username and password", Toast.LENGTH_SHORT).show();
                    return; // Exit onClick method
                }
                boolean credentialsMatch = false;

// Iterate through the userCredentials array to find the username
                for (String[] credentials : userCredentials) {
                    String storedUsername = credentials[0];
                    if (username.equals(storedUsername)) {
                        // Username found, now check the password
                        String storedPassword = credentials[1];
                        if (password.equals(storedPassword)) {
                            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainer, Fragment_market.class, null)
                                    .setReorderingAllowed(true)
                                    .addToBackStack("name") // Name can be null
                                    .commit();
                            break;
                        }
                    }
                }

            }
        });
        return view;
    }


}