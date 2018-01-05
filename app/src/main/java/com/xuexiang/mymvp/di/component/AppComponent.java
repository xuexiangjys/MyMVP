package com.xuexiang.mymvp.di.component;

import android.content.Context;

import com.xuexiang.mymvp.LoginActivity;
import com.xuexiang.mymvp.MyApplication;
import com.xuexiang.mymvp.di.module.AppModule;
import com.xuexiang.mymvp.util.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author xuexiang
 * @date 2018/1/5 上午10:27
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();

    ToastUtil getToastUtil();

}
