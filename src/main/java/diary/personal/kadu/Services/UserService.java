package diary.personal.kadu.Services;

import diary.personal.kadu.Models.UserRepository;
import diary.personal.kadu.Models.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(String user, String password) {

        if (userRepository.findByUser(user).isPresent()) {
            return false; // já existe
        }

        User usuarioSalvo = userRepository.save(new User(user, password));


        return true;
    }

    public Optional<User> login(String user, String password) {
        return userRepository.findByUser(user).filter(usuario -> usuario.getPassword().equals(password));
    }
}