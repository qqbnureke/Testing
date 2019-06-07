package com.nurda.chocotask.model;

public class Book {
    String name;
    int pagesCount;
    int price;

    public Book(String name, int pagesCount, int price) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
