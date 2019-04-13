package com.example.bartender;

class Ingredient {
    private int name;
    private int imageId;
    private int price;
    private int volume;

    Ingredient() {
        /* Just for correct search work */
    }

    Ingredient(int name, int imageId, int price, int volume) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.volume = volume;
    }

    int getName() {
        return name;
    }

    int getImageId() {
        return imageId;
    }

    int getPrice() {
        return price;
    }

    int getVolume() {
        return volume;
    }
}
