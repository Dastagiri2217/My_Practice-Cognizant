package maindp;

public class Customer {
    private String id;
    private String name;


    public Customer(String id, String name) {
    	this.id = id;
        this.name = name;
	}

	// Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
