package todomvc;

public enum TodoListItem {
    FEED_THE_CAT("Feed the cat"),
    WALK_THE_DOG("Walk the dog");

    private final String taskDescription;

    TodoListItem(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        return this.taskDescription;
    }
}
