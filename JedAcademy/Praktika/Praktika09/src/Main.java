import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    String[] category = {"Horror", "Comedy"};
    var films = new MyFilmImpl("Ace Ventura", category, LocalDate.now());
    System.out.println(films);

  }
}