package com.okawa.jetpack.arch.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import javax.inject.Inject

class PermissionsManager @Inject constructor(
    private val context: Context
) {

    fun checkPermissionsGranted(vararg permissions: String): Boolean {
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) return false
        }
        return true
    }

}