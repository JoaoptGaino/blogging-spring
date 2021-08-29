package com.blogging.blogging.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("User with id " + id + " doesn't exists");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, User data){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalStateException("User with id "+ id + "doesn't exists"));
        if(data.getEmail() != null && data.getEmail().length()>0 && !Objects.equals(user.getEmail(),data.getEmail())){
            Optional<User> userOptional = userRepository.findUserByEmail(data.getEmail());

            if(userOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            user.setEmail(data.getEmail());
        }
    }
}
