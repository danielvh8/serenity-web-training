package serenityswag.inventory;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;
import serenityswag.cart.CartActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void theCorrectItemCountShouldBeShown() {
        login.as(User.STANDARD_USER);

        addToCart.item(InventoryItem.BACKPACK);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(1);

        addToCart.item(InventoryItem.BIKE_LIGHT);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(2);

        addToCart.item(InventoryItem.BOLT_T_SHIRT);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(3);

        addToCart.item(InventoryItem.FLEECE_JACKET);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(4);

        addToCart.item(InventoryItem.ONESIE);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(5);

        addToCart.item(InventoryItem.T_SHIRT_RED);
        assertThat(inventoryPage.getCartBadgeCount()).isEqualTo(6);

    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

        login.as(User.STANDARD_USER);

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
