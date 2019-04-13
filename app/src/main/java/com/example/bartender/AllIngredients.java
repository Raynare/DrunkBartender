package com.example.bartender;

class AllIngredients {
    private Ingredient allIngredients[];

    AllIngredients()
    {
        allIngredients = new Ingredient[] {
                new Ingredient(R.string.vodka, R.drawable.vodka, 90, 500),
                new Ingredient(R.string.orange_juice, R.drawable.orange_juice, 20, 1000),
                new Ingredient(R.string.blue_curacao, R.drawable.blue_curacao, 100, 700),
                new Ingredient(R.string.lemonade, R.drawable.lemonade, 20, 1000),
                new Ingredient(R.string.gin, R.drawable.gin, 140, 500),
                new Ingredient(R.string.sparkling_wine, R.drawable.sparkling_wine, 115, 750)
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

    Ingredient[] getAllIngredients() {
        return allIngredients;
    }
}
