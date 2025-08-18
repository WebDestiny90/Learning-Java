public class Person {
  private String name;
  private Integer amount;

  public Person(String name, Integer amount) {
    this.name = name;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", amount=" + amount + '}';
  }
}
