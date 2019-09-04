package Beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	
	

	public Cart(ArrayList<Item> items) {
		this.items = items;
	}
	
	public Cart() {
		items = new ArrayList<Item>();
	}

	
	
	private ArrayList<Item> items;

	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void deleteItem(Item i){
		items.remove(i);
	}
	
	public void removeAnItem(String taglia, String colore, int prodotto){
		
		for(Item i: items){
			if(i.getTaglia().equalsIgnoreCase(taglia) && i.getColore().equalsIgnoreCase(colore) && prodotto == i.getProdotto()){
				items.remove(i);
				break;
			}
		}
		
	}
	
	public void removeAllItem(String taglia, String colore, int prodotto){
		
		List<Item> toRemove = new ArrayList<Item>();
			
		
			for(Item i: items){
				if(i.getTaglia().equalsIgnoreCase(taglia) && i.getColore().equalsIgnoreCase(colore) && prodotto == i.getProdotto()){
					toRemove.add(i);
				}
			}
			
			items.removeAll(toRemove);
			
		}
	


	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}