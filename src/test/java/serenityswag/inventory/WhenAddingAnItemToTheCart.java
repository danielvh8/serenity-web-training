package serenityswag.inventory;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;
import serenityswag.cart.CartActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Steps
    LoginActions login;

    @Steps
    AddToCartActions addToCart;

    @Steps
    ViewCartActions openCart;

    @Steps
    CartActions fromCart;

    InventoryPage inventoryPage;

    @BeforeEach
    public void login() {
        login.as(STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShouldBeShown() {
        addToCart.item(InventoryItem.BACKPACK);
        verifyBadgeCountIs(1);

        addToCart.item(InventoryItem.BIKE_LIGHT);
        verifyBadgeCountIs(2);

        addToCart.item(InventoryItem.BOLT_T_SHIRT);
        verifyBadgeCountIs(3);

        addToCart.item(InventoryItem.FLEECE_JACKET);
        verifyBadgeCountIs(4);

        addToCart.item(InventoryItem.ONESIE);
        verifyBadgeCountIs(5);

        addToCart.item(InventoryItem.T_SHIRT_RED);
        verifyBadgeCountIs(6);

    }

    public void verifyBadgeCountIs (Integer expected) {
        Serenity.reportThat(
                String.format("The cart badge count should be %s.", expected),
                () -> assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(expected));

    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

        // open the shopping cart
        openCart.fromIcon();
        // validate the cart is empty
        assertThat(fromCart.checkIsEmpty()).isEqualTo(true);

        fromCart.continueShopping();
        addToCart.item(InventoryItem.BACKPACK);
        items.add(InventoryItem.BACKPACK);

        // open the shopping cart
        openCart.fromIcon();
        // validate the correct item has been added
        assertThat(fromCart.checkItemsInCart(items)).isEqualTo(true);

        fromCart.continueShopping();
        addToCart.item(InventoryItem.ONESIE);
        items.add(InventoryItem.ONESIE);

        // open the shopping cart
        openCart.fromIcon();
        // validate the correct item has been added
        assertThat(fromCart.checkItemsInCart(items)).isEqualTo(true);
    }
}
