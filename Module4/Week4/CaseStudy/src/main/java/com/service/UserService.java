package com.service;

import com.model.user.User;
import com.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void register(User user) {
        if (emailExisted(user.getEmail())) {
            throw new IllegalArgumentException("Email đã tồn tại");
        }
        if (usernameExisted(user.getUsername())) {
            throw new IllegalArgumentException("Tên người dùng đã tồn tại");
        }
        userRepository.save(user);
    }

    public boolean checkLogin(String username, String password) {
        if (!usernameExisted(username)) {
            return false;
        }
        User user = userRepository.getByUsername(username);
        return user.getPassword().equals(password);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Transactional
    public void update(Long userId, String email, String password) {
        User foundUser = userRepository.findById(userId).orElse(null);
        if (foundUser != null) {
            foundUser.setEmail(email);
            foundUser.setPassword(password);
            userRepository.save(foundUser);
        }
    }

    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    private boolean emailExisted(String email) {
        return email.equals(userRepository.getByEmail(email).getEmail());
    }

    private boolean usernameExisted(String username) {
        return username.equals(userRepository.getByUsername(username).getUsername());
    }
}
