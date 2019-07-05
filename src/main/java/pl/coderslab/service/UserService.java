package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean userAuthorization(String login, String password) {
        User userRepositoryByLogin = userRepository.findByLogin(login);
        if (userRepositoryByLogin != null) {
            if (BCrypt.checkpw(password, userRepositoryByLogin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(User user) {
        String passwordForm = user.getPassword();
        user.setPassword(BCrypt.hashpw(passwordForm, BCrypt.gensalt()));
        user.setCreated(LocalDate.now());
        userRepository.save(user);
    }

    public boolean userLoginInUse(String login) {
        return userRepository.findByLogin(login) != null;
    }
}
