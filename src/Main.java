// By Omar Badwy
// Build a Simple E-Commerce System.

// =======================
// Encapsulation
// =======================
class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;

    // Constructor
    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
        setStock(stock);
    }

    // Getters and Setters with validation
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative!");
        }
        this.stock = stock;
    }
}

// =======================
// Inheritance + Polymorphism
// =======================
class User {
    protected int userId;
    protected String username;
    protected String email;

    public User(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Polymorphism (Overriding)
    public String getUserDetails() {
        return "User ID: " + userId + ", Username: " + username + ", Email: " + email;
    }
}

class Customer extends User {
    public Customer(int userId, String username, String email) {
        super(userId, username, email);
    }

    // Overloading placeOrder
    public void placeOrder(int productId) {
        System.out.println("Customer " + username + " placed an order for product: " + productId);
    }

    public void placeOrder(int productId, int quantity) {
        System.out.println("Customer " + username + " placed an order for product: " + productId + " with quantity: " + quantity);
    }

    @Override
    public String getUserDetails() {
        return "Customer ID: " + userId + ", Name: " + username + ", Email: " + email;
    }
}

class Admin extends User {
    public Admin(int userId, String username, String email) {
        super(userId, username, email);
    }

    public void updateProduct(Product product, double newPrice, int newStock) {
        product.setPrice(newPrice);
        product.setStock(newStock);
        System.out.println("Admin " + username + " updated product " + product.getName());
    }

    @Override
    public String getUserDetails() {
        return "Admin ID: " + userId + ", Name: " + username + ", Email: " + email;
    }
}

// =======================
// Abstraction
// =======================
interface Payment {
    boolean validateCard(String cardNumber);
    void processPayment(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public boolean validateCard(String cardNumber) {
        return cardNumber.length() == 16;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements Payment {
    @Override
    public boolean validateCard(String email) {
        return email.contains("@");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// =======================
// Main Class to Demonstrate
// =======================
public class Main {
    public static void main(String[] args) {
        // Create Products
        Product p1 = new Product(101, "Laptop", 1200.0, 10);
        Product p2 = new Product(102, "Phone", 800.0, 5);

        // Create Users
        Customer c1 = new Customer(1, "Omar", "omar@example.com");
        Admin a1 = new Admin(2, "AdminUser", "admin@example.com");

        // Demonstrate Polymorphism
        System.out.println(c1.getUserDetails());
        System.out.println(a1.getUserDetails());

        // Customer placing orders
        c1.placeOrder(p1.getProductId());
        c1.placeOrder(p2.getProductId(), 2);

        // Admin updating product
        a1.updateProduct(p2, 750.0, 8);

        // Payments
        Payment credit = new CreditCardPayment();
        if (credit.validateCard("1234567890123456")) {
            credit.processPayment(500);
        }

        Payment paypal = new PayPalPayment();
        if (paypal.validateCard("omar@example.com")) {
            paypal.processPayment(300);
        }
    }
}
