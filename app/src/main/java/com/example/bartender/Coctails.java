package com.example.bartender;

class Coctails {
    private final int COCTAILS_COUNT = 5;
    private Coctail allCoctails[] = new Coctail[COCTAILS_COUNT];
    private AllIngredients ingredients = new AllIngredients();

    Coctails()
    {
        IngredientAdded[] screwdriver = new IngredientAdded[]{
                new IngredientAdded(ingredients.GetIngredientById(0), 50),
                new IngredientAdded(ingredients.GetIngredientById(1), 100)};
        allCoctails[0] = new Coctail(R.string.screwdriver, R.drawable.screwdriver, screwdriver);

        IngredientAdded[] blue_lagoon = new IngredientAdded[]{
                new IngredientAdded(ingredients.GetIngredientById(0), 30),
                new IngredientAdded(ingredients.GetIngredientById(2), 30),
                new IngredientAdded(ingredients.GetIngredientById(3), 120)};
        allCoctails[1] = new Coctail(R.string.blue_lagoon, R.drawable.blue_lagoon, blue_lagoon);

        IngredientAdded[] monkey_gland = new IngredientAdded[]{
                new IngredientAdded(ingredients.GetIngredientById(1), 30),
                new IngredientAdded(ingredients.GetIngredientById(4), 50)};
        allCoctails[2] = new Coctail(R.string.monkey_gland, R.drawable.monkey_gland, monkey_gland);

        IngredientAdded[] mimosa = new IngredientAdded[]{
                new IngredientAdded(ingredients.GetIngredientById(1), 75),
                new IngredientAdded(ingredients.GetIngredientById(5), 75)};
        allCoctails[3] = new Coctail(R.string.mimosa, R.drawable.mimosa, mimosa);

        IngredientAdded[] bucks_fizz = new IngredientAdded[]{
                new IngredientAdded(ingredients.GetIngredientById(1), 100),
                new IngredientAdded(ingredients.GetIngredientById(5), 50)};
        allCoctails[4] = new Coctail(R.string.bucks_fizz, R.drawable.mimosa, bucks_fizz);

        /* Whiskey+cola, Whiskey Sour, Gin+tonik, Grayhound, Silver bullet, Highball */
    }

    Coctail GetRandomCoctail()
    {
        int randomNumber = (int) (Math.random() * COCTAILS_COUNT);
        return allCoctails[randomNumber];
    }
}
