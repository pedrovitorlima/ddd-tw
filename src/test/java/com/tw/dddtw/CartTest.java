package com.tw.dddtw;

import com.tw.dddtw.domain.Cart;
import com.tw.dddtw.domain.Item;
import com.tw.dddtw.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Currency;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private Cart cart;
    @BeforeEach
    void setup() {
        this.cart = new Cart(1);
    }

    @ParameterizedTest
    @MethodSource("shouldAddAProduct_params")
    void shouldAddAProduct(String productName, Integer quantity, Price price) {
        addItemWith(productName, quantity);

        Product product = new Product(productName, price);
        Item item = new Item(product, quantity);
        assertThat(cart.getItems().contains(item));
    }

    @Test
    void shouldRemoveIpadProGivenQuantity() {
        addItemWith("IPAD PRO", null);
        Product ipadPro = new Product("IPAD PRO", localPrice());
        Item item = new Item(ipadPro, null);

        cart.removeItem("IPAD PRO");
        assertThat(cart.getItems()).doesNotContain(item);
    }

    @Test
    void shouldReturnAListOfRemovedItemNames(){
        Item item = new Item(new Product("IPAD PRO", localPrice()), null);

        cart.addItem(item);
        cart.removeItem("IPAD PRO");

        List<String> itemNames = cart.getRemovedItemNames();

        assertThat(itemNames).contains("IPAD PRO");
    }

    @Test
    void shouldNotAddProductToListOfRemovedOnesGivenItWasNotRemovedBefore() {
        addItemWith("IPAD PRO", null);

        cart.removeItem("does not exist");
        assertThat(cart.getRemovedItemNames()).doesNotContain("IPAD PRO");
    }

    @Test
    void should() {
        Cart anotherCart = new Cart(2);

        Item item = new Item(new Product("IPAD PRO", localPrice()), null);

        cart.addItem(item);
        anotherCart.addItem(item);

        assertThat(cart).isNotEqualTo(anotherCart);

    }

    private static Stream<Arguments> shouldAddAProduct_params() {
        return Stream.of(
                Arguments.of("IPAD_PRO", null, localPrice()),
                Arguments.of("HERO_INK", null, localPrice()),
                Arguments.of("CRICKET_BAT", 2, localPrice())
        );
    }

    private void addItemWith(String productName, Integer quantity) {
        Price price = localPrice();

        Product product = new Product(productName, price);
        cart.addItem( new Item(product, quantity));
    }

    private static Price localPrice() {
        return new Price(Currency.getInstance("USD"));
    }
}