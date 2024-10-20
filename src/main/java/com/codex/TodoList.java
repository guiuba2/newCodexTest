package com.codex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    // Remove a task
    public void removeTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Display all tasks
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Save the task list to a file
    public void saveTasksToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    // Load the task list from a file
    public static TodoList loadTasksFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (TodoList) ois.readObject();
        }
    }

    public static void showMenu() { //main(String[] args)
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();
        String filename = "D:\\variousTests\\tasks.ser";

        // Try to load saved tasks
        try {
            todoList = TodoList.loadTasksFromFile(filename);
            System.out.println("Tasks loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous tasks found. Starting a new to-do list.");
        }

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Show tasks");
            System.out.println("2. Add new task");
            System.out.println("3. Delete a task");
            System.out.println("4. Exit and save");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    todoList.showTasks();
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 3:
                    todoList.showTasks();
                    System.out.print("Enter the task number to delete: ");
                    int taskNumber = scanner.nextInt();
                    todoList.removeTask(taskNumber);
                    break;
                case 4:
                    try {
                        todoList.saveTasksToFile(filename);
                        System.out.println("Tasks saved to file. Exiting.\n");
                        return;
                    } catch (IOException e) {
                        System.out.println("Error saving tasks to file.");
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
