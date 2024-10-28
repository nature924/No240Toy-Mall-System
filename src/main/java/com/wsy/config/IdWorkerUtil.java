package com.wsy.config;

import com.baomidou.mybatisplus.toolkit.IdWorker;

public class IdWorkerUtil {

    public static final String getId(){
        return "wsy"+ IdWorker.getId();
    }
}
