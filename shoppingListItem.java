package lab3;

	class shoppingListItem {
		String itemName;
		String itemDescription;
		double itemPrice;
		boolean purchased;
		shoppingListItem Next;
		
		shoppingListItem(String itemName, String itemDescription, double itemPrice){
			this.itemName = itemName;
			this.itemDescription = itemDescription;
			this.itemPrice = itemPrice;
			this.purchased = false;
			this.Next = null;
		}
		
	}
	
	
	
	
	
