import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Server{
	public static void main(String[] args){
		try{
			Enrollment serve = new Enrollment();

			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			// You don't have to run in console > start rmiregistry 9100
			Registry startRMI = LocateRegistry.createRegistry(9100);
			System.out.println("Server has been started...");

<<<<<<< HEAD
			Product Laptop = new Product(100, "Laptop", "Acer Aspire", 38000.36, 38200.2, 50);
			Product MobilePhone = new Product(101,"Phone","Samsung", 1986.3, 2045.72, 15);
			Product Charger = new Product(102,"Charger","Type-C Charger",798.5, 841.55, 50);
			Product powerBank = new Product(103,"PowerBank","Vivo", 895, 944.12, 45);
			Cart myCart = new Cart(100);
			

			ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
			ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
			ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
			ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(powerBank, 0);
			CartInterface stub_myCart = (CartInterface) UnicastRemoteObject.exportObject(myCart, 0);
			

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			registry.rebind("laptop", stub_laptop);
			registry.rebind("Phone", stub_mobilePhone);
			registry.rebind("charger", stub_charger);
			registry.rebind("powerBank", stub_powerBank);
			registry.rebind("myCart", stub_myCart);
			


			Laptop.viewProducts();
			MobilePhone.viewProducts();
			Charger.viewProducts();
			powerBank.viewProducts();
			
			System.out.println("Exporting and binding of Objects has been completed...");
=======
			serve.initializeStudents();
			System.out.println("Students has been initialized...");

			serve.initializeCourses();
			System.out.println("Courses has been initialized...");

			EnrollmentInterface enrollment = (EnrollmentInterface) UnicastRemoteObject.exportObject(serve, 0);

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			registry.rebind("access_enrollment", enrollment);
			System.out.println("Exporting and binding of Objects has been completed...\nServer is now successfully running...");
>>>>>>> b5a120065f9114ab491865fbc2673af577729dcc
		}catch(Exception e){
			System.out.println("Error while exporting and binding objects..." + e);
		}
	}
}


// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run