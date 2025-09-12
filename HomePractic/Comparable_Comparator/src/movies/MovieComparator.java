package movies;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movies> {
  @Override
  public int compare(Movies o1, Movies o2) {
    int result = Integer.compare(o1.getYear(), o2.getYear());

    if (result == 0) {
      result = Double.compare(o1.getRaiting(), o2.getRaiting());
    }

    if (result == 0){
      result = o1.getTitle().compareTo(o2.getTitle());
    }
    return result;
  }
}
