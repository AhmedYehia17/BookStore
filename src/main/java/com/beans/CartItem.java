package com.beans;
import java.io.Serializable;

public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookISBN;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String bookISBN, int quantity) {
        this.bookISBN = bookISBN;
        this.quantity = quantity;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
