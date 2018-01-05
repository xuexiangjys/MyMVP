package com.xuexiang.mymvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.xuexiang.mymvp.di.component.DaggerLoginComponent;
import com.xuexiang.mymvp.di.module.LoginModule;
import com.xuexiang.mymvp.presenter.LoginPresenter;
import com.xuexiang.mymvp.view.ILoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.loginname)
    EditText mEdtLoginName;
    @BindView(R.id.password)
    EditText mEdtPassword;
    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        DaggerLoginComponent.builder().loginModule(new LoginModule()).build().inject(this);
        mPresenter.attachV(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_login:
                login(mEdtLoginName.getEditableText().toString(), mEdtPassword.getEditableText().toString());
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
    public void login(String name, String password) {
        mPresenter.login(name, password);
    }

    @Override
    public void register() {
        mPresenter.register();
    }
}
