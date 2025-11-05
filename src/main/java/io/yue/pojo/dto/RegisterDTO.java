package io.yue.pojo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 15, message = "用户名长度2-15位")
    private String userName;
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 15, message = "密码长度6-15位")
    private String password;
    @NotNull(message= "昵称不能为空")
    @Size(min = 1, max = 20, message = "昵称长度1-20位")
    private String nickName;
}
