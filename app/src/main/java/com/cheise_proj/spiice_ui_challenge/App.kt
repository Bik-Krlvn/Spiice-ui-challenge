package com.cheise_proj.spiice_ui_challenge

import androidx.work.Configuration
import androidx.work.WorkManager
import com.cheise_proj.spiice_ui_challenge.common.FCM_GLOBAL_TOPIC
import com.cheise_proj.spiice_ui_challenge.di.DaggerAppComponent
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {
    private val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

    override fun onCreate() {
        super.onCreate()
        initWorkManager()
        initFCMService()
        initTimber()
        initFirebaseAnalytics()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initFirebaseAnalytics() {
        FirebaseAnalytics.getInstance(this)
    }

    private fun initWorkManager() {
        WorkManager.initialize(this, Configuration.Builder().run {
            setWorkerFactory(appComponent.workerFactory())
                .build()
        })
    }

    private fun initFCMService() {
        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
            if (!it.isSuccessful) {
                Timber.w("Task Failed")
                return@addOnCompleteListener
            }
            Timber.i("result: ${it.result?.token}")
        }
        FirebaseMessaging.getInstance().subscribeToTopic(FCM_GLOBAL_TOPIC).addOnCompleteListener {
            if (!it.isSuccessful) {
                Timber.w("Task Failed")
                return@addOnCompleteListener
            }
            Timber.i("subscribe global topic")
        }
    }
}