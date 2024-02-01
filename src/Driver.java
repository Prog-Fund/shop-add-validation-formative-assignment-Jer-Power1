import java.util.Scanner;


public class Driver{

    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        processOrder();
        runMenu();
    }

    private int mainMenu(){
        System.out.print("""
               Shop Menu
               ---------
                  1) List the Products
                  2) List the current products
                  3) Display average product unit cost
                  4) Display cheapest product
                  0) Exit
               ==>> """);
        int option = input.nextInt();
        return option;
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> printProducts();
                case 2 -> printCurrentProducts();
                case 3 -> printAverageProductPrice();
                case 4 -> printCheapestProduct();
                default -> System.out.println("Invalid option entered: " + option);
            }


            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }


        System.out.println("Exiting...bye");
        System.exit(0);
    }


    private void processOrder(){
        System.out.print("How many Products would you like to have in your Store?  ");
        int numberProducts = input.nextInt();

        store = new Store(numberProducts);

        for (int i = 0; i < numberProducts; i++){
            addProduct();
        }
    }


    private void addProduct(){
        input.nextLine();

        System.out.print("Enter the Product Name:  ");
        String productName = input.nextLine();
        System.out.print("Enter the Product Code:  ");
        int productCode = input.nextInt();
        System.out.print("Enter the Unit Cost:  ");
        double unitCost = input.nextDouble();


        System.out.print("Is this product in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentProductLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y'))
            inCurrentProductLine = true;

        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded){
            System.out.println("Product Added Successfully");
        }
        else{
            System.out.println("No Product Added");
        }
    }
    

    private void printProducts(){
        System.out.println("List of Products are:");
        System.out.println(store.listProducts());
    }


    private void printCurrentProducts(){
        System.out.println("List of CURRENT Products are:");
        System.out.println(store.listCurrentProducts());
    }


    private void printAverageProductPrice(){
        double averagePrice = store.averageProductPrice();
        if (averagePrice != -1){
            System.out.println("The average product price is: " + averagePrice);
        }
        else{
            System.out.println("There are no products in the store.");
        }
    }


    private void printCheapestProduct(){
        Product cheapestProduct = store.cheapestProduct();
        if (cheapestProduct != null) {
            System.out.println("The cheapest product is:  " + cheapestProduct.getProductName());
        }
        else{
            System.out.println("There are no products in the store.");
        }
    }




}