public class MyBio {
  public void myInfo(String name, int age, String gender) {
    String myName = name;
    int myAge = age;
    String yourGender = "";
    if (gender.equals("male")) {
      yourGender = "Kisi";
    } else if (gender.equals("female")) {
      yourGender = "Qadin";
    }

    System.out.println(myName + " " + (2025 - myAge) + " " + gender);
  }
}
