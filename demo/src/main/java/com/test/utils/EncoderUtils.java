package com.test.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderUtils {

    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
