package com.fun.main.server.domain.service;


import com.fun.main.sdk.vo.user.UserVO;
import com.fun.main.server.domain.entities.User;
import com.fun.main.server.intefaces.mapper.UserMapper;
import com.fun.main.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 19:23
 */

@Service("userService")
@Transactional(rollbackFor = Throwable.class)
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserVO findById(Long id) {
        User user = User.getUserById(id);
        return userMapper.toUserVO(user);
    }

    public List<UserVO> findAll() {
        return userMapper.toUserVO(userRepository.findAll());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

}