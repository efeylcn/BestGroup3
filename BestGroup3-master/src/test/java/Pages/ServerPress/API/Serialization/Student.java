package Pages.ServerPress.API.Serialization;

import java.io.Serializable;

public class Student  {

    private String firstName;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String lastName;
    private int id;
    private long age;
    private char gender;


    public Student(String firstName, String lastName, int id, long age, char gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }


}
