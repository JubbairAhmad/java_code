import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Customer {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String address;
    private String contactNumber;
    private List<Booking> bookings;

    public Customer(int userId, String userName, String email, String password, String address, String contactNumber) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNumber = contactNumber;
        this.bookings = new ArrayList<>();
    }

    // Getters and setters for all fields
    public int getUserId(){
        return userId;
    }
    public String getUserName(){
        return userName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getAddress(){
        return address;
    }
    public String getContactnumber(){
        return contactNumber;
    }
}

class Booking {
    private String dateSlot;
    private String address;
    private String vendor;
    private double amount;

    public Booking(String dateSlot, String address, String vendor, double amount) {
        this.dateSlot = dateSlot;
        this.address = address;
        this.vendor = vendor;
        this.amount = amount;
        
    }
    public String getDateslot(){
        return dateSlot;
    }
    public String getAddress(){
        return address;
    }
    public String getVendor(){
        return vendor;
    }
    public double getAmount(){
        return amount;
    }

    // Getters and setters for all fields
}

public class CustomerManagementSystem {
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void registerCustomer() {
        Random random = new Random();
        int userId = random.nextInt(9000000) + 1000000;

        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        Customer customer = new Customer(userId, userName, email, password, address, contactNumber);
        customers.add(customer);
        System.out.println(userId);
        System.out.println("Customer Registration is successful.");
    }

    private static void loginCustomer() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getUserId() == userId && customer.getPassword().equals(password)) {
                found = true;
                displayMenu(customer);
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid User ID or Password.");
        }
    }

    private static void displayMenu(Customer customer) {
        while (true) {
            System.out.println("1. Services List");
            System.out.println("2. Booking History");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Display services list
                    Serviceslist();
                    break;
                case 2:
                    // Display booking history
                    Bookinghistory();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    // private static void bookService(Customer customer) {
    //     // Implement booking logic here
    // }
    private static void Serviceslist(){
        System.out.println("AC repair");
        System.out.println("TV repair");
        System.out.println("Fridge repair");
        System.out.println("Washing Machine repair");
        int ch = scanner.nextInt();
            scanner.nextLine();
        switch(ch){
            case 1:
                registerAC();
                break;
            case 2:
                registerTV();
                break;
            case 3:
                registerFridge();
                break;
            case 4:
                registerWashingmachine();
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
                break;
        }    
    }

    private static void registerAC(){
         System.out.print("enter Date: ");
         String dateSlot = scanner.nextLine();

         System.out.print("enter address: ");
         String address = scanner.nextLine();

         System.out.print("Enter vendor: ");
         String vendor = scanner.nextLine();

         System.out.print("Enter amount: ");
         Double amount = scanner.nextDouble();

         Booking booking = new Booking(dateSlot, address, vendor, amount);
         System.out.println("AC Registration is successful.");
         //bookings.add(booking);
    }

    private static void registerTV(){
        System.out.print("enter Date: ");
        String dateSlot = scanner.nextLine();

        System.out.print("enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        Double amount = scanner.nextDouble();

        Booking booking = new Booking(dateSlot, address, vendor, amount);
        System.out.println("TV Registration is successful.");
        //bookings.add(booking);
    }

    private static void registerFridge(){
        System.out.print("enter Date: ");
        String dateSlot = scanner.nextLine();

        System.out.print("enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        Double amount = scanner.nextDouble();

        Booking booking = new Booking(dateSlot, address, vendor, amount);
        System.out.println("FRIDGE Registration is successful.");
        //bookings.add(booking);
    }

    private static void registerWashingmachine(){
        System.out.print("enter Date: ");
        String dateSlot = scanner.nextLine();

        System.out.print("enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        Double amount = scanner.nextDouble();

        Booking booking = new Booking(dateSlot, address, vendor, amount);
        System.out.println("WASHING MACHINE Registration is successful.");
        //bookings.add(booking);
    }

    private static void Bookinghistory(){
        System.out.println("Previous Service Bookings :");
        System.out.println("        10/12/2024 ; 12:34pm");
        System.out.println("        st.Maple street,5th venue");
        System.out.println("        vendor");
        System.out.println("        2500/- rs");
    }
}

