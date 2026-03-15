package com.example.recipeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private CategoryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvCategories);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        List<String> categories = Arrays.asList(
                "Breakfast", "Lunch", "Dinner",
                "Italian", "Chinese", "Desserts",
                "Healthy", "Drinks"
        );

        // Initialize and set adapter
        adapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(adapter);
        return view;
    }
}