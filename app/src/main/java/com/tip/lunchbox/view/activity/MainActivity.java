package com.tip.lunchbox.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.tip.lunchbox.R;
import com.tip.lunchbox.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding Initialized
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        //Setting navController
        NavController navController = Navigation.findNavController(this,
                R.id.navigation_host_fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.restaurantDetails
                    || destination.getId() == R.id.collectionDetails) {
                mainBinding.mainActivityBn.setVisibility(View.GONE);
            } else {
                mainBinding.mainActivityBn.setVisibility(View.VISIBLE);
            }
        });
        NavigationUI.setupWithNavController(mainBinding.mainActivityBn, navController);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainBinding = null;
    }
}