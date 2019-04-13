package com.example.bartender;

class Coctails {
    private Coctail allCoctails[];

    Coctails() {
        final AllIngredients ingredients = new AllIngredients();

        allCoctails = new Coctail[] {
                new Coctail(R.string.screwdriver, R.drawable.screwdriver, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.vodka), 50),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.orange_juice), 100)}),
                new Coctail(R.string.blue_lagoon, R.drawable.blue_lagoon, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.vodka), 30),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.blue_curacao), 30),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.lemonade), 120)}),
                new Coctail(R.string.monkey_gland, R.drawable.monkey_gland, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.orange_juice), 30),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.gin), 50)}),
                new Coctail(R.string.mimosa, R.drawable.mimosa, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.orange_juice), 75),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.sparkling_wine), 75)}),
                new Coctail(R.string.bucks_fizz, R.drawable.mimosa, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.orange_juice), 100),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.sparkling_wine), 50)})
        };

        /* Whiskey+cola, Whiskey Sour, Gin+tonik, Grayhound, Silver bullet, Highball */
    }

    Coctail GetRandomCoctail()
    {
        int randomNumber = (int) (Math.random() * allCoctails.length);
        return allCoctails[randomNumber];
    }
}
