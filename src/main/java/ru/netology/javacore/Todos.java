package ru.netology.javacore;

import java.util.ArrayList;
import java.util.List;

public class Todos {

    private List<String> toDoList = new ArrayList<>();

    public void addTask(String task) {
        toDoList.add(task);
    }

    public void removeTask(String task) {
        toDoList.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        toDoList.stream().sorted().forEach(task -> sb.append(task).append(" "));
        return sb.toString().trim();
    }

}
