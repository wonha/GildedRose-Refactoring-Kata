package com.gildedrose.item;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test(expected = IllegalArgumentException.class)
    public void initQualityBoundMaxTo50() {
        Item[] items = new Item[] {
                Item.of("Elixir", 5, 60),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();
    }

    @Test
    public void negativeQualityCanNotExist() {
        Item[] items = new Item[] {
                Item.of("Elixir", 5, 1),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();
        inventory.updateQuality2();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void qualityNeverBecomeNegative() {
        Item[] items = new Item[] {
                Item.of("Elixir", 5, 1),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();
        inventory.updateQuality2();

        assertEquals(0, items[0].quality);
    }


}