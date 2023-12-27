package com.example.meeba;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.meeba.Fragment.HomeFragment;
import com.example.meeba.Fragment.LibraryFragment;
import com.example.meeba.Fragment.SubscriptionsFragment;
import com.example.meeba.Fragment.UserFragment;
import com.example.meeba.databinding.ActivityHome2Binding;


public class Home2 extends AppCompatActivity {

    ActivityHome2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView2.setOnItemSelectedListener();

    }

}