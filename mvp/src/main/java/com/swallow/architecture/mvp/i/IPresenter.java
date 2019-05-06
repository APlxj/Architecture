package com.swallow.architecture.mvp.i;

import android.content.Context;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IPresenter<V extends IView> {

    /**
     * 获取系统上下文
     *
     * @return 系统上下文
     */
    Context getContext();

    /**
     * 绑定view层
     * 注：创建view时调用
     *
     * @param view Activity or Fragment
     */
    void attachView(V view);

    /**
     * 销毁view层
     * 注： 销毁view时调用
     */
    void detachView();
}