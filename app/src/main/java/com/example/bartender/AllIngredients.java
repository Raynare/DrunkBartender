package com.example.bartender;

public class AllIngredients {
    private Ingredient allIngredients[];

    public AllIngredients()
    {
        allIngredients = new Ingredient[] {
                new Ingredient(R.string.vodka, R.drawable.vodka, 180, 500, 1),
                new Ingredient(R.string.orange_juice, R.drawable.orange_juice, 25, 1000, 1),
                new Ingredient(R.string.beer, R.drawable.beer, 30, 500, 1),

                new Ingredient(R.string.red_bull, R.drawable.red_bull, 40, 500, 2),
                new Ingredient(R.string.blue_curacao, R.drawable.blue_curacao, 400, 700, 2),
                new Ingredient(R.string.lemonade, R.drawable.lemonade, 20, 1000, 2),

                new Ingredient(R.string.coca_cola, R.drawable.coca_cola, 25, 2000, 3),
                new Ingredient(R.string.whiskey, R.drawable.whiskey, 350, 500, 3),

                new Ingredient(R.string.gin, R.drawable.gin, 600, 700, 4),
                new Ingredient(R.string.sparkling_wine, R.drawable.sparkling_wine, 100, 750, 4),
                new Ingredient(R.string.tonic, R.drawable.tonic, 30, 1000, 4),

                new Ingredient(R.string.soda, R.drawable.soda, 30, 1000, 1000)
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
