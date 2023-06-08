package com.example.UserManagementSystem.Repository;

import com.example.UserManagementSystem.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Integer> {
}
