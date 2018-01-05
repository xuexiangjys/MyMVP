package com.xuexiang.mymvp.view;

import android.content.Context;

/**
 * @author xuexiang
 * @date 2018/1/5 下午2:33
 */
public interface ILoginView {

    Context getContext();

    void login(String name, String password);

    void register();

}
