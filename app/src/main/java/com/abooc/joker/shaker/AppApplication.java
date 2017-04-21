package com.abooc.joker.shaker;

import android.app.Application;

import com.abooc.util.Debug;

/**
 * Created by dayu on 2017/4/21.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Debug.enable(BuildConfig.DEBUG);
    }

}
