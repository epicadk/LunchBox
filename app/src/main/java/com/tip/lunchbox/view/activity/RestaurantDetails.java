package com.tip.lunchbox.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.tip.lunchbox.R;
import com.tip.lunchbox.databinding.ActivityRestaurantDetailsBinding;
import com.tip.lunchbox.model.Restaurant;
import com.tip.lunchbox.utilities.Constants;
import com.tip.lunchbox.viewmodel.RestaurantDetailsViewModel;

public class RestaurantDetails extends AppCompatActivity {
    RestaurantDetailsViewModel viewModel;
    ActivityRestaurantDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(RestaurantDetailsViewModel.class);
        String resId = getIntent().getStringExtra(Constants.INTENT_RES_ID);

        assert resId != null;
        viewModel.getRestaurantLiveData(Integer.parseInt(resId)).observe(this, this::setData);
    }


    private void setData(Restaurant restaurant) {
        binding.toolbar.setTitle(restaurant.getName());
        binding.tvRating.setText(restaurant.getUserRating().getAggregateRating());
        setOurReviewText(Float.parseFloat(restaurant.getUserRating().getAggregateRating()));

        binding.tvRating.setBackgroundColor(
                Color.parseColor("#" + restaurant.getUserRating().getRatingColor()));
        binding.tvLocation.setText(restaurant.getLocation().getLocalityVerbose());
        Glide.with(this)
                .load(restaurant.getFeaturedImage())
                .centerCrop()
                .into(binding.ivRestaurant);
        binding.chipDirections.setOnClickListener(view -> getDirections(restaurant));
    }


    /**
        This function is used to create an Intent for Google Maps to get the directions to the
        restaurant.

        @param restaurant the restaurant whose coordinates are to be passed to the intent
     */
    private void getDirections(Restaurant restaurant) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter(
                        "destination",
                        restaurant.getLocation().getLatitude()
                                + ","
                                + restaurant.getLocation().getLongitude());
        String url = builder.build().toString();
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse(url));
        startActivity(mapIntent);
    }


    private void setOurReviewText(float aggregateRating) {
        String ourReview;
        if (aggregateRating >= 4) {
            ourReview = getString(R.string.our_review_good);
        } else if (aggregateRating < 4 && aggregateRating > 2) {
            ourReview = getString(R.string.our_review_average);
        } else {
            ourReview = getString(R.string.our_review_bad);
        }
        binding.tvOurReview.setText(ourReview);
    }
}