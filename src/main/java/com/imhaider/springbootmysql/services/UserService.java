package com.imhaider.springbootmysql.services;
import com.imhaider.springbootmysql.entity.User;
import com.imhaider.springbootmysql.mapper.UserMapper;
import com.imhaider.springbootmysql.repo.UserRepository;
import org.springframework.stereotype.Service;
import com.imhaider.springbootmysql.dto.user.UserDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public UserDTO createUser(final User user){
        return UserMapper.toDto(userRepository.save(user));
    }

    public UserDTO getUser(final Integer id) {
        Optional<User> user= userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("message: "+"The user was not found");
        }
        return user.map(UserMapper::toDto).get();
    }
    public Optional<User> getUser(final String email) {
        return userRepository.findUserByEmail(email);
    }

    public UserDTO updateUser(final Integer id, final User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("message"+"User was not found"));

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        return UserMapper.toDto(userRepository.save(existingUser));
    }

    public String deleteUser(final Integer id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
            return "User Deleted Successfully";
        }
        else{
            throw new RuntimeException("Message: The user was not found!");
        }

    }
}
