class Student implements Comparable<Student> {
  String name;
  int age;

  Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Student other) {
    return this.age - other.age;
  }

  @Override
  public String toString() {
    return name + " (" + age + ")";
  }
}