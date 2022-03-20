package com.example.shoppingcart;

public class LineItem {
    private long barcode;
    private int quantity;

    public LineItem(long barcode, int quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
