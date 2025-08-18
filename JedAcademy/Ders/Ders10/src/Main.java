import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //    CustomMath c = (int a, int b) -> {
    //      int z = a + b;
    //      int r = z / b;
    //      System.out.println("Sum: " + r);
    //    };
    //    c.calc(5, 5);
    CustomMath<String, Integer> p = (name, surName, age) -> "Name: " + name + " " + "Surname: " + " " + surName + " " + "Age: " + " " + age;

    CustomMath.personInfo.add(p.person("Taleh", "Aghayev", 30));
    //            personInfo.add(p.person("Taleh", "Aghayev", 30));

    System.out.println(CustomMath.personInfo);
  }
}