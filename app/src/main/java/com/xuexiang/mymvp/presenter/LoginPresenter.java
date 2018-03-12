package com.xuexiang.mymvp.presenter;

import com.xuexiang.mymvp.model.ILoginModel;
import com.xuexiang.mymvp.util.ToastUtil;
import com.xuexiang.mymvp.view.impl.ILoginView;

/**
 * @author xuexiang
 * @date 2018/1/5 下午3:07
 */
public class LoginPresenter implements IPresent<ILoginView>, ILoginModel{

    private ILoginView mLoginView;

    @Override
    public void attachV(ILoginView view) {
        mLoginView = view;
    }

    @Override
    public void detachV() {
        mLoginView = null;
    }

    @Override
    public boolean login(String name, String password) {
//        ToastUtil.getInstance(mLoginView.getContext()).showToast("正在进行登陆，用户名：" + name + "，密码：" + password);
        return name.equals("xuexiang") && password.equals("123456");
    }

    @Override
    public void register() {
        ToastUtil.getInstance(mLoginView.getContext()).showToast("点击了注册按钮");
    }
}
