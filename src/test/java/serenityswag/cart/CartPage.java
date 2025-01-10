package serenityswag.cart;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class CartPage extends PageObject {
    public WebElementState hasNoItems() {
        return $("//*[@data-test='inventory-item']").shouldNotBePresent();
    }
}
