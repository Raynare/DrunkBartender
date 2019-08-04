package com.example.bartender;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;

import com.example.bartender.Models.LotView;

public class ShopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        AllIngredients ingredients = new AllIngredients();
        GridLayout shopLayout = findViewById(R.id.shopLayout);
        for (Ingredient ingredient : ingredients.getAllIngredients())
        {
            String name = getResources().getString(ingredient.getName());
            //shopLayout.addView(new LotView(this, name, ingredient.getPrice(), ingredient.getImageId()).Get());
        }
    }
}
