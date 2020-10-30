/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package hellosecurity.dao;

import hellosecurity.dto.User;
import java.util.List;

public interface UserDao {
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
    User createUser(User user);
}
