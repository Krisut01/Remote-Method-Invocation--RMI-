import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	// Lets us define API
	public String getName() throws RemoteException;
	public int getCode() throws RemoteException;
	public void viewProducts() throws RemoteException;
	// public void addProdInCart(int code, String name) throws RemoteException;
	// public void viewProdInCart() throws RemoteException;
	//public String getName() throws RemoteException;
	//public String getDescription() throws RemoteException;
	//public double getPrice() throws RemoteException;
	//public String getFrom() throws RemoteException;
	//public void changeProductName(String newName) throws RemoteException;
}