    package com.example.recipeapp;
    
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;
    
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.RecyclerView;
    
    import java.util.List;
    
    public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    
        private List<Recipe> recipeList;
    
        public RecipeAdapter(List<Recipe> recipeList){
            this.recipeList = recipeList;
        }
    
        @NonNull
        @Override
        public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_item, parent, false);
    
            return new RecipeViewHolder(view);
        }
    
        @Override
        public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
    
            Recipe recipe = recipeList.get(position);
    
            holder.title.setText(recipe.getTitle());
            holder.time.setText(recipe.getTime());
            holder.image.setImageResource(recipe.getImageResource());
    
            // Recipe click
            holder.itemView.setOnClickListener(v -> {
    
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
    
                RecipeDetailFragment fragment = new RecipeDetailFragment();
    
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            });
    
        }
    
        @Override
        public int getItemCount() {
            return recipeList.size();
        }
    
        public static class RecipeViewHolder extends RecyclerView.ViewHolder{
    
            TextView title, time;
            ImageView image;
    
            public RecipeViewHolder(@NonNull View itemView) {
                super(itemView);
    
                title = itemView.findViewById(R.id.tvRecipeName);
                time = itemView.findViewById(R.id.tvRecipeTime);
                image = itemView.findViewById(R.id.imgRecipe);
            }
        }
    }