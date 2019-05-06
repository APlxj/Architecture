package com.swallow.architecture.mvp.callback;


import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface MvpCallback<V extends IView, P extends IPresenter<V>> {

    //------------View---------------------------

    V createView();

    void setMvpView(V view);

    V getMvpView();

    //------------Presenter----------------------

    P createPresenter();

    void setPresenter(P presenter);

    P getPresenter();
}
