public class Main {
  public static void main(String[] args) {
    CustomMath c = (int a, int b) -> {
      int z = a + b;
      int r = z / b;
      System.out.println("Sum: " + r);
    };
    c.calc(5, 5);
  }
}