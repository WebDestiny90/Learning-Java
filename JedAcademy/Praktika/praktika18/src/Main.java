import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // List<String> names = Arrays.asList("Red", "Blue", "Green", "White",
    // "Yellow");
    // List<String> secondNames = names.stream().filter(colors -> colors.length() >
    // 4).toList();

    // System.out.println(secondNames);

    // List<Integer> intBox = Arrays.asList(5, 4, 8, 9, 6, 20, 4, 8, 7, 2, 69, 75,
    // 85, 7, 8);

    // List<Integer> boxSecond = intBox.stream().filter(n -> n > 20).map(n -> n +
    // 20).toList();

    // boxSecond.forEach(System.out::println);

    List<String> lists = Arrays.asList("Taleh", "mesme", "Vusal", "Toghrul", "Nergiz", "Akshin", "Asif", "Aytac",
        "Taleh",
        "Vusal", "Toghrul", "Nergiz", "Akshin", "Asif", "Aytac");

    List<String> listSecond = lists.stream().filter(n -> n.length() > 5).distinct().sorted().skip(1)
        .map(n -> n.toUpperCase())
        .toList();

    listSecond.forEach(System.out::println);

  }
}
