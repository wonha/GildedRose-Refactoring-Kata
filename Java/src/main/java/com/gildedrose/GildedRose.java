package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            // Aged Brie or Others
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // State Change : update quality
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    // State Change : update quality
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                // State Change : update quality
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                // State Change : update quality
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // Sulfuras & Hand of Ragnaros
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                // State Change : update date
                items[i].sellIn = items[i].sellIn - 1;
            }

            // Out of Date
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // State Change : update quality
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // State Change : update quality
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        // State Change : update quality
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}