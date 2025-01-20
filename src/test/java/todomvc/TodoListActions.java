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
    public void addItem(TodoListItem item) {
        $("//input[@placeholder='What needs to be done?']").typeAndEnter(item.getTaskDescription());
    }

    @Step("'{0}' should be on the todo-list.")
    public void hasItem(TodoListItem item) {
        $("//app-todo-list//label[text()='" + item.getTaskDescription() + "']").shouldBePresent();
    }

    @Step("'{0}' should not be on the todo-list.")
    public void doesNotHaveItem(TodoListItem item) {
        $("//app-todo-list//label[text()='" + item.getTaskDescription() + "']").shouldNotBePresent();
    }

    @Step("Mark '{0}' as completed.")
    public void completeItem(TodoListItem item) {
        $("//label[text()='" + item.getTaskDescription() +"']/parent::div/input").click();
    }

    @Step("Filter on only active items.")
    public void showActive() {
        showItemsThatAre("Active");
    }

    @Step("Filter on only active items.")
    public void showCompleted() {
        showItemsThatAre("Completed");
    }

    private void showItemsThatAre(String status) {
        $("//a[text()='" + status +"']").click();
    }

    @Step("Remove the item '{0}'")
    public void deleteItem(TodoListItem item) {
        $("//label[text()='" + item.getTaskDescription() +"']/parent::div/label").click();
        $("//label[text()='" + item.getTaskDescription() +"']/parent::div/button").click();
    }
}
