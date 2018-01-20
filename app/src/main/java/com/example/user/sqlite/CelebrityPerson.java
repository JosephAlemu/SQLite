package com.example.user.sqlite;

/**
 * Created by user on 1/16/2018.
 */

public class CelebrityPerson {

    Integer id;
    String name;
    String  age;
    String gender;
    String favorite;

    public CelebrityPerson(Integer id, String name, String age, String gender, String favorite) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.favorite = favorite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "CelebrityPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}

