package com.gildedrose.item;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTest {

    @Test
    public void degradeNormalItemQualityAfterADay() {
        Item[] items = new Item[] {
                Item.of("Elixir", 5, 7),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(ExpirationState.NOTEXPIRED, items[0].expirationState);
        assertEquals(4, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    public void degradeNormalItemQualityTwiceAfterExpired() {
        Item[] items = new Item[] {
                Item.of("Elixir", 0, 7),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(ExpirationState.EXPIRED, items[0].expirationState);
        assertEquals(-1, items[0].sellIn);
        assertEquals(5, items[0].quality);
    }


}