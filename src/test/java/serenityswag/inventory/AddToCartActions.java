package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class AddToCartActions extends UIInteractionSteps {
    public void item(InventoryItem item) {
        find(By.xpath("//*[@data-test='add-to-cart-" + item.getDataId() + "']")).click();
    }
}
