package serenityswag.cart;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.inventory.InventoryItem;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CartActions extends UIInteractionSteps {

    public boolean checkIsEmpty() {
        return $("//*[@data-test='inventory-item']").thenFindAll().isEmpty();
    }

    public void continueShopping() {
        $("//button[@data-test='continue-shopping']").click();
    }

    public boolean checkItemsInCart(ArrayList<InventoryItem> items) {
        for (InventoryItem item: items) {
            if (!$("//*[@data-test='inventory-item']//*[text()='" + item.getName() + "']").isVisible()) {
                return false;
            }
        }
        return true;
    }
}
