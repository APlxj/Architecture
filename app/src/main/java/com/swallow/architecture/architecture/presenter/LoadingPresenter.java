package com.swallow.architecture.architecture.presenter;

import com.swallow.architecture.architecture.contract.ILoadingContract;
import com.swallow.architecture.architecture.model.LoadingModel;
import com.swallow.architecture.mvp.base.BasePresenter;

/**
 * @author swallow.li
 * @describe
 * @date 2019/5/5  17:24
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoadingPresenter
        extends BasePresenter<ILoadingContract.View, ILoadingContract.Model>
        implements ILoadingContract.Presenter {

    public LoadingPresenter(ILoadingContract.View mView) {
        super(mView);
    }

    @Override
    public ILoadingContract.Model createModel() {
        return new LoadingModel();
    }
}

