package com.xhj.exception;

/**
 * Created by 熊厚谨 on 2018/5/30 19:31
 *
 * @author 熊厚谨
 */
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public UserNotExistException(String id) {
        super("  user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public UserNotExistException setId(String id) {
        this.id = id;
        return this;
    }
}
