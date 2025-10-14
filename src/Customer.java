// Customer.java
// Represents a customer placing an order in the Quick Food app

public class Customer {

  // Attributes
  private String name;
  private String address;
  private String phoneNumber;
  private String email;
  private String city;
  private String orderDetails;
  private double totalAmount;
  private String specialInstructions;

  // Constructor
  public Customer(String name, String address, String phoneNumber, String email, String city, String orderDetails,
      double totalAmount, String specialInstructions) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.city = city;
    this.orderDetails = orderDetails;
    this.totalAmount = totalAmount;
    this.specialInstructions = specialInstructions;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getCity() {
    return city;
  }

  public String getOrderDetails() {
    return orderDetails;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }

  // toString method
  @Override
  public String toString() {
    return "----- Customer Details -----\n" + "Name: " + name + "\n" + "Address: " + address + "\n" + "City: " + city
        + "\n" + "Phone Number: " + phoneNumber + "\n" + "Email: " + email + "\n" + "Order Details: " + orderDetails
        + "\n" + "Total Amount: R" + totalAmount + "\n" + "Special Instructions: " + specialInstructions + "\n";
  }
}
