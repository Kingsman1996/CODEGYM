package com.service;

import com.model.ContactInfo;
import com.model.User;
import com.repo.ContactInfoRepository;
import com.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ContactInfoRepository contactInfoRepository;  // Inject ContactInfoRepository

    @Autowired
    public UserService(UserRepository userRepository, ContactInfoRepository contactInfoRepository) {
        this.userRepository = userRepository;
        this.contactInfoRepository = contactInfoRepository;
    }

    @Transactional
    public void register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }

        userRepository.save(user);
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setUser(user);
        contactInfoRepository.save(contactInfo);
    }

    public boolean checkLogin(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    @Transactional
    public void update(User updatedUser) {
        Optional<User> userOptional = userRepository.findById(updatedUser.getId());
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            foundUser.setPassword(updatedUser.getPassword());
            ContactInfo currentContactInfo = foundUser.getContactInfo();
            currentContactInfo.setAddress(updatedUser.getContactInfo().getAddress());
            currentContactInfo.setPhone(updatedUser.getContactInfo().getPhone());
            currentContactInfo.setEmail(updatedUser.getContactInfo().getEmail());
            userRepository.save(foundUser);
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
