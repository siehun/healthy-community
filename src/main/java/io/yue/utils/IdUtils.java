package io.yue.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-05
 * @Description:
 */
public class IdUtils {
    private static long terminalId = 20;
    private static long centerId = 21;
    private static Snowflake snowflake= IdUtil.getSnowflake(terminalId, centerId);
    public static long nextId() {
        return snowflake.nextId();
    }
}
