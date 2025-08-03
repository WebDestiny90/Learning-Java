public class myApp {
  // public void myFirstClass() {
  // System.out.println("My First Class");
  // }

  public void myCalc(int a, int b, String c) {
    if (c.equals("-")) {
      System.out.println(a - b);
    } else if (c.equals("+")) {
      System.out.println(a + b);
    } else if (c.equals("*")) {
      System.out.println(a * b);
    } else if (c.equals("/")) {
      System.out.println(a * b);
    } else {
      System.err.println("Error");
    }
  }

}
