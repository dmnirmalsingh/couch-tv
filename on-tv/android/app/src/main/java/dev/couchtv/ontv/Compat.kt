package dev.couchtv.ontv

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings

/**
 * Fire OS 5 (Android 5.1, API 22: Fire TV Stick 2nd gen and older). A few calls this app used were
 * added in Android 6 (API 23). These helpers give the same answer on every version, so the app
 * installs and runs on API 22 and nothing changes on newer TVs.
 */

/** Same as getSystemService(SomeClass::class.java), which only exists from API 23. */
@Suppress("UNCHECKED_CAST")
fun <T> Context.sysService(name: String): T = getSystemService(name) as T

/** Same as checkSelfPermission(...) == GRANTED, which only exists from API 23. */
fun Context.hasPermission(permission: String): Boolean =
    checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED

/** Settings.canDrawOverlays only exists from API 23. Before that "draw over apps" is granted at install. */
fun Context.canDrawOverApps(): Boolean = Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)
