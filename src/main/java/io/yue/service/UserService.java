package io.yue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.yue.pojo.dto.LoginDTO;
import io.yue.pojo.dto.RegisterDTO;
import io.yue.pojo.entity.User;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-04
 * @Description:
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录
     */
    String login(LoginDTO dto);

    /**
     * 用户注册
     */
    void register(RegisterDTO dto);
}
