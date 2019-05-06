package com.swallow.architecture.architecture.app;

import android.app.Application;
import android.os.Environment;

import com.swallow.architecture.architecture.view.LoadingActivity;

import swallow.com.model_utils.CrashUtils;
import swallow.com.model_utils.Utils;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        CrashUtils.init(Environment.getExternalStorageDirectory().getPath() + "/crash/", LoadingActivity.class);
    }
}
