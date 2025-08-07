import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, String> myMap;
    List<Map<Integer, String>> myList = new ArrayList<>();

    while (true) {
      System.out.println("Mehsulun ID daxil edin! \"cixish ucun stop\" yazin ");
      String userAnswerNumber = scanner.next().trim().toLowerCase();

      System.out.println("Mehsulun adini daxil edin! ");
      String userAnswerName = scanner.next().trim().toLowerCase();

      if (userAnswerNumber.equals("stop") && userAnswerName.equals("stop")) {
        break;
      }

      if (!userAnswerNumber.isEmpty() && userAnswerNumber.matches("\\d+")) {
        int id = Integer.parseInt(userAnswerNumber);
        myMap = new HashMap<>();
        myMap.put(id, userAnswerName);
        myList.add(myMap);
      } else {
        System.out.println("ID reqem olmalidir! Zəhmət olmasa düzgün daxil edin.");
      }
    }

    System.out.println("Daxil edilən məhsullar:");
    for (Map<Integer, String> map : myList) {
      for (Map.Entry<Integer, String> entry : map.entrySet()) {
        System.out.println("ID: " + entry.getKey() + " | Ad: " + entry.getValue());
      }
    }
  }
}
