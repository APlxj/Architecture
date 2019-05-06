package com.swallow.architecture.mvp.i;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * 类描述：顶层view接口
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IView {

    /**
     * 系统上下文
     *
     * @return
     */
    @Nullable
    Context getContext();

    /**
     * 布局文件ID
     *
     * @return
     */
    int getLayoutId();

    /**
     * 显示等待对话框
     */
    void showWaitDialog(String msg);

    /**
     * 取消显示对话框
     */
    void dismissWaitDialog();

    /**
     * 界面跳转
     */
    void toActivity(Class<?> aClass);

    /**
     * 显示toast信息
     *
     * @param msg
     */
    void showToast(String msg);

}
