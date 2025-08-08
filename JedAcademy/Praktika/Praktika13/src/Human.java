import java.util.HashMap;
import java.util.Map;

public class Human {
  private String name;
  private String lastaName;
  private Map<String, Double> course = new HashMap<>();

  public Human(String name, String lastaName) {
    this.name = name;
    this.lastaName = lastaName;
  }


  public double averageBl() {
    double average = 0;
    for (Double x : course.values()) {
      average += x;
    }
    return average / course.size();
  }

  public String getLastaName() {
    return lastaName;
  }

  public void setLastaName(String lastaName) {
    this.lastaName = lastaName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Double> getCourse() {
    return course;
  }

  public void setCourse(Map<String, Double> course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Human{" + "name='" + name + '\'' + ", lastaName='" + lastaName + '\'' + ", course=" + course + " " + averageBl() + "}";
  }

  public void removeCourse(String name) {
    //    course.putIfAbsent("Python", 100.0);
    course.getOrDefault(name, 100.0);
    //    if (course.containsKey("Python")) {
    //      course.remove(name);
    //    } else {
    //      System.out.println("zaten bu kursu oxumamisiz siline bilmir");
    //      course.put(name, 100.0);
    //    }

  }

  public void coursesInfos(String name, Double grade) {
    course.put(name, grade);
  }
}

