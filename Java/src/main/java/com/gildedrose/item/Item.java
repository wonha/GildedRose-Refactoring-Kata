package com.gildedrose.item;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public ExpirationState expirationState;

    protected Item(String name, int sellIn, int quality, ExpirationState expirationState) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.expirationState = expirationState;
    }

    public static Item of(String name, int sellIn, int quality) {

        Item item;
        if (name.startsWith("Aged Brie")) {
            itemValidation(quality);
            item = new AgedBrie(name, sellIn, quality);
        } else if (name.startsWith("Sulfuras")) {
            item = new Sulfuras(name, sellIn, quality);
        } else if (name.startsWith("Backstage passes")) {
            itemValidation(quality);
            item = new BackstagePasses(name, sellIn, quality);
        } else {
            itemValidation(quality);
            item = new NormalItem(name, sellIn, quality);
        }
        return item;
    }

    private static void itemValidation(int quality) {
        if (quality < 0) {
            throw new IllegalArgumentException("Quality can not be less then 0");
        } else if (quality > 50) {
            throw new IllegalArgumentException("Quality can not be more than 50");
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQualityFor1Day() {
        sellIn--;
        updateExpiredState();

        updateQuality();
        forceQualityBoundary();
    }

    protected void forceQualityBoundary() {
        if (quality > 50) {
            quality = 50;
        } else if (quality <= 0) {
            quality = 0;
        }
    }

    protected abstract void updateExpiredState();

    protected abstract void updateQuality();

}
