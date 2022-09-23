package com.tw.dddtw.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Cart {

    private List<Item> items = new ArrayList<>();
    private List<String> removedItemNames = new ArrayList<>();


    public void addItem(Item item) {
        items.add( item);
    }

    public void removeItem(String productName) {
        List<Item> filteredList = items.stream()
                .filter(product -> !product.getProduct().getName().equals(productName))
                .collect(Collectors.toList());

        if (!filteredList.equals(items)) {
            removedItemNames.add(productName);
        }

        items = filteredList;
    }
}

