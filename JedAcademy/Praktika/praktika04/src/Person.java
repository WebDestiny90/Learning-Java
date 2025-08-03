class Person {
  private String name;
  private int age;
  private String gender;
  private String nationality;
  private String job;

  public Person(String name, int age, String gender, String nationality, String job) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.nationality = nationality;
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public String getNationality() {
    return nationality;
  }

  public String getJob() {
    return job;
  }
}
