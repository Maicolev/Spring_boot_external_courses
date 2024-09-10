package data;

import domain.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findById(User user);

    User findUserByUsername(User user);

    public void save(User user);

    public void delete(User user);

    public void update(User user);

}
