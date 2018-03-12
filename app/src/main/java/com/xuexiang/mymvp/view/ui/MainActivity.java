package com.xuexiang.mymvp.view.ui;

import android.content.Context;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xuexiang.mymvp.R;
import com.xuexiang.mymvp.presenter.MainPresenter;
import com.xuexiang.mymvp.view.impl.IMainView;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author xuexiang
 * @date 2018/3/12 下午5:58
 */
@Route(path = "/ui/main")
public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.tv_display)
    TextView mTvDisplay;

    @BindView(R.id.tv_user_name)
    TextView mTvUserName;

    @Inject
    MainPresenter mPresenter;

    @Autowired(name = "user_name")
    String UserName;

    /**
     * 布局的资源id
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void attachView() {
        mPresenter.attachV(this);
    }

    @Override
    protected void initArgs() {
        super.initArgs();
        ARouter.getInstance().inject(this);
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {
        mTvDisplay.setText(mPresenter.getDisplayContent());
        mTvUserName.setText(UserName);
    }

    /**
     * 初始化监听
     */
    @Override
    protected void initListener() {

    }

    @Override
    public Context getContext() {
        return super.getApplicationContext();
    }
}
