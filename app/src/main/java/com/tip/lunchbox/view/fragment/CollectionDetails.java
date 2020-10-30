package com.tip.lunchbox.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tip.lunchbox.databinding.FragmentCollectionDetailsBinding;
import com.tip.lunchbox.view.adapter.RestaurantAdapter;
import com.tip.lunchbox.view.listeners.RecyclerTouchListener;
import com.tip.lunchbox.viewmodel.CollectionDetailsViewModel;

import org.jetbrains.annotations.NotNull;

public class CollectionDetails extends Fragment {
    private FragmentCollectionDetailsBinding binding;
    private CollectionDetailsViewModel viewModel;
    private RestaurantAdapter adapter;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentCollectionDetailsBinding.inflate(inflater, container, false);
        setupRecyclerView();

        viewModel = new ViewModelProvider(this).get(CollectionDetailsViewModel.class);
        assert getArguments() != null;
        int collectionId = CollectionDetailsArgs.fromBundle(getArguments()).getCollectionID();
        String collectionName = CollectionDetailsArgs
                .fromBundle(getArguments()).getCollectionName();
        binding.appBarTvLocation.setText(collectionName);
        viewModel.getSearchResponseLiveData(collectionId)
                .observe(getViewLifecycleOwner(), searchResponse ->
                        adapter.setData(searchResponse.getRestaurantContainers()));
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        adapter = new RestaurantAdapter(requireContext());
        binding.rvCollectionsDetails.setAdapter(adapter);
        binding.rvCollectionsDetails.setLayoutManager(new LinearLayoutManager(requireContext()));

        new RecyclerTouchListener(requireContext(),
                binding.rvCollectionsDetails, (view, position) -> {
            CollectionDetailsDirections.ActionCollectionDetailsToRestaurantDetails action =
                    CollectionDetailsDirections.actionCollectionDetailsToRestaurantDetails(
                            Integer.parseInt(adapter.getData().get(position)
                                    .getRestaurant().getId()));

            NavHostFragment.findNavController(this).navigate(action);
        });
    }
}