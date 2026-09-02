package me.kavishdevar.aurix.data

object XposedRemotePrefProvider {
    fun create(): XposedRemotePref = XposedRemotePrefImpl()
}
