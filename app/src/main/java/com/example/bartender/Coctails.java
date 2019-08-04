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
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.sparkling_wine), 50)}),
                new Coctail(R.string.whiskey_cola, R.drawable.whiskey_cola, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.whiskey), 50),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.coca_cola), 100)}),
                new Coctail(R.string.gin_tonic, R.drawable.gin_tonic, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.gin), 50),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.tonic), 100)}),
                new Coctail(R.string.energy_vodka, R.drawable.energy_vodka, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.vodka), 50),
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.red_bull), 150)
                }),
                new Coctail(R.string.vodka, R.drawable.pure_vodka, new IngredientAdded[]{
                        new IngredientAdded(ingredients.GetIngredientByName(R.string.vodka), 50)
                })
        };
    }

    Coctail GetRandomCoctail()
    {
        int randomNumber = (int) (Math.random() * allCoctails.length);
        Coctail coctail = allCoctails[randomNumber];

        if (coctail.getLevel() > Globals.level)
        {
            return GetRandomCoctail();
        }

        return coctail;
    }
}
