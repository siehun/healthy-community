package io.yue.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.yue.common.UserSession;
import io.yue.mapper.UserMapper;
import io.yue.pojo.dto.LoginDTO;
import io.yue.pojo.dto.RegisterDTO;
import io.yue.pojo.entity.User;
import io.yue.service.UserService;
import io.yue.utils.IdUtils;
import io.yue.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-05
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private Integer expireTime = 360000;
    private String secret = "jwtSecret";

    @Override
    public String login(LoginDTO dto) {
        if (dto == null) {
            throw new RuntimeException("登录参数为空");
        }
        String userName = dto.getUserName();
        String password = dto.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda()
                .eq(userName != null, User::getUser_name, dto.getUserName());
        User user = getOne(queryWrapper);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        String enPassword = DigestUtil.md5Hex(password);
        if (!enPassword.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        UserSession session = BeanUtil.copyProperties(user, UserSession.class);
        String strJson = JSON.toJSONString(session);
        String token = JwtUtils.sign(user.getId(), strJson, expireTime, secret);
        log.info("登录token为：{}", token);
        return token;
    }

    @Override
    public void register(RegisterDTO dto) {
        if (dto == null) {
            throw new RuntimeException("注册参数为空");
        }
        User user = BeanUtil.copyProperties(dto, User.class);
        String password = DigestUtil.md5Hex(dto.getPassword());
        user.setUser_name(dto.getUserName());
        user.setNick_name(dto.getNickName());
        user.setPassword(password);
        user.setCreated_time(new Date());
        long id = IdUtils.nextId();
        user.setId(id);
        saveOrUpdate(user);
        log.info("用户注册成功,用户id:{}", id);
    }

}
