package me.nnsty.api.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import me.nnsty.api.user.service.IUserService;
import me.nnsty.database.dao.IUserDao;
import me.nnsty.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getUserList() {
        EntityWrapper<User> param = new EntityWrapper<>();
        param.eq("enabled",1);
        return userDao.selectList(param);
    }

    @Override
    public User getUser(Long id) {
        EntityWrapper<User> param = new EntityWrapper<>();
        param.eq("id",id);
        return userDao.selectOne(param);
    }

    @Override
    public Boolean addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userDao.insertOrUpdate(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        EntityWrapper<User> param = new EntityWrapper<>();
        param.eq("id", id);
        return userDao.delete(param);
    }
}
