package me.kavishdevar.aurix.data

import androidx.core.content.edit
import me.kavishdevar.aurix.utils.XposedServiceHolder

class XposedRemotePrefImpl: XposedRemotePref {
    override fun isAvailable(): Boolean {
        return XposedServiceHolder.service != null
    }

    override fun getBoolean(key: String, def: Boolean): Boolean {
        val s = XposedServiceHolder.service ?: return def
        return s.getRemotePreferences("me.kavishdevar.aurix").getBoolean(key, def)
    }

    override fun putBoolean(key: String, value: Boolean) {
        val s = XposedServiceHolder.service ?: return
        s.getRemotePreferences("me.kavishdevar.aurix")
            .edit { putBoolean(key, value) }
    }
}
