package com.example.bartender;

public class Ingredient {
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

    public int getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getPrice() {
        return price;
    }

    int getVolume() {
        return volume;
    }
}
