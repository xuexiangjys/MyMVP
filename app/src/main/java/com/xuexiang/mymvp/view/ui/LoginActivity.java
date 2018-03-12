package com.xuexiang.mymvp.view.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xuexiang.mymvp.R;
import com.xuexiang.mymvp.presenter.LoginPresenter;
import com.xuexiang.mymvp.util.ToastUtil;
import com.xuexiang.mymvp.view.impl.ILoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/ui/login")
public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.loginname)
    EditText mEdtLoginName;
    @BindView(R.id.password)
    EditText mEdtPassword;

    @Inject
    LoginPresenter mPresenter;

//    @Override
//    protected void onResume() {
//        super.onResume();
//        DaggerLoginComponent.builder().loginModule(new LoginModule()).build().inject(this);
//        mPresenter.attachV(this);
//    }

    /**
     * 布局的资源id
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void attachView() {
        mPresenter.attachV(this);
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {

    }

    /**
     * 初始化监听
     */
    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (login(mEdtLoginName.getEditableText().toString(), mEdtPassword.getEditableText().toString())) {
//                    startActivity(new Intent(this, MainActivity.class));
                    ARouter.getInstance().build("/ui/main").withString("user_name", mEdtLoginName.getEditableText().toString()).navigation();
                    finish();
                } else {
                    ToastUtil.getInstance(this).showToast("用户名或密码错误！");
                }
                break;
            case R.id.btn_register:
                register();
                break;
            default:
                break;
        }
    }

    @Override
    public Context getContext() {
        return super.getApplicationContext();
    }

    @Override
    public boolean login(String name, String password) {
        return mPresenter.login(name, password);
    }

    @Override
    public void register() {
        mPresenter.register();
    }

}
