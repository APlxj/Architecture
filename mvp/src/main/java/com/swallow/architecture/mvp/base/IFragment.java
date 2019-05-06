package com.swallow.architecture.mvp.base;

import android.view.View;

import com.swallow.architecture.mvp.i.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IFragment extends IView {
    /**
     * 加载view
     */
    void initView(View view);

    /**
     * 初始化数据
     */
    void init();
}
