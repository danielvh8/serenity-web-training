package todomvc;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCompletingATask {

    @Steps
    TodoListActions todoList;

    @BeforeEach
    public void setup() {
        todoList.openApplication();
    }

    // TODO: Exercise 3
    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        // Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItem("Feed the cat");
        todoList.addItem("Walk the dog");
        // Complete "Feed the cat"
        todoList.completeItem("Feed the cat");
        // Filter by "Active"
        todoList.showActive();
        // Check that only "Walk the dog" appears
        todoList.hasItem("Walk the dog");
        todoList.doesNotHaveItem("Feed the cat");
    }

    // TODO: Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        todoList.addItem("Feed the cat");
        todoList.addItem("Walk the dog");
        // Complete "Feed the cat"
        todoList.completeItem("Feed the cat");
        // Filter by "Completed"
        todoList.showCompleted();
        // Check that only "Feed the cat" appears
        todoList.hasItem("Feed the cat");
        todoList.doesNotHaveItem("Walk the dog");
    }
}
