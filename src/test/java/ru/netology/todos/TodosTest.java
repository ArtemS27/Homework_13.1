package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(1, "Buy a bread and milk");

    String[] subtasks = {"milk", "milk", "bread"};
    Epic epic = new Epic(2, subtasks);

    Meeting meeting = new Meeting(
            3,
            "Add a bread and milk in the app",
            "Grocery list application",
            "On monday");

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType(){
        SimpleTask simpleTask = new SimpleTask(5, "Call parents");

        String[] subtasks = {"Milk", "Eggs", "Bread"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Release 3rd version of the application",
                "Application NetoBank",
                "On tuesday after lunch");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchResultHasThreeMatches(){
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("bread");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchResultHasOneMatch(){
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("app");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchResultHasNoMatches(){
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("butter");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchResultHasMatchesInMultipleParameters(){
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("milk");

        Assertions.assertArrayEquals(expected, actual);
    }
}
