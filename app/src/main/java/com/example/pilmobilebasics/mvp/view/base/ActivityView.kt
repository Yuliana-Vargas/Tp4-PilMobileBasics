package com.example.pilmobilebasics.mvp.view.base

import android.app.Activity
import android.content.Context
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private var activityRef: WeakReference<Activity> = WeakReference(activity)

    private val activity: Activity?
        get() = activityRef.get()

    val context: Context?
        get() = activity
}
