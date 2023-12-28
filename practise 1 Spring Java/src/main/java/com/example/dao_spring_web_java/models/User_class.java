package com.example.dao_spring_web_java.models;

public class User_class {
    private int id;
    private String family_name;
    private String name;
    private String patronymic;
    private int age;
    private String email;
    private String telephone;

//Constructor(спец. метод создания объекта класса путём внесения аргументов в параметр метода и передачи данных в поля класса(члены класса, характеризующие состояние объекта))
public User_class(int id, String family_name, String name, String patronymic, int age, String email, String telephone) {
    this.id = id;
    this.family_name = family_name;
    this.name = name;
    this.patronymic = patronymic;
    this.age = age;
    this.email = email;
    this.telephone = telephone;
    }

//пустой constructor для формы
public User_class() {
    }

    //getters&setters(методы доступа)
    public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }

    public String getFamily_name() {
    return family_name;
    }
    public void setFamily_name(String family_name) {
    this.family_name = family_name;
    }

    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }

    public String getPatronymic() {
    return patronymic;
    }
    public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
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

    public String getTelephone() {
    return telephone;
    }
    public void setTelephone(String telephone) {
    this.telephone = telephone;
    }

}
