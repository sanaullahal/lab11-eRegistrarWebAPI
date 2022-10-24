package edu.miu.cs.cs425.eregistrar.Service.Impl;

import edu.miu.cs.cs425.eregistrar.Repository.UserRepository;
import edu.miu.cs.cs425.eregistrar.Service.UserService;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    @Override
    public User saveUser(User user) {
        // Encrypt the password using BCrypt
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }


}

