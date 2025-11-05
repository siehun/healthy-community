package io.yue.pojo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-05
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
}
