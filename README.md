# MyMVP
Dagger2 + Dagger2-android + ARouter + ButterKnife + MVP 的使用演示

## 关于我
[![github](https://img.shields.io/badge/GitHub-xuexiangjys-blue.svg)](https://github.com/xuexiangjys)   [![csdn](https://img.shields.io/badge/CSDN-xuexiangjys-green.svg)](http://blog.csdn.net/xuexiangjys)

## 演示效果（请star支持）
![](https://github.com/xuexiangjys/MyMVP/blob/master/img/dagger2.gif)

## 何为Dagger2

Dagger2是Google提供的依赖注入框架，依赖注入为Android中组件之间的解耦提供了很好的解决方案。
使用它可以自动生成创建依赖关系所需要的代码。减少很多模板化的代码，更易于测试，降低耦合，创建可复用可互换的模块。已经在越来越多的开源项目中被使用，其已经发展成为未来的一个技术趋势。
  
## 为什么要使用Dagger2

MVP设计模式中，M层提供数据，V层做界面展示，而P层则成为M和V的桥梁，这其中就必然涉及到M和V的交互及处理，如果业务复杂或者多个页面共用，它还是面临着高度的耦合性。如果需求发生变动，必然需要更改P中的内容。而在MVP中，我们通常在activity层中需要拿到p层的对象，那么在开发中有可能我们很多activity或者fragment都可能需要拿到这个p层对象的实例，假如我们P层类的构造发生变化(例如增加了参数）我们要在很多地方都得进行修改，这就是耦合度太高的弊端。

为了解决这种耦合性的问题，有一帮牛叉的人就思索着：能不能有个容器，这个容器在我们需要用到某个对象的时候帮我们创建好需要的对象，像对象工厂一样，并且帮我们管理这些对象。当发生变化时，我们只需要换一个容器就可以了。就这样，dagger2应运而生。

## 如何理解Dagger2

简而言之，dagger2中组成内容的对应关系：

- 类Module：使用@Module修饰，装载对象的容器。

- 接口Component：使用@Component修饰，存放这些容器的仓库。它是连接Module和依赖注入对象的桥梁。

- 注解@Provides：该容器创建对象的动作。

- 注解@Inject:从容器中取出这个对象的动作。

- 注解@Qualifier：用来给Inject和Provides贴上关联标签。如果一个对象可以由多个容器提供，这时候就需要用Qualifier进行标签关联。

- 注解@Scope：从容器取出对象的有效期，即生命周期。

## Dagger2的核心使用流程：

- 1.使用@Module修饰编写Module,再通过@Provides修饰该对象的创建方法。

- 2.使用@Component的modules属性修饰存放Module容器的仓库Component，并同时定义依赖注入的接口方法inject，参数为依赖注入的对象。

- 3.执行编译，使用自动生成的[”Dagger” + Component名]类调用之前定义的依赖注入接口方法，再在注入对象上添加@Inject进行注入关联。

## 如何使用Dagger2
1.增加Dagger2依赖包
```
dependencies {
    //Dagger2
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

（1）使用Dagger2单独编写Component装载module

```
@ActivityScope
@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
```

（2）使用Dagger-Android 统一生成装载module
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

(1)使用Dagger2,通过Component取出module注入依赖
```
@Override
protected void onResume() {
   super.onResume();
   DaggerLoginComponent.builder().loginModule(new LoginModule()).build().inject(this);
   mPresenter.attachV(this);
}
```
(2)使用Dagger-Android在BaseActivity中统一AndroidInjection统一取出module注入依赖
```
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);  //统一注入
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
}
```

## 更多框架演示

- [MVP](https://github.com/xuexiangjys/MyMVP)
- [MVVM](https://github.com/xuexiangjys/MyMVVM)
- [Google Architecture Components](https://github.com/xuexiangjys/GoogleComponentsDemo)
