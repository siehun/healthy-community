package io.yue.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.yue.common.result.Result;
import io.yue.common.result.ResultFacotry;
import io.yue.pojo.dto.LoginDTO;
import io.yue.pojo.dto.RegisterDTO;
import io.yue.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<String> login(@Valid @RequestBody LoginDTO dto) {
        String vo = userService.login(dto);
        return ResultFacotry.ok(vo, "登录成功");
    }

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<String> register(@Valid @RequestBody RegisterDTO dto) {
        userService.register(dto);
        return ResultFacotry.ok("注册成功");
    }

}
