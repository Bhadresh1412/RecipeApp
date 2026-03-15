package com.example.recipeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecipeDetailFragment extends Fragment {
    private ImageView imageView;
    private TextView titleView, timeView, ingredientsView, instructionsView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        imageView = view.findViewById(R.id.detailImage);
        titleView = view.findViewById(R.id.detailTitle);
        timeView = view.findViewById(R.id.detailTime);
        ingredientsView = view.findViewById(R.id.detailIngredients);
        instructionsView = view.findViewById(R.id.detailInstructions);

        return view;
    }
}