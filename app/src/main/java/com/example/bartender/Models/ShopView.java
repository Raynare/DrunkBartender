package com.example.bartender.Models;

import android.support.v7.widget.GridLayout;
import android.content.Context;
import android.widget.ScrollView;

import com.example.bartender.AllIngredients;
import com.example.bartender.Ingredient;
import com.example.bartender.MainActivity;

public class ShopView {
    public ShopView(Context context, MainActivity mainActivity) {
        AllIngredients ingredients = new AllIngredients();

        m_layout = new ScrollView(context);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(25,25,25,25);
        GridLayout shopLayout = new GridLayout(context);
        shopLayout.setColumnCount(5);
        shopLayout.setLayoutParams(params);
        for (Ingredient ingredient : ingredients.getAllIngredients())
        {
            String name = context.getResources().getString(ingredient.getName());
            LotView lotView = new LotView(context, mainActivity, name, ingredient.getPrice(), ingredient.getImageId());

            shopLayout.addView(lotView.Get());
        }

        m_layout.addView(shopLayout);
    }

    public ScrollView Get()
    {
        return m_layout;
    }

    private ScrollView m_layout;
}
