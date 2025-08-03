public class Main {
  public static void main(String[] args) {
    var cat = new Cat();

    cat.makeSound();
    String eat = cat.eat();
    System.out.println(eat);
  }
}