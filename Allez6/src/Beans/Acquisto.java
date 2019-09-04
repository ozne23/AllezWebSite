package Beans;

public class Acquisto {
	
	public Acquisto(Item item, int quantità) {
		this.item = item;
		this.quantità = quantità;
	}

	private Item item;
	
	private int quantità;
	
	
	public void incrementa() {
		quantità++;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	

}
