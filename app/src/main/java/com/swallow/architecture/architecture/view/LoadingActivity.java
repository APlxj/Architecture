package com.swallow.architecture.architecture.view;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.swallow.architecture.architecture.MainActivity;
import com.swallow.architecture.architecture.R;
import com.swallow.architecture.architecture.contract.ILoadingContract;
import com.swallow.architecture.architecture.presenter.LoadingPresenter;
import com.swallow.architecture.mvp.base.view.CheckPermissionsActivity;

/**
 * @author swallow.li
 * @describe
 * @date 2019/5/5  17:24
 * - generate by MvpAutoCodePlus plugin.
 */
public class LoadingActivity
        extends CheckPermissionsActivity<ILoadingContract.View, ILoadingContract.Presenter>
        implements ILoadingContract.View {

    @Override
    public ILoadingContract.View createView() {
        return this;
    }

    @Override
    public ILoadingContract.Presenter createPresenter() {
        return new LoadingPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_loading;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(MainActivity.class);
            }
        });
    }

    @Override
    protected void onResume() {
        super.needPermissions = new String[]{
                Manifest.permission.CALL_PHONE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        super.onResume();
    }

    @Override
    protected void onRequestPermissionsSuccess() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

