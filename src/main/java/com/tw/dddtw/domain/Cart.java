package com.tw.dddtw.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Product product, Integer quantity) {
        items.add( new Item(product, quantity));
    }

    public void removeItem(String productName) {
        items.stream().filter(product -> product.getProduct().getName() != productName);
    }
}

