import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Farmer class to represent a farmer's profile and products
class Farmer {
    String name;
    String farmName;
    List<Product> products;

    public Farmer(String name, String farmName) {
        this.name = name;
        this.farmName = farmName;
        this.products = new ArrayList<>();
    }

    // Add a product to the farmer's listing
    public void addProduct(Product product) {
        products.add(product);
    }

    // Display the farmer's products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}

// Consumer class for representing consumers' profiles
class Consumer {
    String name;
    double balance;

    public Consumer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Purchase a product
    public boolean purchase(Product product) {
        if (balance >= product.price) {
            balance -= product.price;
            System.out.println(name + " successfully purchased " + product.name + " for " + product.price);
            return true;
        } else {
            System.out.println("Insufficient balance to purchase " + product.name);
            return false;
        }
    }
}

// Product class for representing products listed by farmers
class Product {
    String name;
    double price;
    String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Description: " + description;
    }
}

// Marketplace class to handle product listings and purchase transactions
class Marketplace {
    List<Farmer> farmers;
    List<Consumer> consumers;

    public Marketplace() {
        this.farmers = new ArrayList<>();
        this.consumers = new ArrayList<>();
    }

    // Add farmer to the marketplace
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    // Add consumer to the marketplace
    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
    }

    // Display all available products from all farmers
    public void displayAllProducts() {
        System.out.println("Available Products:");
        for (Farmer farmer : farmers) {
            farmer.displayProducts();
        }
    }

    // Let a consumer purchase a product from a farmer
    public boolean processPurchase(Consumer consumer, Product product) {
        return consumer.purchase(product);
    }
}

public class LocalFarmersMarketplace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Marketplace marketplace = new Marketplace();

        // Sample farmers and products
        Farmer farmer1 = new Farmer("Alice", "Sunny Meadows Farm");
        farmer1.addProduct(new Product("Tomatoes", 3.50, "Fresh organic tomatoes"));
        farmer1.addProduct(new Product("Carrots", 2.00, "Sweet, fresh carrots"));

        Farmer farmer2 = new Farmer("Bob", "Green Valley Farm");
        farmer2.addProduct(new Product("Lettuce", 1.50, "Crisp, fresh lettuce"));
        farmer2.addProduct(new Product("Eggplants", 4.00, "Purple, ripe eggplants"));

        marketplace.addFarmer(farmer1);
        marketplace.addFarmer(farmer2);

        // Sample consumers
        Consumer consumer1 = new Consumer("John", 10.00);
        marketplace.addConsumer(consumer1);

        // Main menu
        while (true) {
            System.out.println("\n--- Welcome to Local Farmers Marketplace ---");
            System.out.println("1. Display all products");
            System.out.println("2. Purchase product");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    marketplace.displayAllProducts();
                    break;
                case 2:
                    // Let the consumer select a product to buy
                    System.out.print("Enter product name to purchase: ");
                    String productName = scanner.nextLine();
                    boolean productFound = false;
                    for (Farmer farmer : marketplace.farmers) {
                        for (Product product : farmer.products) {
                            if (product.name.equalsIgnoreCase(productName)) {
                                productFound = true;
                                marketplace.processPurchase(consumer1, product);
                                break;
                            }
                        }
                        if (productFound) break;
                    }
                    if (!productFound) {
                        System.out.println("Product not found!");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for visiting the marketplace!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
