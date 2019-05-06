package com.swallow.architecture.mvp.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.swallow.architecture.mvp.i.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IActivity extends IView {

    void process(Bundle savedInstanceState);

    /**
     * 为统一标题栏与状态栏的颜色，我们需要更改状态栏的颜色，而状态栏文字颜色是在android 6.0之后才可以进行更改
     * 所以统一在6.0之后进行文字状态栏的更改
     */
    void setStatusBar();

    /**
     * 是否设置成透明状态栏，即就是全屏模式
     *
     * @return
     */
    boolean isUseFullScreenMode();

    /**
     * 状态栏颜色
     *
     * @return
     */
    int setStatusBarColor();

    /**
     * 是否改变状态栏文字颜色为黑色
     *
     * @return
     */
    boolean isUserLightMode();

    /**
     * 切换fragment
     *
     * @param frameLayoutId 布局ID
     * @param fragment      fragment对象
     */
    void showFragment(int frameLayoutId, Fragment fragment);

    /**
     * 弹出对话框
     *
     * @param title
     * @param message
     */
    void showMsgDialog(String title, String message);

}
