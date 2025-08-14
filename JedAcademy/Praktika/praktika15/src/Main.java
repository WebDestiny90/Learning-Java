import java.util.Set;

public class Main {
  public static void main(String[] args) {
    String a = new String("5");
    String b = new String("5");
    Human h1 = new Human("Taleh", "Aghayev");
    Human h2 = new Human("Taleh", "Aghayev");

    Set<Human> humans = Set.of(h1, h2);
    System.out.println(humans);

  }
} 