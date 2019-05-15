package com.gildedrose.item;

public class AgedBrie extends Item {
    AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality, sellIn >= 0 ? ExpirationState.NOTEXPIRED : ExpirationState.EXPIRED);
    }

    @Override
    protected void updateExpiredState() {
        if (sellIn < 0) {
            expirationState = ExpirationState.EXPIRED;
        }
    }

    @Override
    protected void updateQuality() {
        quality++;
    }
}
