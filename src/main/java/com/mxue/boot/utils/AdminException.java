package com.mxue.boot.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Zhang Liqiang
 * @email 18945085165@163.com
 * @date 2021/11/30
 * @description:
 **/
@Setter
@Getter
public class AdminException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    private int code = 500;

    public AdminException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AdminException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AdminException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AdminException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
