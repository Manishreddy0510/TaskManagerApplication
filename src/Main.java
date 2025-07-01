package src;

import java.util.*;

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTask() {
        try {
            System.out.print("Enter Task ID: ");
            int id = getValidIntegerInput();

            System.out.print("Enter Task Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Due Date (e.g., 2025-07-01): ");
            String dueDate = scanner.nextLine();

            System.out.print("Enter Priority (High/Medium/Low): ");
            String priority = scanner.nextLine();

            tasks.add(new Task(id, name, dueDate, priority));
            System.out.println("Task added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add task. Please check your input.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("\n--- All Tasks ---");
        tasks.forEach(System.out::println);
    }

    private static void updateTask() {
        System.out.print("Enter Task ID to update: ");
        int id = getValidIntegerInput();

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter new Task Name: ");
        task.setTaskName(scanner.nextLine());

        System.out.print("Enter new Due Date: ");
        task.setDueDate(scanner.nextLine());

        System.out.print("Enter new Priority: ");
        task.setPriority(scanner.nextLine());

        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = getValidIntegerInput();

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        tasks.remove(task);
        System.out.println("Task deleted successfully.");
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getTaskId() == id) return task;
        }
        return null;
    }

    private static int getValidIntegerInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
