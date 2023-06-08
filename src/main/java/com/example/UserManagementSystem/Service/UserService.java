package com.example.UserManagementSystem.Service;

import com.example.UserManagementSystem.Model.User;
import com.example.UserManagementSystem.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository iUserRepository;
    public Iterable<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    public String addUser(User user) {
        iUserRepository.save(user);
        return "User added SuccessFully !!";
    }


    public String updateUser(Integer id, User user) {
        if(iUserRepository.findById(id).isPresent()){
            User old = iUserRepository.findById(id).get();
            old.setId(user.getId());
            old.setName(user.getName());
            old.setAddress(user.getAddress());
            old.setEmail(user.getEmail());
            old.setPassword(user.getPassword());
            iUserRepository.save(old);
            return "User Updated Successfully !!";
        }
        return "User with this " + id + " not exists in database. !!";
    }

    public String deleteUserById(Integer id) {
        if(iUserRepository.findById(id).isPresent()){
            iUserRepository.deleteById(id);
            return "User Deleted SuccessFully";
        }
        return "User with this " + id + " does not present in databse";
    }

    public String deleteAllUsers() {
        iUserRepository.deleteAll();
        return "All the Users are deleted SuccessFully !!";
    }

    public Optional<User> getUserById(Integer id) {
        return iUserRepository.findById(id);
    }
}
