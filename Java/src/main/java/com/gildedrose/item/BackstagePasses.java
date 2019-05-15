package com.gildedrose.item;

public class BackstagePasses extends Item {
    BackstagePasses(String name, int sellIn, int quality) {
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
        if (expirationState == ExpirationState.EXPIRED) {
            quality = 0;
        } else if (sellIn <= 5) {
            quality += 3;
        } else if(sellIn <= 10) {
            quality += 2;
        } else {
            quality++;
        }
    }
}
