import java.util.List;

public class TourUser {
  private String name;
  private String userName;
  private Integer age;
  private Double balance;

  public TourUser(String name, String userName, Integer age, Double balance) {
    this.name = name;
    this.userName = userName;
    this.age = age;
    this.balance = balance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "TourUser{" + "name='" + name + '\'' + ", userName='" + userName + '\'' + ", age=" + age + ", balance=" + balance + '}';
  }

  public String userAddTour(List<HesderxanlaGez> tours) {
    String result = "";
    for (HesderxanlaGez t : tours) {
      if (balance >= t.getTourPrice()) {
        setBalance(getBalance() - t.getTourPrice());
        result = "(Tur alındı: " + (t.getTourName()) + " | Qalan balans: " + (getBalance()) + ("\n");
      } else {
        result = "Balans çatmır: " + t.getTourName() + " Qiymət: " + t.getTourPrice() + "\n";
      }
    }
    return result;
  }
}
