package com.gildedrose.item;

public class Sulfuras extends Item {

    Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, 80, ExpirationState.NONEXPIRABLE);
    }

    @Override
    protected void updateExpiredState() {
        // Never expire
    }

    @Override
    protected void updateQuality() {
        // update immutable
    }

    @Override
    protected void forceQualityBoundary() {
        quality = 80;
    }
}
