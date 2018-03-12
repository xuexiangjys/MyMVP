# MyMVP
Dragger2 + Dragger2-android + ARouter + MVP 的使用演示

## 如何使用Dragger2
1.增加Dragger2依赖包
```
dependencies {
    //Dragger2
    implementation 'com.google.dagger:dagger:2.13'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.13'

    implementation 'com.google.dagger:dagger-android:2.13'
    implementation 'com.google.dagger:dagger-android-support:2.13'
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.13'

    compileOnly 'org.glassfish:javax.annotation:10.0-b28'

    //ARouter
    compile 'com.alibaba:arouter-api:1.3.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.4'

    //butterknife的sdk
    implementation 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
}
```

2.编写Module
```
@Module
public class LoginModule {
    @ActivityScope
    @Provides
    LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

}
```

3.编写Component装载module

（1）使用Dragger2单独编写Component装载module

```
@ActivityScope
@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
```

（2）使用Dragger-Android 统一生成装载module
```
@ActivityScope
@ContributesAndroidInjector(modules = LoginModule.class)
abstract LoginActivity contributeSecondActivityInjector();
```

4.编译工程
```
  AndroidStudio -> Build -> Make Project
```

5.进行依赖注入

(1)使用Dragger2,通过Component取出module注入依赖
```
@Override
protected void onResume() {
   super.onResume();
   DaggerLoginComponent.builder().loginModule(new LoginModule()).build().inject(this);
   mPresenter.attachV(this);
}
```
(2)使用Dragger-Android在BaseActivity中统一AndroidInjection统一取出module注入依赖
```
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);  //统一注入
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
}
```
