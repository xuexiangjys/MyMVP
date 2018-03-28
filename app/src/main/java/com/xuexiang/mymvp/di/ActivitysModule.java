package com.xuexiang.mymvp.di;

import com.xuexiang.mymvp.di.component.ActivitySubComponent;
import com.xuexiang.mymvp.di.module.LoginModule;
import com.xuexiang.mymvp.di.module.MainModule;
import com.xuexiang.mymvp.di.scope.ActivityScope;
import com.xuexiang.mymvp.view.ui.LoginActivity;
import com.xuexiang.mymvp.view.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 所有Activity的注入module注册
 * @author xuexiang
 * @date 2018/3/28 下午5:34
 */
@Module(subcomponents = {
        ActivitySubComponent.class
})
public abstract class ActivitysModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity contributeLoginActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivitytInjector();

}
