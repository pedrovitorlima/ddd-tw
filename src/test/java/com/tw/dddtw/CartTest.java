package com.tw.dddtw;

import com.tw.dddtw.domain.Cart;
import com.tw.dddtw.domain.Item;
import com.tw.dddtw.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private Cart cart;
    @BeforeEach
    void setup() {
        this.cart = new Cart();
    }

    @ParameterizedTest
    @MethodSource("shouldAddAProduct_params")
    void shouldAddAProduct(String productName, Integer quantity) {
        addItemWith(productName, quantity);

        Item item = new Item(new Product(productName), quantity);
        assertThat(cart.getItems().contains(item));
    }

    @Test
    void shouldRemoveIpadProGivenQuantity() {
        addItemWith("IPAD PRO", null);
        Item item = new Item(new Product("IPAD PRO"), null);

        cart.removeItem("IPAD PRO");
        assertThat(cart.getItems()).doesNotContain(item);
    }

    @Test
    void shouldReturnAListOfRemovedItemNames(){
        Item item = new Item(new Product("IPAD PRO"), null);

        cart.addItem(item);
        cart.removeItem("IPAD PRO");

        List<String> itemNames = cart.getRemovedItemNames();

        assertThat(itemNames).contains("IPAD PRO");
    }

    @Test
    void shouldNotAddProductToListOfRemovedOnesGivenItWasNotRemovedBefore() {
        addItemWith("IPAD PRO", null);
        Item item = new Item(new Product("does not exist"), null);

        cart.removeItem("does not exist");
        assertThat(cart.getRemovedItemNames()).doesNotContain("IPAD PRO");
    }

    private static Stream<Arguments> shouldAddAProduct_params() {
        return Stream.of(
                Arguments.of("IPAD_PRO", null),
                Arguments.of("HERO_INK", null),
                Arguments.of("CRICKET_BAT", 2)
        );
    }

    private void addItemWith(String productName, Integer quantity) {
        cart.addItem( new Item(productName, quantity));
    }
}