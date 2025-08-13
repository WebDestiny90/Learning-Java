public class Event<T extends Human> {
  private T attendance;
  private String type;

  public Event(T attendance, String type) {
    this.attendance = attendance;
    this.type = type;
  }

  public T getAttendance() {
    return attendance;
  }

  public void setAttendance(T attendance) {
    this.attendance = attendance;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
