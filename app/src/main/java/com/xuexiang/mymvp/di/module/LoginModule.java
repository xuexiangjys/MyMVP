package com.xuexiang.mymvp.di.module;

import com.xuexiang.mymvp.di.scope.ActivityScope;
import com.xuexiang.mymvp.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xuexiang
 * @date 2018/1/5 上午9:46
 */
@Module
public class LoginModule {

    @ActivityScope
    @Provides
    LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

}
