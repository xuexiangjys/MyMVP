package com.xuexiang.mymvp.di;

import com.xuexiang.mymvp.di.component.BaseActivityComponent;
import com.xuexiang.mymvp.di.module.LoginModule;
import com.xuexiang.mymvp.di.module.MainModule;
import com.xuexiang.mymvp.di.scope.ActivityScope;
import com.xuexiang.mymvp.view.ui.LoginActivity;
import com.xuexiang.mymvp.view.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AllActivitysModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity contributeSecondActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivitytInjector();

}
