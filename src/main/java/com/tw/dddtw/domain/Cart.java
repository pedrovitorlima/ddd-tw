package com.tw.dddtw.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Cart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add( item);
    }

    public void removeItem(String productName) {
        items = items.stream()
                .filter(product -> !product.getProduct().getName().equals(productName))
                .collect(Collectors.toList());
    }
}

