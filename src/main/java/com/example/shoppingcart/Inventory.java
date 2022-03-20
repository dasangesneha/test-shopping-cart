package com.example.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Long, Item> itemMap = new HashMap<>();

    public void addItem(Item item) {
        itemMap.put(item.getBarcode(), item);
    }

    public Item getItem(long barcode) {
        return itemMap.get(barcode);
    }

}
