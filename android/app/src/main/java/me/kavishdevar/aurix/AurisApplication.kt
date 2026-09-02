package me.kavishdevar.aurix

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import io.github.libxposed.service.XposedService
import io.github.libxposed.service.XposedServiceHelper
import me.kavishdevar.aurix.billing.BillingManager
import me.kavishdevar.aurix.billing.BillingProviderFactory
import me.kavishdevar.aurix.utils.XposedServiceHolder
import me.kavishdevar.aurix.utils.XposedState

class AurisApplication: Application(), XposedServiceHelper.OnServiceListener, DefaultLifecycleObserver {

    override fun onCreate() {
        try {
            XposedServiceHelper.registerListener(this)
        } catch (_: Exception) { }
        BillingManager.provider = BillingProviderFactory.create(this)
        try {
            ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        } catch (_: Exception) { }

        super<Application>.onCreate()

    }

    override fun onResume(owner: LifecycleOwner) {
        try {
            BillingManager.provider.queryPurchases()
            XposedState.isAvailable = XposedServiceHolder.service != null
            XposedState.bluetoothScopeEnabled = XposedServiceHolder.service?.scope?.contains("com.google.android.bluetooth") == true || XposedServiceHolder.service?.scope?.contains("com.android.bluetooth") == true
        } catch (_: Exception) { }
    }

    override fun onServiceBind(service: XposedService) {
        try {
            XposedServiceHolder.service = service
            XposedState.isAvailable = true
            XposedState.bluetoothScopeEnabled = XposedServiceHolder.service?.scope?.contains("com.google.android.bluetooth") == true || XposedServiceHolder.service?.scope?.contains("com.android.bluetooth") == true
        } catch (_: Exception) { }
    }

    override fun onServiceDied(p0: XposedService) {
        try {
            XposedServiceHolder.service = null
            XposedState.isAvailable = false
        } catch (_: Exception) { }
    }
}
