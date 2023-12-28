package com.example.dao_spring_web_java.controllers;

import com.example.dao_spring_web_java.DAO.DAO_user;
import com.example.dao_spring_web_java.models.User_class;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class User{

    //объект класса DAO_user
    //dependency injection
    private final DAO_user daoUser;

    //constructor
    public User(DAO_user daoUser) {
        this.daoUser = daoUser;
    }

    //шаблон ввода(внесение данных с помощью запроса c http методом GET)
    // /add?family name=Иванов&name=Иван&patronymic=Иванович&age=25&email=ivanov@gmail.com&telephone=89161234567
    // /add?family name=Петров&name=Пётр&patronymic=Петрович&age=45&email=petrov@gmail.com&telephone=89167654321

    //метод добавления пользователя(внесение данных с помощью запроса c http методом GET без тела запроса) через DAO_user в Arraylist
//    @GetMapping("/user/add")
//    public void addUser(@RequestParam(value = "family name", required = false)String family_name, @RequestParam(value = "name", required = false)String name, @RequestParam(value = "patronymic", required = false) String patronymic, @RequestParam(value = "age", required = false)int age, @RequestParam(value = "email", required = false)String email, @RequestParam(value = "telephone", required = false)String telephone){
//        daoUser.adduser(family_name, name, patronymic, age, email, telephone);
//   }

    //шаблон ввода начальной страницы
    // http://localhost:8080/user

    // метод позволяет получить весь список пользователей и вывести его на html страницу
    @GetMapping("/user")
    public String index(Model model){
    model.addAttribute("Userr", daoUser.getUsers());
    return "User";
    }

    //метод позволяет получить экземпляр класса из листа по id
    @GetMapping("/User/{id}")
    public String infoUser(@PathVariable("id")int id, Model model){
    model.addAttribute("Userr", daoUser.getUserId(id));
    return "User_info";
    }

    //метод позволяет отобразить view с формой добавления пользователя
    @GetMapping("/user/add")
    public String newUser(Model model){
        model.addAttribute("Userr", new User_class());
    return "add_User";
    }

    //метод осуществляет принятие даннх с формы и добавляет их как объек(экземпляр класса) в лист(Arrylist)
    @PostMapping("/user/add")
    public String User_form_add(@ModelAttribute("Userr") User_class user_post){
    daoUser.adduser(user_post);
    return "redirect:/user";
    }

    //метод осуществляет получение и редактирование объекта(экземпляра) класса по id через форму
    @GetMapping("/user/edit{id}")
    public String User_edit(@PathVariable("id")int id, Model model){
        model.addAttribute("edit_Userr", daoUser.getUserId(id));
        return "User_edit";
    }

    //метод позволяет принять редактируемые поля экземпляра класса с формы и обновить информацию в нём
    @PostMapping("/user/edit{id}")
    public String User_edit_add_from_form(@ModelAttribute("edit_Userr") User_class user_edit, @PathVariable("id") int id){
    daoUser.updatePerson(id, user_edit);
        return "redirect:/user";
    }

    //метод позволяет удалить экземпляр класса по id
    @GetMapping("/user/delete/{id}")
    public String delete_User(@PathVariable("id") int id){
    daoUser.delete_user(id);
        return "redirect:/user";
    }

}
