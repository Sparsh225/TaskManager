package task;

import java.util.ArrayList;
import java.util.Scanner;

public class view {

	public static void main(String[] args) {
		System.out.println("Welcome to Task Manager Crud App ");
		Scanner sc = new Scanner(System.in);
		ArrayList<Task> arr = new ArrayList<>();
		while (true) {
			System.out.println(" Menu ");
			System.out.println("1. Add new task \t 4. Delete task ");
			System.out.println("2. Read all task \t 5. Exit ");
			System.out.println("3. Update task");
			System.out.println("Enter your choice ");
			int ch = sc.nextInt();
			if (ch == 1) {
				createtask(arr, sc);
			} else if (ch == 2) {
				readalltask(arr);
			} else if (ch == 3) {
				updatetask(arr, sc);
			} else if (ch == 4) {
				deletetask(arr, sc);
			} else {
				break;
			}
		}
		sc.close();
	}

	public static void createtask(ArrayList<Task> arr, Scanner sc) {
		sc.nextLine();
		System.out.println("Enter Name :- ");
		String name = sc.nextLine();
		System.out.println("Enter Description :- ");
		String desc = sc.nextLine();
		Task task = new Task(name, desc);
		arr.add(task);
	}

	public static void readalltask(ArrayList<Task> arr) {
		for (Task a : arr) {
			System.out.println("Name \t \t \t  Description ");
			System.out.println(a.name + "\t\t\t  " + a.desc);
		}
	}

	public static void updatetask(ArrayList<Task> arr, Scanner sc) {
		sc.nextLine();
		System.out.print("Enter the name of the task that has to be updated ");
		String name = sc.nextLine();
		System.out.print(name);
		Task x = null;
		for (Task task : arr) {
			if (task.name.equals(name)) {
				x = task;
				break;
			}
		}
		if (x == null) {
			System.out.println("Task not found ..");
		} else {
			System.out.println("Enter the updated description ");
			String desc = sc.nextLine();
			x.desc = desc;
			System.out.println("Task Updated Successfully ");
		}
	}

	public static void deletetask(ArrayList<Task> arr, Scanner sc) {
		System.out.println("Enter the task name to be deleted ");
		String name = sc.nextLine();
		boolean flag = true;
		for (int i = 0; i < arr.size(); i++) {
			Task x = arr.get(i);
			if (x.name.equals(name)) {
				arr.remove(i);
				flag = false;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Task Not found..");
		} else {
			System.out.println("Task Deleted Successfully..");
		}
	}
}
