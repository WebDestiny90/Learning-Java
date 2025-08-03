package myInterfaces;

public class Customers {
  private String userName;
  private double amount;

  public Customers(String userName, double amount) {
    this.userName = userName;
    this.amount = amount;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
