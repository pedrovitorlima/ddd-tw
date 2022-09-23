package com.tw.dddtw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    @Test
    void shouldAddIpadProToCard(){
        Cart cart = new Cart();

        cart.addProduct(Product.IPAD_PRO);

        assertThat(cart.getProducts()).contains(Product.IPAD_PRO);
    }

    @Test
    void shouldAddProductToCart(){
        Cart cart = new Cart();

        cart.addProduct(Product.HERO_INK);

        assertThat(cart.getProducts()).contains(Product.HERO_INK);
    }
}