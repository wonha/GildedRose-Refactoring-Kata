package com.gildedrose.item;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTest {

    @Test
    public void backstagePassesIncreaseQualityBy1WhenMoreThan10DaysLeft() {
        Item[] items = new Item[] {
                Item.of("Backstage passes", 12, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(31, items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseQualityBy2When10OrLessDays() {
        Item[] items = new Item[] {
                Item.of("Backstage passes", 11, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(32, items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseQualityBy3When5OrLessDays() {
        Item[] items = new Item[] {
                Item.of("Backstage passes", 6, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(33, items[0].quality);
    }

    @Test
    public void backstagePassesDropQualityTo0AfterExpired() {
        Item[] items = new Item[] {
                Item.of("Backstage passes", 0, 30),
        };
        GildedRose inventory = new GildedRose(items);

        inventory.updateQuality2();

        assertEquals(0, items[0].quality);
    }


}