package serenityswag.cart;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.inventory.InventoryItem;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CartActions extends UIInteractionSteps {

    @Step("Check that the shopping cart is empty.")
    public boolean checkIsEmpty() {
        return $("//*[@data-test='inventory-item']").thenFindAll().isEmpty();
    }

    @Step("From the shopping cart click the 'continue shopping' button.")
    public void continueShopping() {
        $("//button[@data-test='continue-shopping']").click();
    }

    @Step("Check whether {0} are in the cart.")
    public boolean checkItemsInCart(ArrayList<InventoryItem> items) {
        for (InventoryItem item: items) {
            if (!$("//*[@data-test='inventory-item']//*[text()='" + item.getName() + "']").isVisible()) {
                return false;
            }
        }
        return true;
    }
}
