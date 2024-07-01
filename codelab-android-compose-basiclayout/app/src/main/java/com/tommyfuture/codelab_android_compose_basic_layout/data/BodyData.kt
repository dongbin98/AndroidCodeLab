package com.tommyfuture.codelab_android_compose_basic_layout.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BodyData (
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)