package com.tw.dddtw;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product productName) {
        addProduct(productName, null);
    }

    public void addProduct(Product productName, Integer qtd) {
        products.put(productName, qtd);
    }

}

enum Product {
    IPAD_PRO,
    CRICKET_BAT, HERO_INK
}
