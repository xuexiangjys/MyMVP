package com.xuexiang.mymvp.model;

/**
 * @author xuexiang
 * @date 2018/1/5 下午2:48
 */
public interface ILoginModel {

    boolean login(String name, String password);

    void register();

}
