public class Human {
  private String name;
  private String surName;
  private int height;
  private int weight;
  private String gender;

  public Human(String name, String surName, int height, int weight, String gender) {
    this.name = name;
    this.surName = surName;
    this.height = height;
    this.weight = weight;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Human{" + "name='" + name + '\'' + ", surName='" + surName + '\'' + ", height=" + height + ", weight=" + weight + ", gender='" + gender + '\'' + '}';
  }
}
