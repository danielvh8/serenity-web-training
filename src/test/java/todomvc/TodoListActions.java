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
    public void hasItem(String item) {
        $("//app-todo-list//label[text()='" + item + "']").shouldBePresent();
    }

    @Step("'{0}' should not be on the todo-list.")
    public void doesNotHaveItem(String item) {
        $("//app-todo-list//label[text()='" + item + "']").shouldNotBePresent();
    }

    @Step("Mark '{0}' as completed.")
    public void completeItem(String itemName) {
        $("//label[text()='" + itemName +"']/parent::div/input").click();
    }

    @Step("Filter on only active items.")
    public void showActive() {
        $("//a[text()='Active']").click();
    }

    @Step("Filter on only active items.")
    public void showCompleted() {
        $("//a[text()='Completed']").click();
    }
}
