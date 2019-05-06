package com.swallow.architecture.mvp.base;

import android.content.Context;

import com.swallow.architecture.mvp.i.IModel;
import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BasePresenter<V extends IView, M extends IModel>
        implements IPresenter<V> {

    public BasePresenter(V mView) {
        attachView(mView);
    }

    protected V mView;
    protected M mModel;

    /**
     * 绑定view,获取model
     *
     * @param view Activity or Fragment
     */
    @Override
    public void attachView(V view) {
        this.mView = view;
        if (null == mModel) mModel = createModel();
    }

    /**
     * 销毁view
     */
    @Override
    public void detachView() {
        mModel = null;
        mView = null;
    }

    public abstract M createModel();

    @Override
    public Context getContext() {
        return mView.getContext();
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }
}
