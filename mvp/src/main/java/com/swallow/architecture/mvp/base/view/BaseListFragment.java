package com.swallow.architecture.mvp.base.view;

import android.support.annotation.NonNull;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseListFragment<V extends IView, P extends IPresenter<V>>
        extends BaseFragment<V, P>
        implements OnLoadMoreListener, OnRefreshListener {

    protected int page = 0;
    protected int pageSize = 10;
    protected SmartRefreshLayout refreshLayout = null;
    protected boolean isRefresh = false;

    @Override
    public void initView(View view) {
        if (null != refreshLayout) {
            refreshLayout.setOnLoadMoreListener(this);
            refreshLayout.setOnRefreshListener(this);
            refreshLayout.autoRefresh();
        }
    }

    /**
     * 加载更多
     *
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        this.page++;
        this.isRefresh = false;
        loadData(refreshLayout, page, pageSize, false);
    }

    /**
     * 下拉刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.page = 0;
        this.isRefresh = true;
        loadData(refreshLayout, page, pageSize, true);
    }

    /**
     * 加载数据
     *
     * @param smartRefreshLayout
     * @param page               页码
     * @param isRefresh          是否刷新
     */
    public abstract void loadData(RefreshLayout smartRefreshLayout, int page, int pageSize, boolean isRefresh);
}
