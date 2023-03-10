package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void createUser(User user) {
        userDao.saveUser(user);
    }


    @Override
    public String updateUser(User user) {
        userDao.updateUser(user);
        String redirectNotExistsTo = "/users";
        if (user == null)
            return "redirect:" + redirectNotExistsTo;
        return redirectNotExistsTo;
    }


    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }


    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userDao.getUsers());
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
