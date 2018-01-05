package com.xuexiang.mymvp;

import android.app.Application;

import com.xuexiang.mymvp.di.component.AppComponent;
import com.xuexiang.mymvp.di.component.DaggerAppComponent;
import com.xuexiang.mymvp.di.module.AppModule;

/**
 * @author xuexiang
 * @date 2018/1/5 下午3:34
 */
public class MyApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
