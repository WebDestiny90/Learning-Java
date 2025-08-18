public class Main {
  public static void main(String[] args) {
    Human<Integer> personInfo = (a, b) -> {
      int max = (a > b) ? a : b;
      System.out.println(max);
    };
    personInfo.person(5, 6);
  }
}
