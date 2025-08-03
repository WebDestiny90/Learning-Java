import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Birinci ededi daxil edin: ");
    int userFirstNumber = scanner.nextInt();

    System.out.println("Operatoru Daxil edin: ");
    String userOperatorChoice = scanner.next();

    System.out.println("ikinci reqemi daxil edin: ");
    int userSecondNumber = scanner.nextInt();

    var myCalc = new Calculator();

    myCalc.calc(userFirstNumber, userOperatorChoice, userSecondNumber);
  }
}