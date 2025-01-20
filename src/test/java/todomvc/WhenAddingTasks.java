package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static todomvc.TodoListItem.FEED_THE_CAT;
import static todomvc.TodoListItem.WALK_THE_DOG;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingTasks {

    @Managed()
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @BeforeEach
    public void setup() {
        todoList.openApplication();
    }

    // TODO: Exercise 1
    @Test
    public void addingASingleTask() {
        // Check that list is empty
        todoListShouldHaveSizeOf(0);
        // Add "Feed The Cat" to the list
        todoList.addItem(FEED_THE_CAT);
        // Check that "Feed The Cat" appears in the list
        todoListShouldHaveSizeOf(1);
    }

    private void todoListShouldHaveSizeOf(Integer size) {
        Serenity.reportThat("The todo-list should have "+ size +" items.",
                () -> assertThat(todoList.getSize()).isEqualTo(size));
    }

    // TODO: Exercise 2
    @Test
    public void addingMultipleTasks() {
        // Add "Feed The Cat" and "Walk the dog" to the list
        todoList.addItem(FEED_THE_CAT);
        todoList.addItem(WALK_THE_DOG);
        // Check that they all appear in the list
        todoListShouldHaveSizeOf(2);
        todoList.hasItem(FEED_THE_CAT);
        todoList.hasItem(WALK_THE_DOG);
    }

}
