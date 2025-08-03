public class Customer {
  private String id;
  private String name;
  private String surName;
  private int age;
  private double balance;

  public Customer(String id, String name, String surName, int age, double balance) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.balance = balance;
  }

  public Customer() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getSurName() {
    return surName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
