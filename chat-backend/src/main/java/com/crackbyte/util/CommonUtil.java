package com.crackbyte.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtil {
    private static final Executor executor = Executors.newFixedThreadPool(3);

    public static Executor getExecutor() {
        return executor;
    }

}
