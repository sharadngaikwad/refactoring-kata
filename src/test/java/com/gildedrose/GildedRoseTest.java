package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] inputItems = new Item[] {
    		new Item("+5 Dexterity Vest", 0, 0), 
            new Item("+5 Dexterity Vest", 10, 20), 
            new Item("Aged Brie", 2, 0),
            new Item("Aged Brie", 0, 0), 
            new Item("Elixir of the Mongoose", 5, 7), 
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };
    
    Item[] outputItems = new Item[] {
    		new Item("+5 Dexterity Vest", -1, 0),
            new Item("+5 Dexterity Vest", 9, 19), //
            new Item("Aged Brie", 1, 1),
            new Item("Aged Brie", -1, 2),//
            new Item("Elixir of the Mongoose", 4, 6), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 2, 4) };
    
    @Test
    void testUpdateQuality() {
        GildedRose app = new GildedRose(inputItems);
        app.updateQuality();
        for(int i=0; i < outputItems.length; i++) {
        	assertEquals(outputItems[i].toString(), app.items[i].toString());
        }
    }
    
    /*
     * In ideal case below method is not needed.
     * Added to compare the output with new code.
     */
    @Test
    void testOldUpdateQuality() {
    	GildedRoseOld app = new GildedRoseOld(inputItems);
        app.updateQuality();
        for(int i=0; i < outputItems.length; i++) {
        	System.out.println(app.items[i].toString());
        }
    }

}
