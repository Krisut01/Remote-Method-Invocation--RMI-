import java.rmi.RemoteException;

public class Product implements ProductInterface{
	// Attributes of product
	private int code;
	private String name;
	private String description;
	private double rPrice;
	private double sPrice;
	private int qty;

	Product(int code, String newName, String newDescription, double rPrice, double sPrice, int qty) throws RemoteException{
		this.code = code;
		this.name = newName;
		this.description = newDescription;
		this.rPrice = rPrice;
		this.sPrice = sPrice;
		this.qty = qty;
	}

	public void viewProducts() throws RemoteException{
		System.out.println("Code: "+ this.code);
		System.out.println("Name: "+ this.name);
		System.out.println("Description: "+ this.description);
		System.out.println("Retail price: "+ this.rPrice);
		System.out.println("Store price: "+ this.sPrice);
		System.out.println("Quantity: "+ this.qty);
		System.out.println("");
	}



	public String getName() throws RemoteException{
		return this.name;
	}
	public int getCode() throws RemoteException{
		return this.code;
	}
	/*
	public String getName() throws RemoteException{
		return this.name;
	}
	public String getDescription() throws RemoteException{
		return this.description;
	}
	public double getPrice() throws RemoteException{
		return this.price;
	}
	public String getFrom() throws RemoteException{
		return this.from;
	}
	public void changeProductName(String newName) throws RemoteException{
		this.name = newName;
	}*/
}