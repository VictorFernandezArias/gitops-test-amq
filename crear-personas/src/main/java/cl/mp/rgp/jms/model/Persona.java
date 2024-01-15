package cl.mp.rgp.jms.model;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Persona implements Serializable{
    private String name;
    private int age;
    private String email;

    private static final List<String> NOMBRES = List.of("Hanamichi Sakuragi", "Ryota Miyagi", "Hisashi Mitsui");
    private static final List<String> EMAILVENDOR = List.of("@gmail.com", "@redhat.com", "@hotmail.com");

    private static String getRandomName() {
        Random rand = new Random();
        int index = rand.nextInt(NOMBRES.size());
        return NOMBRES.get(index);
    }
    private static String getRandomEmailVendor() {
        Random rand = new Random();
        int index = rand.nextInt(EMAILVENDOR.size());
        return EMAILVENDOR.get(index);
    }
    private static int getRandomAge() {
        Random rand = new Random();
        int randNum = rand.nextInt(5);
        return 17+randNum;
    }
    public Persona() {
        this.name = getRandomName();
        this.age = getRandomAge();
        this.email = this.name.replace(' ', '_').toLowerCase() + getRandomEmailVendor();
        
    }

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
    
    @Override
    public String toString() {
        return "Persona{ Name ='" + this.name + '\'' + " EMAIL ='" + this.email + '\'' + " EDAD ='" + this.age + '\'' + " }";
    }
}
