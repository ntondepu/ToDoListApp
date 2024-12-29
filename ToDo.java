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
}