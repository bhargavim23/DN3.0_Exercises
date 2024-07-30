package taskManagementSystem;

import java.util.Scanner;

public class TaskManager {

    // Task class
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    public static class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private TaskNode head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        TaskNode newNode = new TaskNode(newTask);

        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + newTask);
    }

    // Search for a task by taskId
    public void searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                System.out.println("Task found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Delete a task by taskId
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task with ID " + taskId + " has been deleted.");
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task with ID " + taskId + " has been deleted.");
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    // Traverse and display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode current = head;
        System.out.println("Tasks List:");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Main method to interact with the TaskManager
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Search Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int taskId = sc.nextInt();
                    System.out.print("Enter Task Name: ");
                    String taskName = sc.next();
                    System.out.print("Enter Task Status: ");
                    String status = sc.next();
                    taskManager.addTask(taskId, taskName, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID: ");
                    int deleteId = sc.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Task ID: ");
                    int searchId = sc.nextInt();
                    taskManager.searchTask(searchId);
                    break;
                case 4:
                    taskManager.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
