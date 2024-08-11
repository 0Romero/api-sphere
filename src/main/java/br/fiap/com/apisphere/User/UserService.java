package br.fiap.com.apisphere.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) { 
        return userRepository.save(user);
    }

    public List<User> listUser() {
        return userRepository.findAll();

    }

    public User findUserById(Long id) { 
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User updateUser(long id, User newUser ) {
        User user = findUserById(id);
        if (user != null) { 
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }

    public void deleteUser(long id) { 
        userRepository.deleteById(id);
    }

}
