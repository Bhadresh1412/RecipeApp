package com.example.recipeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recipe> getDemoData() {
        List<Recipe> data = new ArrayList<>();

        // Make sure you have these images in res/drawable (or use your logo as a placeholder)
        data.add(new Recipe("Spaghetti Carbonara", "20 Mins", R.drawable.flavor_forge_logo));
        data.add(new Recipe("Margherita Pizza", "15 Mins", R.drawable.flavor_forge_logo));
        data.add(new Recipe("Chocolate Brownie", "30 Mins", R.drawable.flavor_forge_logo));
        data.add(new Recipe("Greek Salad", "10 Mins", R.drawable.flavor_forge_logo));

        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rvRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Recipe> recipeList = getDemoData();

        // 2. Initialize the Adapter with the data
        RecipeAdapter adapter = new RecipeAdapter(recipeList);

        // 3. Set the Adapter to the RecyclerView
        recyclerView.setAdapter(adapter);

        return view;
    }
}