package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class AddToCartActions extends UIInteractionSteps {

    @Step("Add {0} to the cart.")
    public void item(InventoryItem item) {
        find(By.xpath("//*[@data-test='add-to-cart-" + item.getDataId() + "']")).click();
    }
}
