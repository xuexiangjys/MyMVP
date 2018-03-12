package com.xuexiang.mymvp.presenter;

import com.xuexiang.mymvp.model.IMainModel;
import com.xuexiang.mymvp.view.impl.IMainView;

/**
 * @author xuexiang
 * @date 2018/3/12 下午11:27
 */
public class MainPresenter implements IPresent<IMainView>, IMainModel {

    private IMainView mIMainView;

    @Override
    public void attachV(IMainView view) {
        mIMainView = view;
    }

    @Override
    public void detachV() {
        mIMainView = null;
    }

    @Override
    public String getDisplayContent() {
        return "欢迎来到Dragger2的世界！";
    }
}
