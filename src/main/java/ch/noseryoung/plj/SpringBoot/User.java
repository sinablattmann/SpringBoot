package ch.noseryoung.plj.SpringBoot;

public class User {

  private String firstName;
  private String lastName;
  private long id;

  public User() {
    
  }
  public User(String firstName, String lastName, long id) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
