package io.yue.common;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-05
 * @Description: 用户session信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
    private String userId;
    private String userName;
    private String nickName;
}
