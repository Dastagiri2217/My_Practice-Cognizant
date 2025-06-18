import java.util.*;
class Product {
	private String productId;
	private String productName;
	private int quantity;
	private double price;
	public Product(String productId, String productName, int quantity, double price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
class Inventory{
	private Map<String,Product> store = new HashMap<String,Product>();
	public void addProduct(Product p) {
		if(store.containsKey(p.getProductId())) { //O(1) as this is an HashMap it requres Constant time to search 
			System.out.println("Store already contains that product");
		}
		else {
			System.out.println("Product Added "+p.getProductName());
			store.put(p.getProductId(), p);// to add product into store it takes O(1)
		}
		// so Total T.C of this function is O(1)
	}
	public void removeProduct(Product p) {
		if(!store.containsKey(p.getProductId())) {//O(1) 
			System.out.println("Error Check ProductId");
		}
		else {
			store.remove(p.getProductId());//O(1)
			System.out.println("Product Removed from Store : "+p.getProductName());
		}
		//O(1)
	}
	public void updateProduct(String productId,String productName,int quantity,double price) {
		Product p = store.get(productId);//same O(1) for search
		if(p!=null) {
		p.setPrice(price);
		p.setProductName(productName);
		p.setQuantity(quantity);//take O(1) for setting
		System.out.println("Prodcut Updated with Latest Details ");
		}
		else {
			System.out.println("Product Doesnt Exist in Store");
		}
	}
	public void displayProducts() {
		for(Product p : store.values()) {
			System.out.println(p);
		}
	}
}
public class InventoryManagement{
	
	public static void main(String args[]) {
		Inventory inv = new Inventory();
		Product p1 = new Product("A1","Phone",10,20000.00);
		inv.addProduct(p1);
		inv.displayProducts();
		Product p2 = new Product("A2","Laptop",5,60000.00);
		inv.addProduct(p2);
		inv.updateProduct("A1","Phone With Charger",1,22000.00);
		inv.displayProducts();
		inv.removeProduct(p1);
		inv.displayProducts();
		
	}
}

