public class Main {
  public static void main(String[] args) {
    var bird = new Bird();
    var duck = new Duck();
    bird.makeSound();
    duck.makeSound();

    System.out.println(bird.flyable());
    System.out.println(bird.swimming());
    System.out.println(duck.flyable());
    System.out.println(duck.swimming());
  }
}