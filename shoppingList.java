package lab3;

import java.io.*;
import java.text.DecimalFormat;

public class shoppingList {
	
	shoppingListItem head;
	
	void addItem(String itemName, String itemDescription, double itemPrice) {
		shoppingListItem newshoppingListItem = new shoppingListItem (itemName, itemDescription, itemPrice);
		if (head == null) {
			head = newshoppingListItem;
		} else {
			shoppingListItem current = head;
			while (current.Next != null) {
				current = current.Next;
			}
			current.Next = newshoppingListItem;
		}
	}
	
	void removeItem(String itemName) {
        if (head == null) {
            System.out.println("Shopping list is empty");
            return;
        }

        if (head.itemName.equals(itemName)) {
            head = head.Next;
            return;
        }

        shoppingListItem current = head;
        while (current.Next != null) {
            if (current.Next.itemName.equals(itemName)) {
                current.Next = current.Next.Next;
                return;
            }
            current = current.Next;
        }

        System.out.println("Item not found: " + itemName);
    }
	
	void displayItems() {
		DecimalFormat df = new DecimalFormat("0.00");
        if (head == null) {
            System.out.println("Shopping list is empty");
            return;
        }
        shoppingListItem current = head;
        while (current != null) {
            System.out.println("\nItem: " + current.itemName);
            System.out.println("Description: " + current.itemDescription);
            String dformat = df.format(current.itemPrice);
            System.out.println("Price: P" + dformat);
            System.out.println("Purchased: " + (current.purchased ? "Yes" : "No"));
            System.out.println("\n--------------------");
            current = current.Next;
        }
    }
	
	void markAsPurchased(String itemName) {
        shoppingListItem current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                current.purchased = true;
                return;
            }
            current = current.Next;
        }
        System.out.println("Item not found: " + itemName);
    }
	
	void saveToFile(String filename) {
		try (FileWriter fileWriter = new FileWriter(filename)) {
            shoppingListItem current = head;
            while (current != null) {
                fileWriter.write(current.itemName + "\n");
                fileWriter.write(current.itemDescription + "\n");
                fileWriter.write(current.itemPrice + "\n");
                fileWriter.write(current.purchased + "\n");
                current = current.Next;
            }
            System.out.println("Shopping list saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	static shoppingList loadFromFile(String filename) {
		shoppingList loadedshoppingList = new shoppingList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String itemName = line;
                String itemDescription = reader.readLine();
                double itemPrice = Double.parseDouble(reader.readLine());
                boolean isPurchased = Boolean.parseBoolean(reader.readLine());
                loadedshoppingList.addItem(itemName, itemDescription, itemPrice);
                shoppingListItem currentItem = loadedshoppingList.head;
                while (currentItem.Next != null) {
                    currentItem = currentItem.Next;
                }
                currentItem.purchased = isPurchased;
            }
            System.out.println("Shopping list loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedshoppingList;
    }
	
	void insertItemAtBeginning(String itemName, String itemDescription, double itemPrice) {
        shoppingListItem newShoppingListItem = new shoppingListItem(itemName, itemDescription, itemPrice);
        newShoppingListItem.Next = head;
        head = newShoppingListItem;
    }
	
	void insertItemAtMiddle(String itemName, String itemDescription, double itemPrice, int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Please enter a position greater than 0.");
            return;
        }

        shoppingListItem newShoppingListItem = new shoppingListItem(itemName, itemDescription, itemPrice);

        if (position == 1) {
            newShoppingListItem.Next = head;
            head = newShoppingListItem;
        } else {
            shoppingListItem current = head;
            int currentPosition = 1;
            while (current != null && currentPosition < position - 1) {
                current = current.Next;
                currentPosition++;
            }

            if (current == null) {
                System.out.println("Position exceeds the length of the list. Item not inserted.");
            } else {
                newShoppingListItem.Next = current.Next;
                current.Next = newShoppingListItem;
            }
        }
    }

	void insertItemAtEnd(String itemName, String itemDescription, double itemPrice) {
        shoppingListItem newShoppingListItem = new shoppingListItem(itemName, itemDescription, itemPrice);
        if (head == null) {
            head = newShoppingListItem;
        } else {
            shoppingListItem current = head;
            while (current.Next != null) {
                current = current.Next;
            }
            current.Next = newShoppingListItem;
        }
    }

    void deleteItemAtBeginning(String itemName) {
        if (head == null) {
            System.out.println("Shopping list is empty");
            return;
        }

        if (head.itemName.equals(itemName)) {
            head = head.Next;
        } else {
            System.out.println("Item not found at the beginning: " + itemName);
        }
    }

    void deleteItemAtMiddle(int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Please enter a position greater than 0.");
            return;
        }

        if (position == 1) {
            head = head.Next;
        } else {
            shoppingListItem current = head;
            int currentPosition = 1;
            while (current != null && currentPosition < position - 1) {
                current = current.Next;
                currentPosition++;
            }

            if (current == null || current.Next == null) {
                System.out.println("Position exceeds the length of the list. Item not deleted.");
            } else {
                current.Next = current.Next.Next;
            }
        }
    }

    void deleteItemAtEnd(String itemName) {
        if (head == null) {
            System.out.println("Shopping list is empty");
            return;
        }

        if (head.Next == null) {
            if (head.itemName.equals(itemName)) {
                head = null;
            } else {
                System.out.println("Item not found at the end: " + itemName);
            }
        } else {
            shoppingListItem current = head;
            shoppingListItem prev = null;

            while (current.Next != null) {
                prev = current;
                current = current.Next;
            }

            if (current.itemName.equals(itemName)) {
                prev.Next = null;
            } else {
                System.out.println("Item not found at the end: " + itemName);
            }
        }
    }
}
