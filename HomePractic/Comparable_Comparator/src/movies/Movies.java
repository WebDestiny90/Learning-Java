package movies;

public class Movies {
  private String title;
  private double raiting;
  private Integer year;

  public Movies(String title, double raiting, Integer year) {
    this.title = title;
    this.raiting = raiting;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getRaiting() {
    return raiting;
  }

  public void setRaiting(double raiting) {
    this.raiting = raiting;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Movies{" + "title='" + title + '\'' + ", raiting=" + raiting + ", year=" + year + '}';
  }
}
