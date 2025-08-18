import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface CustomMath<T, I> {
  //  void calc(int a, int b);

  List<String> personInfo = new ArrayList<>();

  String person(T name, T surName, I age);

}
