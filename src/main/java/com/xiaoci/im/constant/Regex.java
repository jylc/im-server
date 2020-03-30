package com.xiaoci.im.constant;

public class Regex {
    public static final String TELEPHONE = "^1[3|4|5|7|8][0-9]\\d{4,8}$";

    /**
     * 至少6个字符，至少1个字母，1个数字和1个特殊字符
     */
    public static final String STRONG_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$^&*()_+])[A-Za-z\\d~!@#$^&*()_+]{6,}$";
}
