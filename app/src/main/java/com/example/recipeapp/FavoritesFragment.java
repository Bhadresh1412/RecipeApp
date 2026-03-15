package com.example.recipeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    RecyclerView recyclerView;
    List<Recipe> favList;
    RecipeAdapter adapter;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = view.findViewById(R.id.rvFavorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        favList = new ArrayList<>();

        // Favorite Recipes
        favList.add(new Recipe("Spaghetti Carbonara", "20 Mins", R.drawable.flavor_forge_logo));
        favList.add(new Recipe("Veg Burger", "15 Mins", R.drawable.flavor_forge_logo));
        favList.add(new Recipe("Pizza", "25 Mins", R.drawable.flavor_forge_logo));
        favList.add(new Recipe("Pasta Alfredo", "18 Mins", R.drawable.flavor_forge_logo));

        adapter = new RecipeAdapter(favList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}