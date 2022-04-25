package ru.netology.javacore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    @Test
    public void testAddTask() {
        final Todos todos = new Todos();
        todos.addTask("Покормить котиков");
        final String result = todos.getAllTasks();
        assertEquals(result, "Покормить котиков");
    }

    @Test
    public void testSortingTodos() {
        final Todos todos = new Todos();
        todos.addTask("Покормить котиков");
        todos.addTask("Погладить котиков");
        todos.addTask("Поиграть с котиками");
        final String result = todos.getAllTasks();
        assertEquals(result, "Погладить котиков Поиграть с котиками Покормить котиков");
    }

    @Test
    public void testRemoveTask() {
        final Todos todos = new Todos();
        todos.addTask("Покормить котиков");
        todos.addTask("Погладить котиков");
        todos.addTask("Поиграть с котиками");
        todos.removeTask("Поиграть с котиками");
        final String result = todos.getAllTasks();
        assertEquals(result, "Погладить котиков Покормить котиков");
    }


}
