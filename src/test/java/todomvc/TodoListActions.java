package todomvc;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class TodoListActions extends UIInteractionSteps {
    @Step("Open the 'todomvc' application.")
    public void openApplication() {
        openUrl("https://todomvc.com/examples/angular/dist/browser/#/all");
    }

    public Integer getSize() {
        return $$("//app-todo-list//app-todo-item").size();
    }

    @Step("Add '{0}' to the todo-list.")
    public void addItem(String itemName) {
        $("//input[@placeholder='What needs to be done?']").typeAndEnter(itemName);
    }

    @Step("'{0}' should be on the todo-list.")
    public void hasItem(String item1) {
        $("//app-todo-list//label[text()='" + item1 + "']").shouldBePresent();
    }
}
