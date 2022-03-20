package com.example.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Inventory inventory;
    private List<LineItem> cart = new ArrayList<>();
    private double totalBill;

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public int getTotalLineItems() {
        return cart.size();
    }

    public void addItemToCart(LineItem lineItem) {
        LineItem existingLineItem = cart.stream().filter(item -> item.getBarcode() == lineItem.getBarcode())
                .findFirst().orElse(null);
        if (existingLineItem == null) {
            cart.add(lineItem);
        } else {
            existingLineItem.updateQuantity(lineItem.getQuantity());
        }
    }

    public int getCartTotalQuantity() {
        return cart.stream().mapToInt(LineItem::getQuantity).sum();
    }

    public void calculateCartTotalBill() {
        for (LineItem lineItem : cart) {
            totalBill = totalBill + lineItem.getQuantity() * inventory.getItem(lineItem.getBarcode()).getPrice();
        }
    }

}
