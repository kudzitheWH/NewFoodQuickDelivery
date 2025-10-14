// Main.java
// Runs the NewFoodQuickDelivery application
// Collects input, assigns driver, and generates invoice safely.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    // Use try-with-resources to ensure Scanner is closed properly
    try (java.util.Scanner sc = new java.util.Scanner(System.in)) {

      // 1️⃣ Capture Customer Information
      System.out.println("Enter customer name: ");
      String customerName = sc.nextLine();

      while (customerName.isEmpty()) {
        System.out.print("Name cannot be empty. Please re-enter: ");// Input validation for empty name
        customerName = sc.nextLine();
      }

      System.out.println("Enter customer phone number: ");
      String customerPhoneNumber = sc.nextLine();

      System.out.println("Enter customer email: ");
      String customerEmail = sc.nextLine();

      System.out.println("Enter customer address: ");
      String customerAddress = sc.nextLine();

      System.out.println("Enter customer city: ");
      String customerCity = sc.nextLine();

      System.out.println("Enter order details (e.g., 1 x Pepperoni (R90.00)):");
      String orderDetails = sc.nextLine();

      // Declare first so we can use outside the try block later
      Customer customer = null;
      double totalAmount = 0.0;

      System.out.println("Enter total amount (you can include R if you want): ");
      String totalAmountInput = sc.nextLine();

      try {
        totalAmountInput = totalAmountInput.replaceAll("[^0-9.]", "");
        totalAmount = Double.parseDouble(totalAmountInput);

        System.out.println("Enter any special instructions (or type 'None'): ");
        String specialInstructions = sc.nextLine();

        customer = new Customer(customerName, customerAddress, customerPhoneNumber, customerEmail, customerCity,
            orderDetails, totalAmount, specialInstructions);

      } catch (NumberFormatException e) {
        System.out.println("⚠️ Invalid amount entered. Please restart and enter numbers only (e.g., 90.00).");
        return; // stop execution safely
      }

      // 2️⃣ Capture Restaurant Information
      System.out.println("\nEnter restaurant name: ");
      String restaurantName = sc.nextLine();

      System.out.println("Enter restaurant phone number: ");
      String restaurantPhoneNumber = sc.nextLine();

      System.out.println("Enter restaurant city: ");
      String restaurantCity = sc.nextLine();

      Restaurant restaurant = new Restaurant(restaurantName, restaurantCity, restaurantPhoneNumber);

      // 3️⃣ Read drivers.txt and assign driver safely
      Driver assignedDriver = null;
      int minimumDriverLoad = Integer.MAX_VALUE;

      try (BufferedReader br = new BufferedReader(new FileReader("drivers.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] parts = line.split(",");
          if (parts.length != 3) {
            System.out.println("⚠️ Skipping malformed driver line: " + line);
            continue;
          }

          String driverName = parts[0].trim();
          String driverCity = parts[1].trim();
          int driverLoad;

          try {
            driverLoad = Integer.parseInt(parts[2].trim());
          } catch (NumberFormatException e) {
            System.out.println("⚠️ Invalid load number for " + driverName + ". Skipping line.");
            continue;
          }

          if (driverCity.equalsIgnoreCase(restaurantCity) && driverLoad < minimumDriverLoad) {
            assignedDriver = new Driver(driverName, driverCity, driverLoad);
            minimumDriverLoad = driverLoad;
          }
        }

      } catch (IOException e) {
        System.out
            .println("⚠️ Error: Could not read drivers.txt. Please ensure the file exists in your project folder.");
      }

      // 4️⃣ Create Order and Generate Invoice
      int orderNumber = (int) (Math.random() * 9000) + 1000; // random 4-digit order number
      Order order = new Order(customer, restaurant, assignedDriver, orderNumber);
      order.generateInvoice();

    } // Scanner auto-closed here

    System.out.println("\n✅ Program finished successfully.");
  }
}
