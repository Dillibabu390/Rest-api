package com.students.task.service;

import com.students.task.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUser();

    public void save(User user);

    public User findById(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

 }


