package com.xuexiang.mymvp.view.ui;

import android.content.Context;
import android.widget.TextView;

import com.xuexiang.mymvp.R;
import com.xuexiang.mymvp.presenter.MainPresenter;
import com.xuexiang.mymvp.view.impl.IMainView;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author xuexiang
 * @date 2018/3/12 下午5:58
 */
public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.tv_display)
    TextView mTvDisplay;

    @Inject
    MainPresenter mPresenter;

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

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {
        mTvDisplay.setText(mPresenter.getDisplayContent());
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
