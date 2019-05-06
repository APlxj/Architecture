package com.swallow.architecture.mvp.base.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.swallow.architecture.mvp.base.IFragment;
import com.swallow.architecture.mvp.callback.MvpCallback;
import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IView;
import com.trello.rxlifecycle.components.RxFragment;

import butterknife.ButterKnife;

/**
 * 类描述：fragment基类
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseFragment<V extends IView, P extends IPresenter<V>>
        extends RxFragment implements
        MvpCallback<V, P>, IFragment {

    protected V mView;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        onViewCreated();
        initView(view);
        init();
        return view;
    }

    private void onViewCreated() {
        //V
        mView = createView();
        //P
        if (getPresenter() == null) {
            mPresenter = createPresenter();
        }
        //mPresenter.attachView(getMvpView());
    }

    @Override
    public void setMvpView(V view) {
        this.mView = view;
    }

    @Override
    public V getMvpView() {
        return this.mView;
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public P getPresenter() {
        return this.mPresenter;
    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void showWaitDialog(String msg) {

    }

    @Override
    public void dismissWaitDialog() {

    }

    @Override
    public void toActivity(Class<?> aClass) {
        startActivity(new Intent(getActivity(), aClass));
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setMvpView(null);
        mPresenter.detachView();
        setPresenter(null);
        dismissWaitDialog();
    }
}
