package com.swallow.architecture.mvp.base.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.swallow.architecture.mvp.base.IActivity;
import com.swallow.architecture.mvp.callback.MvpCallback;
import com.swallow.architecture.mvp.i.IPresenter;
import com.swallow.architecture.mvp.i.IView;
import com.swallow.architecture.mvp.utils.StatusBarCompat;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * 类描述：activity基类
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseActivity<V extends IView, P extends IPresenter<V>>
        extends RxAppCompatActivity
        implements MvpCallback<V, P>, IActivity {

    protected V mView;
    protected P mPresenter;
    //选中fragment
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        process(savedInstanceState);
        setStatusBar();
        onViewCreated();
    }

    @Override
    public void process(Bundle savedInstanceState) {
        // 华为,OPPO机型在StatusBarUtil.setLightStatusBar后布局被顶到状态栏上去了
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View content = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            if (content != null && !isUseFullScreenMode()) {
                content.setFitsSystemWindows(true);
            }
        }
    }

    @Override
    public void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isUseFullScreenMode()) {
                StatusBarCompat.transparencyBar(this);
            } else {
                StatusBarCompat.setStatusBarColor(this, setStatusBarColor());
            }

            if (isUserLightMode()) {
                StatusBarCompat.setLightStatusBar(this, true);
            }
        }
    }

    private void onViewCreated() {
        //V
        mView = createView();
        //P
        if (getPresenter() == null) {
            mPresenter = createPresenter();
        }
       /* if (getPresenter() != null) {
            getPresenter().attachView(getMvpView());
        }*/
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
        return getApplicationContext();
    }

    @Override
    public void showWaitDialog(String msg) {

    }

    @Override
    public void dismissWaitDialog() {

    }

    @Override
    public void showFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            mCurrentFragment = fragment;
            transaction.commit();
        }
    }

    @Override
    public void showMsgDialog(String title, String message) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setPositiveButton("确定", null)
                .create();
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
    }

    @Override
    public void toActivity(Class<?> aClass) {
        startActivity(new Intent(this, aClass));
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isUseFullScreenMode() {
        return false;
    }

    @Override
    public int setStatusBarColor() {
        return android.R.color.transparent;
    }

    @Override
    public boolean isUserLightMode() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setMvpView(null);
        mPresenter.detachView();
        setPresenter(null);
        dismissWaitDialog();
    }
}
