public class Main {
  public static void main(String[] args) {
    Human human = new Human("Taleh", "Aghayev");
    Human jS = new Human("Xd", "Aghayev");
    Human jS2 = new Human("Togrul", "Bagirov");
    Human jS3 = new Human("Vusal", "Huseynov");

    human.coursesInfos("Java", 25.5);
    human.coursesInfos("Python", 34.9);
    human.removeCourse("Python");


    jS.coursesInfos("JavaScript", 80.5);
    jS2.coursesInfos("C++", 90.5);
    jS3.coursesInfos("Godot", 95.5);
    System.out.println(human);
    System.out.println(jS);
    System.out.println(jS2);
    System.out.println(jS3);


  }
}