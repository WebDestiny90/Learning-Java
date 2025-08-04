import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();

    names.add("Taleh");
    names.add("Vusal");
    names.add("Togrul");
    System.out.println(names.contains("Taleh") ? "True" : "False");
  }
}