# MyMVP
Dragger2 + MVP 的使用演示

## 如何使用Dragger2
1.增加Dragger2依赖包
```
    dependencies {
        implementation 'com.google.dagger:dagger:2.13'
        annotationProcessor 'com.google.dagger:dagger-compiler:2.13'
        compileOnly 'org.glassfish:javax.annotation:10.0-b28'
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

3.编写Component
```
    @ActivityScope
    @Component(modules = {LoginModule.class})
    public interface LoginComponent {
        void inject(LoginActivity activity);
    }
```

4.编译工程
```
  AndroidStudio -> Build -> Make Project
```

5.进行依赖注入
```
    @Override
    protected void onResume() {
       super.onResume();
       DaggerLoginComponent.builder().loginModule(new LoginModule()).build().inject(this);
       mPresenter.attachV(this);
   }
```
