package com.tw.dddtw;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product productName) {
        products.add(productName);
    }

}

enum Product {
    IPAD_PRO,
    HERO_INK
}
