package com.example.bartender;

public class Coctail {
    private int name;
    private int imageId;
    private int price;
    private IngredientAdded[] ingredients;

    Coctail(int name, int imageId, IngredientAdded[] ingredients)
    {
        this.name = name;
        this.imageId = imageId;
        this.ingredients = ingredients;

        int price = 0;
        for (IngredientAdded ingredient : ingredients)
        {
            price += ingredient.getPrice();
        }
        this.price = (int)(price * 1.2);
    }

    public int getName() {
        return name;
    }

    int getImageId() {
        return imageId;
    }

    int getPrice() {
        return price;
    }

    IngredientAdded[] getIngredients() {
        return ingredients;
    }
}
