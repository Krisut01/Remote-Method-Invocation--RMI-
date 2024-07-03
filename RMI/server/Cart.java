import java.rmi.RemoteException;

public class Cart implements CartInterface{
    public int[] addedProductsCode;
    public String[] addedProductsName;
    public int cap;
    public int ind;

    public Cart(int cap) throws RemoteException{
        this.cap = cap;
        this.ind = 0;
        this.addedProductsCode = new int[cap];
        this.addedProductsName = new String[cap];
    }

    public void addProdInCart(int code, String name) throws RemoteException{
        if(ind < 10) {
            addedProductsCode[ind] = code;
            addedProductsName[ind] = name;
            ind++;
        } else  {
            System.out.println("Cant add products it is full.");
        }
    }
    public String[][] viewProdInCart() throws RemoteException{
        String prods[][] = new String[2][ind];
        int i, j;
        // System.out.println("\nProducts in Cart: ");
        for(i=0;i<2;i++) {
            //System.out.println("Name: "+addedProductsName[i]+"  Code: "+ addedProductsCode[i]);
            for(j=0;j<ind;j++) {
                if(i == 0)
                    prods[i][j] = addedProductsName[j];
                if(i == 1)
                    prods[i][j] = Integer.toString(addedProductsCode[j]);
            }
        }
        return prods;
    } 
    
} 