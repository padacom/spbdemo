package me.nnsty.api.user.service;

import me.nnsty.database.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getUserList();

    User getUser(Long id);

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Long id);
}
