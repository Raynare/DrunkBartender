package com.example.bartender.Models;

import android.support.v7.widget.GridLayout;
import android.content.Context;
import android.widget.ScrollView;

import com.example.bartender.AllIngredients;
import com.example.bartender.Ingredient;
import com.example.bartender.MainActivity;

public class ShopView {
    public ShopView(Context context, MainActivity mainActivity) {
        AllIngredients allIngredients = new AllIngredients();

        m_layout = new ScrollView(context);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(25,25,25,25);
        GridLayout shopLayout = new GridLayout(context);
        shopLayout.setColumnCount(5);
        shopLayout.setLayoutParams(params);

        Ingredient[] ingredients = allIngredients.getAllIngredients();
        for (int i = 0; i < ingredients.length; ++i)
        {
            LotView lotView = new LotView(context,
                                          mainActivity,
                                          i,
                                          ingredients[i].getName(),
                                          ingredients[i].getPrice(),
                                          ingredients[i].getImageId(),
                                          ingredients[i].getVolume());

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
