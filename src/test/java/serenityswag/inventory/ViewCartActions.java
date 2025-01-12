package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ViewCartActions extends UIInteractionSteps {

    @Step("Navigate to the shopping cart via the icon.")
    public void fromIcon() {
        find(By.xpath("//*[@data-test='shopping-cart-link']")).click();
    }
}
