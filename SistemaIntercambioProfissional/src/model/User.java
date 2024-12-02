package model;

public class User {
    private String name;
    private int age;
    private String country;

    public User(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", country='" + country + "'}";
    }
}
