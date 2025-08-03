import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // myApp obj1 = new myApp();

    // obj1.myFirstClass();

    // myApp calc = new myApp();

    // calc.myCalc(5, 3, "-");
    // calc.myCalc(5, 3, "+");
    // calc.myCalc(5, 3, "*");
    // calc.myCalc(5, 3, "/");
    // calc.myCalc(5, 3, "=");

    // Caller obj2 = new Caller();

    // obj2.resul();
    // obj2.taleh();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Eded daxil edin");

    int userAnswer = scanner.nextInt();
    EvenOdd obj3 = new EvenOdd();

    obj3.evenOddNumbers(userAnswer);
    scanner.close();
  }
}
