import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Söz daxil edin: ");
    String userWord = scanner.next();
    System.out.println("Rəqəm daxil edin: ");
    int userNumber = scanner.nextInt();

    if (userNumber >= 0 && userNumber < userWord.length()) {
      char letter = userWord.charAt(userNumber);
      System.out.println(
          "daxil etdiyiniz reqem: " + userNumber + "! " + userWord + " sozunun " + letter
              + "-herfine beraberdir");
    } else {
      System.err.println(" daxil etdiyiniz yanlishdir");
    }

    scanner.close();
  }
}
