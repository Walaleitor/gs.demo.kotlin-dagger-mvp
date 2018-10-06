package org.test.kotlin.demo

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import org.test.utils.log
import org.test.utils.toast

class Application : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        RxJavaPlugins.setErrorHandler { t ->
            t.log()
            t.localizedMessage.toast(this)
        }

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerApplicationInjector.create()

}
