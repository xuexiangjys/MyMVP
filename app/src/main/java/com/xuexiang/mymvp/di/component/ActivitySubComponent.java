package com.xuexiang.mymvp.di.component;

import com.xuexiang.mymvp.view.ui.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 *
 * @author xuexiang
 * @date 2018/3/12 下午11:24
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
})
public interface ActivitySubComponent extends AndroidInjector<BaseActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {
    }

}
