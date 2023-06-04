package com.yu.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record R(int code, List data, String msg){
    public static R ok(){
        return new R(200, null, "ok");
    }
    public static R ok(List data){
        return new R(200, data, "ok");
    }
    public static R ok(List data, String msg){
        return new R(200, data, msg);
    }
    public static R error(){
        return new R(500, null, "error");
    }
    public static R error(String msg){
        return new R(500, null, msg);
    }
    @NotNull
    @Contract("_ -> new")
    public static R error(List data){
        return new R(500, data, "error");
    }
    @NotNull
    @Contract("_, _ -> new")
    public static R error(List data, String msg){
        return new R(500, data, msg);
    }
}
