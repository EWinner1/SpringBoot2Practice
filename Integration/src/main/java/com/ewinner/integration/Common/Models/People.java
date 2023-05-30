package com.ewinner.integration.Common.Models;

public class People {
    private Long id;
    private String Name;
    private String PeopleType;
    private String Sex;
    private Short age;
    private String Skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPeopleType() {
        return PeopleType;
    }

    public void setPeopleType(String peopleType) {
        PeopleType = peopleType;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", PeopleType='" + PeopleType + '\'' +
                ", Sex='" + Sex + '\'' +
                ", age=" + age +
                ", Skill='" + Skill + '\'' +
                '}';
    }
}
