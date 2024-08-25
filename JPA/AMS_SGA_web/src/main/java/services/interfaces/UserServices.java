package services.interfaces;

import domain.User;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserServices {

    List<User> getAllUsers();

    User getUserByUsername(User user);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

}
