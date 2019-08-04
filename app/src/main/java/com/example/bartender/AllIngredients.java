package com.example.bartender;

public class AllIngredients {
    private Ingredient allIngredients[];

    public AllIngredients()
    {
        allIngredients = new Ingredient[] {
                new Ingredient(R.string.vodka, R.drawable.vodka, 90, 500),
                new Ingredient(R.string.orange_juice, R.drawable.orange_juice, 20, 1000),
                new Ingredient(R.string.blue_curacao, R.drawable.blue_curacao, 100, 700),
                new Ingredient(R.string.lemonade, R.drawable.lemonade, 20, 1000),
                new Ingredient(R.string.gin, R.drawable.gin, 140, 500),
                new Ingredient(R.string.sparkling_wine, R.drawable.sparkling_wine, 115, 750),
                new Ingredient(R.string.coca_cola, R.drawable.coca_cola, 7, 2000),
                new Ingredient(R.string.whiskey, R.drawable.whiskey, 128, 500),
                new Ingredient(R.string.soda, R.drawable.soda, 7, 2000),
                new Ingredient(R.string.tonic, R.drawable.tonic, 6, 1000),
                new Ingredient(R.string.red_bull, R.drawable.red_bull, 15, 500)
        };
    }

    Ingredient GetIngredientByName(int nameId) {
        for (Ingredient ingredient : allIngredients) {
            if (ingredient.getName() == nameId) {
                return ingredient;
            }
        }

        return new Ingredient();
    }

    public Ingredient[] getAllIngredients() {
        return allIngredients;
    }
}
