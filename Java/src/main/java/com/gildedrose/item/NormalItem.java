package com.gildedrose.item;

public class NormalItem extends Item {

    NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality, sellIn >= 0 ? ExpirationState.NOTEXPIRED : ExpirationState.EXPIRED);
    }

    @Override
    protected void updateQuality() {
        if (expirationState == ExpirationState.EXPIRED) {
            quality -= 2;
        } else {
            quality -= 1;
        }
    }

    @Override
    protected void updateExpiredState() {
        if (sellIn < 0) {
            expirationState = ExpirationState.EXPIRED;
        }
    }

}
