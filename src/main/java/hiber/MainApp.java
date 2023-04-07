package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("vaz1","2101")));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("vaz2","2102")));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("vaz3","2103")));
      userService.add(new User("User4", "Lastname4", "user41@mail.ru",new Car("vaz4","2104")));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
     User user = userService.getUserCar("vaz3", "2103");
     System.out.format("Данные юзера, владеющего машиной %s: ", user.getEmpCar() +"\n"
             + "Имя: "+ user.getFirstName() +"\n"
             + "Фамилия: "+user.getLastName() +"\n"
             + "Email: "+ user.getEmail());
      context.close();
   }
}
