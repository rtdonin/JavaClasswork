/*
Created by: Margaret Donin
Date created: 10/26/20
Date revised:
 */
package masteryddwa.controller;

import static java.lang.Integer.parseInt;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import masteryddwa.dao.PostDao;
import masteryddwa.dao.RoleDao;
import masteryddwa.dao.UserDao;
import masteryddwa.dto.Post;
import masteryddwa.dto.Role;
import masteryddwa.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    PasswordEncoder encoder;
    
    Set<ConstraintViolation<User>> violations;

    @GetMapping("usersAll")
    public String usersAll(Model model) {
        List<User> users = userDao.getAllUsers();
        List<Post> statics = postDao.getAllEnabledStatics();

        model.addAttribute("users", users);
        model.addAttribute("statics", statics);

        return "usersAll";
    }

    @GetMapping("userAdd")
    public String userAdd(Model model) {
        violations = new HashSet<>();
        List<Role> roles = roleDao.getAllRoles();
        List<Post> statics = postDao.getAllEnabledStatics();

        model.addAttribute("roles", roles);
        model.addAttribute("statics", statics);
        model.addAttribute("errors", violations);

        return "userAdd";
    }

    @PostMapping("userAdd")
    public String userAdd(String username, String password, String email, String[] roleIds) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEmail(email);
        user.setEnabled(true);

        Set<Role> roles = new HashSet<>();
        if (roleIds != null) {
            for (int i = 0; i < roleIds.length; i++) {
                roles.add(roleDao.getRoleById(parseInt(roleIds[i])));
            }
        } else {
            roles.add(roleDao.getRoleByRole("USER"));
        }
        user.setRoles(roles);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(user);

        if (violations.isEmpty()) {
            user = userDao.addUser(user);
            return "redirect:/user";
        } else {
            return "userAdd";
        }

    }

    @GetMapping("user")
    public String viewUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<Post> statics = postDao.getAllEnabledStatics();
        User user = userDao.getUserByLogin(authentication.getName());

        model.addAttribute("statics", statics);
        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping("userEdit")
    public String editUserDisplay(Integer userId, Model model, Integer error) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByLogin(authentication.getName());
        User editUser = userDao.getUserById(userId);
        List<Role> roleList = roleDao.getAllRoles();
        List<Post> statics = postDao.getAllEnabledStatics();

        model.addAttribute("roles", roleList);
        model.addAttribute("statics", statics);

        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "Passwords did not match, password was not updated.");
            }
        }

        if (user.getRoles().contains("ROLE_ADMIN")) {
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", editUser);
        }

        return "userEdit";

    }

    @PostMapping("userEdit")
    public String editUserAction(String[] roleIdList, Boolean enabled, Integer id) {
        User user = userDao.getUserById(id);
        if (enabled != null) {
            user.setEnabled(enabled);
        } else {
            user.setEnabled(false);
        }

        Set<Role> roleList = new HashSet<>();
        for (String roleId : roleIdList) {
            Role role = roleDao.getRoleById(Integer.parseInt(roleId));
            roleList.add(role);
        }
        user.setRoles(roleList);
        userDao.updateUser(user);

        return "redirect:/user";
    }

    @PostMapping("editPassword")
    public String editPassword(Integer id, String password, String confirmPassword) {
        User user = userDao.getUserById(id);

        if (password.equals(confirmPassword)) {
            user.setPassword(encoder.encode(password));
            userDao.updateUser(user);
            return "redirect:/user";

        } else {
            return "redirect:/userEdit?error=1";
        }
    }

    @GetMapping("userDelete")
    public String deleteUser(Integer id) {
        userDao.deleteUserById(id);

        return "redirect:/userAll";
    }

}
