// Order.java
// Represents a full customer order and handles invoice creation

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Order {

  // Attributes
  private Customer customer;
  private Restaurant restaurant;
  private Driver driver;
  private int orderNumber;

  // Constructor
  public Order(Customer customer, Restaurant restaurant, Driver driver, int orderNumber) {
    this.customer = customer;
    this.restaurant = restaurant;
    this.driver = driver;
    this.orderNumber = orderNumber;
  }

  // Method to generate invoice file
  public void generateInvoice() {
    try (PrintWriter out = new PrintWriter(new FileWriter("invoice.txt"))) {

      if (customer == null || restaurant == null) {
        System.out.println("⚠️ Missing order details. Invoice not created.");
        return;
      }

      out.println("----- QUICK FOOD INVOICE -----");
      out.println("Order Number: " + orderNumber);
      out.println();
      out.println(customer.toString());
      out.println(restaurant.toString());
      out.println("Order Details: " + customer.getOrderDetails());
      out.println("Total Amount: R" + customer.getTotalAmount());
      out.println("Special Instructions: " + customer.getSpecialInstructions());
      out.println();

      if (driver != null) {
        out.println(driver.getName() + " is nearest to the restaurant and will deliver your order to:");
        out.println(customer.getAddress());
        out.println();
        out.println("If you need to contact the restaurant, call: " + restaurant.getPhoneNumber());
      } else {
        out.println("Sorry! No available driver in your area at the moment.");
      }

      System.out.println("Generating your invoice... Please wait.");

      System.out.println("\n✅ Invoice generated successfully: invoice.txt");

    } catch (IOException e) {
      System.out.println("⚠️ Error: Unable to create or write to invoice.txt. Details: " + e.getMessage());
    } finally {
      System.out.println("🧾 Invoice generation process complete.");
    }
  }
}
