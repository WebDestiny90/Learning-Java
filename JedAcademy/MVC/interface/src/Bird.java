public class Bird implements Animal {
  @Override
  public void makeSound() {
    System.out.println("cik-cik");
  }

  @Override
  public boolean flyable() {
    return true;
  }

  @Override
  public boolean swimming() {
    return false;
  }
}
