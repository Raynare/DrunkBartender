package com.example.bartender;

public class Ingredient {
    Ingredient() {
        /* Just for correct search work */
    }

    Ingredient(int name, int imageId, int price, int volume, int level) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.volume = volume;
        this.level = level;
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

    public int getVolume() {
        return volume;
    }

    public int getLevel() { return level; }

    private int name;
    private int imageId;
    private int price;
    private int volume;
    private int level;
}
