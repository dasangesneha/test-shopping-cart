package com.example.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    private Inventory inventory;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        initializeInventory();
        shoppingCart = new ShoppingCart(inventory);
    }

    @Test
    void whenItemAddedToCartThenLineItemIsAddedAndTotalQuantityUpdated() {
        LineItem apple = new LineItem(110011, 1);
        LineItem banana = new LineItem(110012, 2);
        LineItem carrot = new LineItem(110013, 1);

        shoppingCart.addItemToCart(apple);
        shoppingCart.addItemToCart(banana);
        shoppingCart.addItemToCart(carrot);

        assertEquals(3, shoppingCart.getTotalLineItems());
        assertEquals(4, shoppingCart.getCartTotalQuantity());
    }

    @Test
    void whenDuplicateItemAddedToCartThenTotalQuantityUpdatedAndLineItemIsUnchanged() {
        LineItem apple = new LineItem(110011, 1);
        LineItem carrot = new LineItem(110013, 2);
        LineItem fewMoreApples = new LineItem(110011, 2);

        shoppingCart.addItemToCart(apple);
        shoppingCart.addItemToCart(carrot);
        shoppingCart.addItemToCart(fewMoreApples);

        assertEquals(2, shoppingCart.getTotalLineItems());
        assertEquals(5, shoppingCart.getCartTotalQuantity());
    }

    @Test
    void givenInventoryItemsWhenAddedItemsToCartThenCalculateTotalBill() {
        LineItem apple = new LineItem(110011, 1);
        LineItem banana = new LineItem(110012, 2);
        shoppingCart.addItemToCart(apple);
        shoppingCart.addItemToCart(banana);

        shoppingCart.calculateCartTotalBill();

        assertEquals(3.7, shoppingCart.getTotalBill());
    }

    private void initializeInventory() {
        Item item1 = new Item(110011, "Apple", 1.1);
        Item item2 = new Item(110012, "Banana", 1.3);
        Item item3 = new Item(110013, "Carrot", 0.9);

        inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
    }

}
