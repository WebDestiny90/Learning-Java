public class Calculator {
  public void calc(int firstNumber, String operator, int secondNumber){
    if (operator.equals("-")){
      System.out.println("Cavab: "+(firstNumber-secondNumber));
    }else if (operator.equals("+")){
      System.out.println(firstNumber+secondNumber);
    }else if (operator.equals("*")){
      System.out.println(firstNumber*secondNumber);
    }else if (operator.equals("/") && secondNumber !=0) {
      System.out.println(firstNumber/secondNumber);
    } else if (operator.equals("/") && secondNumber ==0) {
      System.out.println("Sifira bolmek olmaz");
    }else {
      System.out.println("daxil edilen operator yanlishdir");
    }
  }
}
