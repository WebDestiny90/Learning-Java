import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // System.out.println("Meyvenin adini daxil edin: ");
    // String userAnswer = scanner.next().toLowerCase();
    // String[] fruits = { "apple", "mango", "banana", "apple", "kiwi", "apple" };
    // int count = 0;
    // for (int i = 0; i < fruits.length; i++) {
    // if (fruits[i].toLowerCase().equals(userAnswer)) {
    // count++;
    // }
    // }
    // System.out.println(userAnswer + " sozu " + count + " defe istifade olunub.");
    // scanner.close();

    // String[] names = { "Taleh", "Nergiz", "Vusal", "Resul", "Togrul", "Ramazan",
    // "Aytac" };
    // String longestName = names[0];
    // for (int i = 1; i < names.length; i++) {
    // if (names[i].length() > longestName.length()) {
    // longestName = names[i];
    // ;
    // }
    // }
    // System.out.println("En uzun ad: " + longestName);

    String[] students = { "Taleh", "Nergiz", "Vusal", "Resul", "Togrul", "Ramazan", "Aytac" };

    int numLength = 0;

    String longestName = "";

    for (int i = 0; i < students.length; i++) {
      if (numLength < students[i].length()) {
        numLength = students[i].length();
        longestName = students[i];
      }
    }
    System.out.println(longestName);
  }
}
