import java.util.ArrayList;
import java.util.Scanner;

public class ToDo{
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the To Do List App!");
            System.out.println("To Do List Menu:");
            System.out.println("1- Add Task");
            System.out.println("2- Remove Task");
            System.out.println("3- Mark Task Complete");
            System.out.println("4- View Tasks");
            System.out.println("5- Exit Application");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case(1) -> addTask(scanner);
                case(2) -> removeTask(scanner);
                case(3) -> markTask(scanner);
                case(4) -> viewTask();
                case(5) -> System.out.println("Thanks for using the To Do List App!");
                default -> System.out.println("Invalid Choice; please try again or exit the app!");

            }
        } while (choice != 5);
    }
    public static void addTask(Scanner scanner){
        System.out.println("Enter task description:");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    public static void removeTask(Scanner scanner){
        viewTask();
        System.out.println("Please pick which task you want to remove:");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void viewTask(){
        if (tasks.isEmpty()) {
            System.out.println("Your to do list is empty!");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void markTask(Scanner scanner){
        System.out.println("Which task do you want to mark as completed?");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.get(taskNum - 1).setCompleted(true);
            System.out.println("Task is marked as completed!");
        } else {
            System.out.println("Task number invalid, please enter another.");
        }
    }
}