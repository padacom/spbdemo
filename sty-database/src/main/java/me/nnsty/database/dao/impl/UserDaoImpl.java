package me.nnsty.database.dao.impl;

import me.nnsty.database.entity.User;
import me.nnsty.database.mapper.UserMapper;
import me.nnsty.database.dao.IUserDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ly
 * @since 2019-10-30
 */
@Service
public class UserDaoImpl extends ServiceImpl<UserMapper, User> implements IUserDao {

}
