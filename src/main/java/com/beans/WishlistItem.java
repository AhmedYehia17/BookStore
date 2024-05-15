package com.beans;

import java.io.Serializable;

public class WishlistItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookISBN;

    public WishlistItem() {
    }

    public WishlistItem(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }
}