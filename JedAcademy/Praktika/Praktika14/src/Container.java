import java.util.ArrayList;
import java.util.List;

public class Container<T> {
  private List<T> list = new ArrayList<>();

  public Container(List<T> list) {
    this.list = list;
  }

  public void addItem(T item) {
    list.add(item);
  }

  public T getList(int index) {
    return list.get(index);
  }

  @Override
  public String toString() {
    return "Container{" + "list=" + list + '}';
  }
}
