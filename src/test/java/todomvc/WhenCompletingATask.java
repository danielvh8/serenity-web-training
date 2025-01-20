package todomvc;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static todomvc.TodoListItem.FEED_THE_CAT;
import static todomvc.TodoListItem.WALK_THE_DOG;

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
        todoList.addItem(FEED_THE_CAT);
        todoList.addItem(WALK_THE_DOG);
        // Complete "Feed the cat"
        todoList.completeItem(FEED_THE_CAT);
        // Filter by "Active"
        todoList.showActive();
        // Check that only "Walk the dog" appears
        todoList.hasItem(WALK_THE_DOG);
        todoList.doesNotHaveItem(FEED_THE_CAT);
    }

    // TODO: Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        todoList.addItem(FEED_THE_CAT);
        todoList.addItem(WALK_THE_DOG);
        // Complete "Feed the cat"
        todoList.completeItem(FEED_THE_CAT);
        // Filter by "Completed"
        todoList.showCompleted();
        // Check that only "Feed the cat" appears
        todoList.hasItem(FEED_THE_CAT);
        todoList.doesNotHaveItem(WALK_THE_DOG);
    }
}
