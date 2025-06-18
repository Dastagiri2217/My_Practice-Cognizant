
import java.util.Arrays;
import java.util.Comparator;

class Product {
	private int productId;
	private String productName;
	private String productCategory;
	public Product(int productId, String productName, String productCategory) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	
}

class Search {
	public static Product linearSearch(Product s[],int targetId) {
		for(Product p : s) {
			if(p.getProductId()== targetId) {
				return p;
			}
		}
		return null;
	}
	public static Product binarySearch(Product s[],int targetId) {
		int low = 0,high = s.length - 1;
		while(low<=high) {
			int mid = (low+high)/2;
			int id = s[mid].getProductId();
			if(id == targetId) {
				return s[mid];
			}
			else if(id < targetId) {
				low = mid + 1;
			}
			else {
				high = mid -1;
			}
		}
		return null;
	}
}
public class SearchFunction{
	public static void main(String args[]) {
		Product Store [] = {new Product(12,"Phone","Electronics"),
				            new Product(11,"Watch","Electronics"),
				            new Product(9,"Shirt","Clothing"),
				            new Product(13,"Shoes","Footwear")};
		int targetId = 9;
		Product found = Search.linearSearch(Store, targetId);
		if(found != null) {
			System.out.printf("Found Product  "+found.getProductName()+",product Id : "+found.getProductId());
		}
		System.out.println();
		Arrays.sort(Store,Comparator.comparingInt(Product::getProductId));
		Product foundb = Search.binarySearch(Store,11);
		if(foundb != null) {
			System.out.printf("Found Product  "+foundb.getProductName()+",product Id : "+foundb.getProductId());
		}
	}
}
