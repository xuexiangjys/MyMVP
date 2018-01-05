package com.xuexiang.mymvp.di.component;

import com.xuexiang.mymvp.LoginActivity;
import com.xuexiang.mymvp.di.module.LoginModule;
import com.xuexiang.mymvp.di.scope.ActivityScope;

import dagger.Component;

/**
 * @author xuexiang
 * @date 2018/1/5 下午3:18
 */
@ActivityScope
@Component(modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity activity);
}
