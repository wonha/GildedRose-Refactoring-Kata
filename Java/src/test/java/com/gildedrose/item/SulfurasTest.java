package com.gildedrose.item;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    @Test
    public void legendaryItemNeverBeSold() {
        // should I add sellable flag on item ?
    }

    @Test
    public void legendaryItemNeverChangesQuality() {
        Item[] items = new Item[] {
                Item.of("Sulfuras", 5, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(80, items[0].quality);
    }

    @Test
    public void legendaryItemAlwaysInitQualityTo80() {
        Item[] items = new Item[] {
                Item.of("Sulfuras", 5, 90),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(80, items[0].quality);
    }
}