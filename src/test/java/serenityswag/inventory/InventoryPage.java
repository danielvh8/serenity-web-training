package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class InventoryPage extends PageObject {
    public String getHeading() {
        return $(".title").getText();
    }

    public Integer getCartBadgeCount() {return Integer.valueOf($(".shopping_cart_badge").getText()); }

}
