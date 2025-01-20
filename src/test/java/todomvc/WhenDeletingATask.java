package todomvc;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static todomvc.TodoListItem.FEED_THE_CAT;
import static todomvc.TodoListItem.WALK_THE_DOG;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDeletingATask {

    @Steps
    TodoListActions todoList;

    @BeforeEach
    public void setup() {
        todoList.openApplication();
    }

    // TODO: Exercise 5
    @Test
    public void deletedItemsShouldDissapearFromTheList() {
        // Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItem(FEED_THE_CAT);
        todoList.addItem(WALK_THE_DOG);
        // Delete "Feed the cat"
        todoList.deleteItem(FEED_THE_CAT);
        // Check that only "Walk the dog" appears
        todoList.hasItem(WALK_THE_DOG);
        todoList.doesNotHaveItem(FEED_THE_CAT);
    }
}