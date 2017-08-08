package com.lhx.utils;

import java.util.UUID;

/**
 * 生成UUID工具类。
 * @author liangshu
 *
 */
public class UUIDUtil {
	
	public static String getUUID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }

}
