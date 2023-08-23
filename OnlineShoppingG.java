import java.util.*;

class Order {
    User user;
    List<Composite> orderList = new ArrayList<>();
    double totalPrice;
    Date dateTime;

    Order(User user) {
        this.user = user;
        dateTime = new Date();
    }

    void addProductToOrder(Seller seller, Product product) {
        orderList.add(new Composite(seller, product));
        totalPrice += product.price;
    }

    void printOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("User: " + user.name);
        System.out.println("Seller-Product List:");
        for (Composite composite : orderList) {
            System.out.println("Seller: " + composite.seller.name + ", Product: " + composite.product.prod);
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Date and Time: " + dateTime);
    }
}

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

class Seller {
    String name;

    Seller(String name) {
        this.name = name;
    }
}

class Product {
    String prod;
    double price;

    Product(String prod, double price) {
        this.prod = prod;
        this.price = price;
    }
}

class Composite {
    Seller seller;
    Product product;

    Composite(Seller seller, Product product) {
        this.seller = seller;
        this.product = product;
    }
}


public class OnlineShoppingG
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Sellers
        Seller seller1 = new Seller("H&M");
        Seller seller2 = new Seller("Nike");
        Seller seller3 = new Seller("Adidas");
        Seller seller4 = new Seller("Puma");

        // Create Products
        Product product1 = new Product("A Line Skirt", 29.99);
        Product product2 = new Product("Air Jordan 3's", 149.99);
        Product product3 = new Product("Run Falcon 2.0 shoes", 79.99);
        Product product4 = new Product("Rider Sneakers", 64.99);
        Product product5 = new Product("OverSized T-Shirts", 19.99);
        Product product6 = new Product("Black Shorts", 24.99);

        // User Input
        String ch = "Please enter your choice: ";
        int sellch, prodch;

        System.out.println("Anisha Singh, E22CSEU1279");
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        User user = new User(userName);

        Order userOrder = new Order(user);

        while (true) {
            System.out.println("***************  This Menu is for sellers  ******************");
            System.out.println("1. " + seller1.name);
            System.out.println("2. " + seller2.name);
            System.out.println("3. " + seller3.name);
            System.out.println("4. " + seller4.name);
            System.out.println("5. Exit");
            System.out.print(ch);
            sellch = sc.nextInt();

            if (sellch == 5) {
                break;
            }

            System.out.println("***************  This Menu is for products  ******************");
            System.out.println("1. " + product1.prod);
            System.out.println("2. " + product2.prod);
            System.out.println("3. " + product3.prod);
            System.out.println("4. " + product4.prod);
            System.out.println("5. " + product5.prod);
            System.out.println("6. " + product6.prod);
            System.out.println("7. Exit");
            System.out.print(ch);
            prodch = sc.nextInt();

            if (prodch == 7) {
                break;
            }

            Seller selectedSeller = null;
            Product selectedProduct = null;

            if (sellch == 1) {
                selectedSeller = seller1;
            } else if (sellch == 2) {
                selectedSeller = seller2;
            } else if (sellch == 3) {
                selectedSeller = seller3;
            } else if (sellch == 4) {
                selectedSeller = seller4;
            }

            if (prodch == 1) {
                selectedProduct = product1;
            } else if (prodch == 2) {
                selectedProduct = product2;
            } else if (prodch == 3) {
                selectedProduct = product3;
            } else if (prodch == 4) {
                selectedProduct = product4;
            } else if (prodch == 5) {
                selectedProduct = product5;
            } else if (prodch == 6) {
                selectedProduct = product6;
            }

            if (selectedSeller != null && selectedProduct != null) {
                userOrder.addProductToOrder(selectedSeller, selectedProduct);
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }

        userOrder.printOrderDetails();
    }

}
