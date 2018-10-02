package org.test.kotlin.demo;

import android.util.Log;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.reactivex.plugins.RxJavaPlugins;

public class Application extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        RxJavaPlugins.setErrorHandler($ -> {
            $.printStackTrace();

            Log.e(Thread.currentThread().getName(), $.getMessage(), $);
        });

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationInjector.create();
    }

}
