package com.xuexiang.mymvp.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author xuexiang
 * @date 2018/1/5 下午3:22
 */
@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return mContext;
    }

}
