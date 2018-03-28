package com.xuexiang.mymvp.di.component;

import android.app.Application;

import com.xuexiang.mymvp.MyApplication;
import com.xuexiang.mymvp.di.ActivitysModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author xuexiang
 * @date 2018/1/5 上午10:27
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
//        AndroidSupportInjectionModule.class,
        ActivitysModule.class
})
public interface AppComponent {
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        Builder application(Application application);
//
//        AppComponent build();
//    }

    void inject(MyApplication myApplication);


}
