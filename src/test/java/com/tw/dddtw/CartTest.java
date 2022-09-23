package com.tw.dddtw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private Cart cart;
    @BeforeEach
    void setup() {
        this.cart = new Cart();
    }

    @Test
    void shouldAddIpadProToCard(){
        cart.addProduct(Product.IPAD_PRO);

        assertThat(cart.getProducts().containsKey(Product.IPAD_PRO));
    }

    @Test
    void shouldAddProductToCart(){
        cart.addProduct(Product.HERO_INK);

        assertThat(cart.getProducts()).containsKey(Product.HERO_INK);
    }

    @Test
    void shouldAddCricketBatWith2Units() {
        final Integer amountOfCricketBats = 2;
        cart.addProduct(Product.CRICKET_BAT, amountOfCricketBats);

        assertThat(cart.getProducts().get(Product.CRICKET_BAT)).isEqualTo(amountOfCricketBats);
    }
}