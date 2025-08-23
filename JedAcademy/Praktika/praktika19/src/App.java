import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
  // static void check(int age) throws MyException {
  // if (age < 18) {
  // throw new MyException("Yaş 18-dən kiçik ola bilməz!");
  // }
  // }
  //
  public static void main(String[] args) {
    //
    // try {
    // check(15);
    // } catch (MyException e) {
    // System.out.println(e.getMessage());
    // }

    // try {
    // int a = 10;
    // int b = 0;
    // int result = a / b;
    // } catch (ArithmeticException e) {
    // System.out.println("Sıfıra bölmək olmaz!");
    // }

    Scanner sc = new Scanner(System.in);
    int age = 0;

    while (age != 18) {
      try {
        System.out.print("Yaşınızı daxil edin: ");
        age = sc.nextInt();

        if (age != 18) {
          System.out.println("Düzgün yaş deyil, yenidən cəhd edin.");
        }

      } catch (InputMismatchException e) {
        System.out.println("Xəta: Rəqəm daxil edin!");
        sc.nextLine();
      }
    }
    System.out.println("Düzgün yaş daxil etdiniz: " + age);
  }
}
