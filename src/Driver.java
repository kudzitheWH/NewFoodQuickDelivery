/**
 * 
 */

/**
 * 
 */
public class Driver {
  // Attributes
  private String name;
  private String city;
  private int load;

  // Constructor
  public Driver(String name, String city, int load) {
    this.name = name;
    this.city = city;
    this.load = load;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public int getLoad() {
    return load;
  }

  // method to update load
  public void incrementLoad(int load) {
    load++;
  }

  // toString method
  public String toString() {
    String output = "Name: " + name;
    output += "\nCity: " + city;
    output += "\nLoad: " + load;
    return output;
  }

}
