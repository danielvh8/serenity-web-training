package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingTasks {

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
        todoList.addItem("Feed The Cat");
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
        String item1 = "Feed The Cat";
        String item2 = "Walk the dog";
        // Add "Feed The Cat" and "Walk the dog" to the list
        todoList.addItem(item1);
        todoList.addItem(item2);
        // Check that they all appear in the list
        todoListShouldHaveSizeOf(2);
        todoList.hasItem(item1);
        todoList.hasItem(item2);
    }

}
