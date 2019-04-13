package com.example.bartender;

public class AllIngredients {
    private final int INGREDIENT_COUNT = 6;
    private Ingredient allIngredients[] = new Ingredient[INGREDIENT_COUNT];

    public AllIngredients()
    {
        allIngredients[0] = new Ingredient(R.string.vodka, R.drawable.vodka, 90, 500);
        allIngredients[1] = new Ingredient(R.string.orange_juice, R.drawable.orange_juice, 20, 1000);
        allIngredients[2] = new Ingredient(R.string.blue_curacao, R.drawable.blue_curacao, 100, 700);
        allIngredients[3] = new Ingredient(R.string.lemonade, R.drawable.lemonade, 20, 1000);
        allIngredients[4] = new Ingredient(R.string.gin, R.drawable.gin, 140, 500);
        allIngredients[5] = new Ingredient(R.string.sparkling_wine, R.drawable.sparkling_wine, 115, 750);
    }

    public Ingredient GetIngredientById(int id)
    {
        return allIngredients[id];
    }

    public Ingredient[] getAllIngredients() {
        return allIngredients;
    }
}
