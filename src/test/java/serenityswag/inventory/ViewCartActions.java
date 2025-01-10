package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ViewCartActions extends UIInteractionSteps {
    public void fromIcon() {
        find(By.xpath("//*[@data-test='shopping-cart-link']")).click();
    }
}
