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
    public void legendaryItemNeverDecreaseQuality() {
        Item[] items = new Item[] {
                Item.of("Sulfuras", 5, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(30, items[0].quality);

    }


}