package com.example.dao_spring_web_java.DAO;
import com.example.dao_spring_web_java.models.User_class;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class DAO_user {
    private int id;
    private List<User_class> users = new ArrayList<>();

// 1. метод для создания экземпляра класса User и добавления его в лист users
//public void adduser(String family_name, String name, String patronymic, int age, String email, String telephone){
//    users.add(new User(++id, family_name, name, patronymic, age, email, telephone));
//}

// 1.1 метод добавления объекта класса в лист
    public void adduser(User_class Userr){
    users.add(Userr);
    Userr.setId(++id);
  }

// 2. getter List users(позволяет получить все экземпляры класса User)
    public List<User_class> getUsers(){
        return users;
    }

// 3. метод позволяет получить объект(экземпляр класса) из лисат Arraylist по id
    public User_class getUserId(int id){
 //     for(User Usr: users){
 //        if(Usr.getId() == id){
 //          return Usr;
 //        }
 //     }
 //     return null;

// 3.1 иной вариант перебора
    return users.stream().filter(User -> User.getId() == id).findAny().orElse(null);
    }

// 4. метод позволяет найти пользователя по id и изменить данные в полях экземпляра класса
    public void updatePerson(int id, User_class user_edit){
        User_class userUpdate = getUserId(id);// будет получен редактируемый объект по его id
        userUpdate.setFamily_name(user_edit.getFamily_name());
        userUpdate.setName(user_edit.getName());
        userUpdate.setPatronymic(user_edit.getPatronymic());
        userUpdate.setAge(user_edit.getAge());
        userUpdate.setEmail(user_edit.getEmail());
        userUpdate.setTelephone(user_edit.getTelephone());
    }
// 5. метод удаления пользователя по id из листа
    public void delete_user(int id){
        users.removeIf(userDel -> userDel.getId() == id);
    }
}
