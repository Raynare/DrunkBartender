package com.example.bartender;

public class Coctail {
    Coctail(int name, int imageId, IngredientAdded[] ingredients)
    {
        this.name = name;
        this.imageId = imageId;
        this.ingredients = ingredients;

        price = 0;
        level = 1;
        for (IngredientAdded ingredient : ingredients)
        {
            price += ingredient.getPrice();

            int ingredientLevel = ingredient.getIngredient().getLevel();
            if (ingredientLevel > level)
            {
                level = ingredientLevel;
            }
        }
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

    int getLevel() { return level; }

    IngredientAdded[] getIngredients() {
        return ingredients;
    }

    private int name;
    private int imageId;
    private int price;
    private int level;
    private IngredientAdded[] ingredients;
}
