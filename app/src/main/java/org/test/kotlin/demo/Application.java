package org.test.kotlin.demo;

import android.util.Log;
import android.widget.Toast;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.reactivex.plugins.RxJavaPlugins;

public class Application extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        RxJavaPlugins.setErrorHandler(t -> {
            Log.e(Thread.currentThread().getName(), t.getMessage(), t);

            Toast.makeText(this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        });

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationInjector.create();
    }

}
