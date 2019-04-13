package com.example.bartender;

public class IngredientAdded {
    private Ingredient ingredient;
    private int volume;
    private int price;

    public IngredientAdded(Ingredient ingredient, int volume)
    {
        this.ingredient = ingredient;
        this.volume = volume;
        double part = (double)volume / (double)ingredient.getVolume();
        price = (int)(ingredient.getPrice() * part);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }
}
