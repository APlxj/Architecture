package com.swallow.architecture.architecture.contract;

import com.swallow.architecture.mvp.i.IView;
import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IModel;

/**
 * @author swallow.li
 * @describe
 * @date 2019/5/5  17:24
 * - generate by MvpAutoCodePlus plugin.
 */

public interface ILoadingContract {
    interface View extends IView {
    }

    interface Presenter extends IPresenter<View> {
    }

    interface Model extends IModel {
    }
}
