package cl.mp.rgp.jms.model;

import java.io.Serializable;

public class Persona implements Serializable{
    private String name;
    private int age;
    private String email;
    private Boolean notified;

    public Persona() {}

    public Persona(String name,int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getNotified() {
        return notified;
    }
    public void setNotified(Boolean notified) {
        this.notified = notified;
    }
    
    @Override
    public String toString() {
        return "Persona{ Name ='" + this.name + '\'' + " EMAIL ='" + this.email + '\'' + " AGE ='" + this.age + '\'' +  " NOTIFIED ='" + this.notified + '\'' +" }";
    }
}
