package com.xuexiang.mymvp.di.module;

import com.xuexiang.mymvp.di.scope.ActivityScope;
import com.xuexiang.mymvp.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xuexiang
 * @date 2018/3/12 下午11:26
 */
@Module
public class MainModule {
    @ActivityScope
    @Provides
    MainPresenter getPresenter() {
        return new MainPresenter();
    }
}
