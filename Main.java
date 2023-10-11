package lab3;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		shoppingList myshoppingList = new shoppingList();
		Scanner sc = new Scanner (System.in);
		
		myshoppingList.addItem("Axcel's Graham Balls", "Food", 225);
		myshoppingList.addItem("White Rabbit", "Food", 47.75);
		myshoppingList.addItem("Clone MNL", "Perfume", 1200);
		myshoppingList.addItem("Bomber Jacket", "Clothing", 180);
		myshoppingList.addItem("Lenovo Airpods", "Gadget", 505);
		
		
		while (true) {
            System.out.println("LIQUIGAN'S SHOPPING LIST 101");
            System.out.println("\n1. Display Shopping List");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Mark Item as Purchased");
            System.out.println("5. Save Shopping List to File");
            System.out.println("6. Load Shopping List from File");
            System.out.println("7. Exit");
            System.out.println("\nAdditional Features (Insertion and Deletion):");
            System.out.println("8. Insert Item at the Beginning");
            System.out.println("9. Insert Item at the Middle");
            System.out.println("10. Insert Item at the End");
            System.out.println("11. Delete Item at the Beginning");
            System.out.println("12. Delete Item at the Middle");
            System.out.println("13. Delete Item at the End");
            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                myshoppingList.displayItems();
            } else if (choice == 2) {
                System.out.print("\nEnter item name: ");
                String itemName = sc.nextLine();
                System.out.print("Enter item description: ");
                String itemDescription = sc.nextLine();
                System.out.print("Enter item price: ");
                double itemPrice = sc.nextDouble();
                myshoppingList.addItem(itemName, itemDescription, itemPrice);
            } else if (choice == 3) {
                System.out.print("\nEnter item name to remove: ");
                String itemName = sc.nextLine();
                myshoppingList.removeItem(itemName);
            } else if (choice == 4) {
                System.out.print("\nEnter item name to mark as purchased: ");
                String itemName = sc.nextLine();
                myshoppingList.markAsPurchased(itemName);
            } else if (choice == 5) {
                System.out.print("\nEnter file name to save: ");
                String filename = sc.nextLine();
                myshoppingList.saveToFile(filename);
            } else if (choice == 6) {
                System.out.print("\nEnter file name to load: ");
                String filename = sc.nextLine();
                shoppingList loadedShoppingList = shoppingList.loadFromFile(filename);
                if (loadedShoppingList != null) {
                	myshoppingList = loadedShoppingList;
                    System.out.println("Shopping list loaded from " + filename);
                }
            } else if (choice == 7) {
                System.out.println("Thank you for using the program!");
                System.exit(0);
            } else if (choice == 8) {
                System.out.print("\nEnter item name to insert at the beginning: ");
                String itemName = sc.nextLine();
                System.out.print("Enter item description: ");
                String itemDescription = sc.nextLine();
                System.out.print("Enter item price: ");
                double itemPrice = sc.nextDouble();
                myshoppingList.insertItemAtBeginning(itemName, itemDescription, itemPrice);
            } else if (choice == 9) {
                System.out.print("\nEnter item name to insert at the middle: ");
                String itemName = sc.nextLine();
                System.out.print("Enter item description: ");
                String itemDescription = sc.nextLine();
                System.out.print("Enter item price: ");
                double itemPrice = sc.nextDouble();
                System.out.print("Enter position to insert (greater than 0): ");
                int position = sc.nextInt();
                myshoppingList.insertItemAtMiddle(itemName, itemDescription, itemPrice, position);
            } else if (choice == 10) {
                System.out.print("\nEnter item name to insert at the end: ");
                String itemName = sc.nextLine();
                System.out.print("Enter item description: ");
                String itemDescription = sc.nextLine();
                System.out.print("Enter item price: ");
                double itemPrice = sc.nextDouble();
                myshoppingList.insertItemAtEnd(itemName, itemDescription, itemPrice);
            } else if (choice == 11) {
                System.out.print("\nEnter item name to delete at the beginning: ");
                String itemName = sc.nextLine();
                myshoppingList.deleteItemAtBeginning(itemName);    
            } else if (choice == 12) {
                System.out.print("\nEnter position to delete (greater than 0): ");
                int position = sc.nextInt();
                myshoppingList.deleteItemAtMiddle(position);
            } else if (choice == 13) {
            	System.out.print("\nEnter item name to delete at the end: ");
            	String itemName = sc.nextLine();
                myshoppingList.deleteItemAtEnd(itemName);
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
