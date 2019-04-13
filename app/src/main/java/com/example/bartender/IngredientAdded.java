package com.example.bartender;

class IngredientAdded {
    private Ingredient ingredient;
    private int volume;
    private int price;

    IngredientAdded(Ingredient ingredient, int volume)
    {
        this.ingredient = ingredient;
        this.volume = volume;
        double part = (double)volume / (double)ingredient.getVolume();
        price = (int)(ingredient.getPrice() * part);
    }

    Ingredient getIngredient() {
        return ingredient;
    }

    int getVolume() {
        return volume;
    }

    int getPrice() {
        return price;
    }
}
