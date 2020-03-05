package com.gildedrose;

class GildedRose {
	
    public Item[] items;
    private int normalItemUpgradeRate = 1;
    
    private int normalItemDegradeRate = 1;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    /*
     * update Quality
     */
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	processItem(items[i]);
        }
    }
    
  private void processItem(Item item) {
  	switch (getCaseName(item.name)) {
  	case "Aged Brie":
  		upgradeQuality(item, normalItemUpgradeRate);
  		item.sellIn = item.sellIn - 1;
  		 if (item.sellIn < 0) {
  			 upgradeQuality(item, normalItemUpgradeRate);
  		 }
  		break;
  	case "Backstage passes":
          if (item.sellIn < 6) {
          	upgradeQuality(item, 2);
          }else if (item.sellIn < 11) {
          	upgradeQuality(item, 3);
          }else {
        	  upgradeQuality(item, 1); 
          }
          item.sellIn = item.sellIn - 1;
          if (item.sellIn < 0) {
          	item.quality=0;
          }
  		break;        		
  	case "Sulfuras, Hand of Ragnaros":
  		break;
  	case "Conjured":
  		degradeQuality(item, normalItemDegradeRate*2);
  		item.sellIn = item.sellIn - 1;  		
  	   break;
  	default:
  		degradeQuality(item, normalItemDegradeRate);
  		item.sellIn = item.sellIn - 1;
          if (item.sellIn < 0) {
          	degradeQuality(item, normalItemDegradeRate*2);
          }
  		break;
  	}
  
  }
  private void upgradeQuality(Item item, int upgradeRate) {
      if (item.quality < 50) {
    	  item.quality = item.quality + upgradeRate;
      }
      if(item.quality > 50) {
    	  item.quality = 50;
      }
  }
  
  private void degradeQuality(Item item, int degradeRate) {
      if (item.quality > 0) {
    	  item.quality = item.quality - degradeRate;
      }
      if (item.quality < 0) {
    	  item.quality=0;
      }
  }
  
  private String getCaseName(String itemName) {
	  if(itemName.contains("Backstage passes")) {
		  return "Backstage passes";
	  }else if(itemName.contains("Conjured")) {
		  return "Conjured";
	  }
	  return itemName;
 }
}