// Restaurant.java
// Represents a restaurant registered with Quick Food

public class Restaurant {

  // Attributes
  private String name;
  private String city;
  private String phoneNumber;

  // Constructor
  public Restaurant(String name, String city, String phoneNumber) {
    this.name = name;
    this.city = city;
    this.phoneNumber = phoneNumber;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  // toString method
  @Override
  public String toString() {
    return "----- Restaurant Details -----\n" + "Name: " + name + "\n" + "City: " + city + "\n" + "Phone Number: "
        + phoneNumber + "\n";
  }
}
