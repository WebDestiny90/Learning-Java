public class Duck implements Animal {
  @Override
  public void makeSound() {
    System.out.println("Kwa-Kwa");
  }

  @Override
  public boolean flyable() {
    return true;
  }

  @Override
  public boolean swimming() {
    return true;
  }
}
