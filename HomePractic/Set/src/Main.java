import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    LinkedHashSet<String> names = new LinkedHashSet<>();

    while (true) {
      System.out.print("Adı daxil edin (çıxmaq üçün 'exit' yazın): ");
      String userAnswer = scanner.next().toLowerCase();

      if (userAnswer.equals("exit")) {
        break;
      } else if (userAnswer.trim().isEmpty()) {
        System.out.println("Boş ad daxil edilə bilməz!");
      } else if (names.contains(userAnswer)) {
        System.out.println("Bu ad artıq mövcuddur!");
      } else {
        names.add(userAnswer);
        System.out.println("Ad əlavə olundu: " + userAnswer);
      }

    }

    System.out.println("\nDaxil edilmiş adlar:");
    for (String name : names) {
      System.out.println(name);
    }
  }
}

