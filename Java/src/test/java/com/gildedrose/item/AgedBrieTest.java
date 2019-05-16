package com.gildedrose.item;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @Test
    public void qualityIncrease() {
        Item[] items = new Item[] {
                Item.of("Aged Brie", 5, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(31, items[0].quality);

    }

    @Test
    public void qualityNeverBecomeMoreThan50() {
        Item[] items = new Item[] {
                Item.of("Aged Brie", 5, 50),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(50, items[0].quality);
    }


}